package dev.vulcanium.tag;

import com.google.common.collect.Lists;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.namespaced.Keyed;
import dev.vulcanium.namespaced.NamespacedKey;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class BaseTag<T extends Keyed, C extends BaseTag<T, C>> implements Tag<T> {
    protected final NamespacedKey key;
    protected final Set<T> tagged;
    private final List<Predicate<T>> globalPredicates;
    private boolean locked;

    public BaseTag(@NotNull Class<T> clazz, @NotNull NamespacedKey key, @NotNull Predicate<T> filter) {
        this(clazz, key);
        this.add(filter);
    }

    public BaseTag(@NotNull Class<T> clazz, @NotNull NamespacedKey key, T... values) {
        this(clazz, key, (Collection)Lists.newArrayList(values));
    }

    public BaseTag(@NotNull Class<T> clazz, @NotNull NamespacedKey key, @NotNull Collection<T> values) {
        this(clazz, key, values, (o) -> true);
    }

    @SuppressWarnings("unchecked")
    public BaseTag(@NotNull Class<T> clazz, @NotNull NamespacedKey key, @NotNull Collection<T> values, Predicate<T>... globalPredicates) {
        this.locked = false;
        this.key = key != null ? key : NamespacedKey.randomKey();
        this.tagged = (Set) (clazz.isEnum() ? this.createEnumSet((Class<? extends Enum>) clazz) : new HashSet<>());
        this.tagged.addAll(values);
        this.globalPredicates = Lists.newArrayList(globalPredicates);
    }

    private <E extends Enum<E>> Set<E> createEnumSet(Class<E> enumClass) {
        assert enumClass.isEnum();

        return EnumSet.noneOf(enumClass);
    }

    public @NotNull C lock() {
        this.locked = true;
        return (C) this;
    }

    public boolean isLocked() {
        return this.locked;
    }

    private void checkLock() {
        if (this.locked) {
            throw new UnsupportedOperationException("Tag (" + this.key + ") is locked");
        }
    }

    public @NotNull NamespacedKey getKey() {
        return this.key;
    }

    public @NotNull Set<T> getValues() {
        return Collections.unmodifiableSet(this.tagged);
    }

    public boolean isTagged(@NotNull T item) {
        return this.tagged.contains(item);
    }

    public @NotNull C add(Tag<T>... tags) {
        for (Tag<T> tag : tags) {
            this.add(tag.getValues());
        }
        return (C) this;
    }

    public @NotNull C add(T... values) {
        this.checkLock();
        this.tagged.addAll(Lists.newArrayList(values));
        return (C) this;
    }

    public @NotNull C add(@NotNull Collection<T> collection) {
        this.checkLock();
        this.tagged.addAll(collection);
        return (C) this;
    }

    public @NotNull C add(@NotNull Predicate<T> filter) {
        return this.add(this.getAllPossibleValues().stream()
                .filter(this.globalPredicates.stream().reduce(Predicate::or).orElse(t -> true))
                .filter(filter)
                .collect(Collectors.toSet()));
    }

    public @NotNull C contains(@NotNull String with) {
        return this.add(value -> this.getName(value).contains(with));
    }

    public @NotNull C endsWith(@NotNull String with) {
        return this.add(value -> this.getName(value).endsWith(with));
    }

    public @NotNull C startsWith(@NotNull String with) {
        return this.add(value -> this.getName(value).startsWith(with));
    }

    public @NotNull C not(Tag<T>... tags) {
        for (Tag<T> tag : tags) {
            this.not(tag.getValues());
        }
        return (C) this;
    }

    public @NotNull C not(T... values) {
        this.checkLock();
        this.tagged.removeAll(Lists.newArrayList(values));
        return (C) this;
    }

    public @NotNull C not(@NotNull Collection<T> values) {
        this.checkLock();
        this.tagged.removeAll(values);
        return (C) this;
    }

    public @NotNull C not(@NotNull Predicate<T> filter) {
        this.not(this.getAllPossibleValues().stream()
                .filter(this.globalPredicates.stream().reduce(Predicate::or).orElse(t -> true))
                .filter(filter)
                .collect(Collectors.toSet()));
        return (C) this;
    }

    public @NotNull C notContains(@NotNull String with) {
        return this.not(value -> this.getName(value).contains(with));
    }

    public @NotNull C notEndsWith(@NotNull String with) {
        return this.not(value -> this.getName(value).endsWith(with));
    }

    public @NotNull C notStartsWith(@NotNull String with) {
        return this.not(value -> this.getName(value).startsWith(with));
    }

    public @NotNull C ensureSize(@NotNull String label, int size) {
        long actual = this.tagged.stream()
                .filter(this.globalPredicates.stream().reduce(Predicate::or).orElse(t -> true))
                .count();
        if (size != actual) {
            throw new IllegalStateException(this.key.toString() + ": " + label + " - Expected " + size + " values, got " + actual);
        }
        return (C) this;
    }

    protected abstract @NotNull Set<T> getAllPossibleValues();

    protected abstract @NotNull String getName(@NotNull T var1);
}

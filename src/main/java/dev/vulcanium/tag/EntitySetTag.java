package dev.vulcanium.tag;

import org.jetbrains.annotations.NotNull;
import dev.vulcanium.namespaced.NamespacedKey;
import dev.vulcanium.entity.EntityType;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EntitySetTag extends BaseTag<EntityType, EntitySetTag> {
    public EntitySetTag(@NotNull NamespacedKey key, @NotNull Predicate<EntityType> filter) {
        super(EntityType.class, key, filter);
    }

    public EntitySetTag(@NotNull NamespacedKey key, EntityType... values) {
        super(EntityType.class, key, values);
    }

    public EntitySetTag(@NotNull NamespacedKey key, @NotNull Collection<EntityType> values) {
        super(EntityType.class, key, values);
    }

    public EntitySetTag(@NotNull NamespacedKey key, @NotNull Collection<EntityType> values, Predicate<EntityType>... globalPredicates) {
        super(EntityType.class, key, values, globalPredicates);
    }

    protected @NotNull Set<EntityType> getAllPossibleValues() {
        return (Set)Stream.of(EntityType.values()).collect(Collectors.toSet());
    }

    protected @NotNull String getName(@NotNull EntityType value) {
        return value.name();
    }
}

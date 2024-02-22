package dev.vulcanium.registry;

import dev.vulcanium.namespaced.Keyed;
import dev.vulcanium.namespaced.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Reference<T extends Keyed> extends Keyed {
    @NotNull T value();

    @Nullable T valueOrNull();

    static <T extends Keyed> @NotNull Reference<T> create(@NotNull Registry<T> registry, @NotNull NamespacedKey key) {
        return new ReferenceImpl(registry, key);
    }
}
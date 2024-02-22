package dev.vulcanium.namespaced;

import org.jetbrains.annotations.NotNull;

public interface Namespaced {
    @NotNull String getNamespace();

    @NotNull String getKey();
}

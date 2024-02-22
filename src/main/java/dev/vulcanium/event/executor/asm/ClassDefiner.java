package dev.vulcanium.event.executor.asm;

import org.jetbrains.annotations.NotNull;

public interface ClassDefiner {
    default boolean isBypassAccessChecks() {
        return false;
    }

    @NotNull Class<?> defineClass(@NotNull ClassLoader var1, @NotNull String var2, byte[] var3);

    static @NotNull ClassDefiner getInstance() {
        return SafeClassDefiner.INSTANCE;
    }
}

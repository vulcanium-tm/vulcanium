package dev.vulcanium.util;

import org.jetbrains.annotations.NotNull;

public class SneakyThrow {
    public SneakyThrow() {
    }

    public static void sneaky(@NotNull Throwable exception) throws Throwable {
        throwSneaky(exception);
    }

    public static <T extends Throwable> void throwSneaky(@NotNull Throwable exception) throws Throwable {
        throw exception;
    }
}
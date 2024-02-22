package dev.vulcanium.datapack;

import org.checkerframework.checker.nullness.qual.NonNull;

public interface Datapack {
    @NonNull String getName();

    @NonNull Compatibility getCompatibility();

    boolean isEnabled();

    void setEnabled(boolean var1);

    public static enum Compatibility {
        TOO_OLD,
        TOO_NEW,
        COMPATIBLE;

        private Compatibility() {
        }
    }
}

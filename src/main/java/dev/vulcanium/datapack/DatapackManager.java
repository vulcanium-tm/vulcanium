package dev.vulcanium.datapack;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;

public interface DatapackManager {
    @NonNull Collection<Datapack> getPacks();

    @NonNull Collection<Datapack> getEnabledPacks();
}

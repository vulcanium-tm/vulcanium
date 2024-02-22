package dev.vulcanium.event.entity;

import dev.vulcanium.Location;
import dev.vulcanium.entity.EntityType;
import dev.vulcanium.event.entity.CreatureSpawnEvent.SpawnReason;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PreSpawnerSpawnEvent extends PreCreatureSpawnEvent {
    private final @NotNull Location spawnerLocation;

    @Internal
    public PreSpawnerSpawnEvent(@NotNull Location location, @NotNull EntityType type, @NotNull Location spawnerLocation) {
        super(location, type, SpawnReason.SPAWNER);
        this.spawnerLocation = spawnerLocation;
    }

    public @NotNull Location getSpawnerLocation() {
        return this.spawnerLocation;
    }
}

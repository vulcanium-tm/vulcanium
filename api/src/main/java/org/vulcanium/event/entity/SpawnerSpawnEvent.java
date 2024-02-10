package org.vulcanium.event.entity;

import org.vulcanium.block.CreatureSpawner;
import org.vulcanium.entity.Entity;
import org.jetbrains.annotations.NotNull;

/**
 * Called when an entity is spawned into a world by a spawner.
 * <p>
 * If a Spawner Spawn event is cancelled, the entity will not spawn.
 */
public class SpawnerSpawnEvent extends EntitySpawnEvent {
    private final CreatureSpawner spawner;

    public SpawnerSpawnEvent(@NotNull final Entity spawnee, @NotNull final CreatureSpawner spawner) {
        super(spawnee);
        this.spawner = spawner;
    }

    @NotNull
    public CreatureSpawner getSpawner() {
        return spawner;
    }
}

package dev.vulcanium.event.entity;

import dev.vulcanium.Location;
import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.EntityType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PhantomPreSpawnEvent extends PreCreatureSpawnEvent {
    private final @NotNull Entity entity;

    @Internal
    public PhantomPreSpawnEvent(@NotNull Location location, @NotNull Entity entity, @NotNull CreatureSpawnEvent. SpawnReason reason) {
        super(location, EntityType.PHANTOM, reason);
        this.entity = entity;
    }

    public @NotNull Entity getSpawningEntity() {
        return this.entity;
    }
}

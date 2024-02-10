package org.vulcanium.event.entity;

import org.vulcanium.Location;
import org.vulcanium.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.Cancellable;
import org.vulcanium.event.HandlerList;

/**
 * Called when an entity is spawned into a world.
 * <p>
 * If an Entity Spawn event is cancelled, the entity will not spawn.
 */
public class EntitySpawnEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean canceled;

    public EntitySpawnEvent(@NotNull final Entity spawnee) {
        super(spawnee);
    }

    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        canceled = cancel;
    }

    /**
     * Gets the location at which the entity is spawning.
     *
     * @return The location at which the entity is spawning
     */
    @NotNull
    public Location getLocation() {
        return getEntity().getLocation();
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}

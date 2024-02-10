package org.vulcanium.event.entity;

import org.vulcanium.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.Cancellable;
import org.vulcanium.event.HandlerList;

/**
 * Called when an entity stops riding another entity.
 */
public class EntityDismountEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Entity dismounted;

    public EntityDismountEvent(@NotNull Entity what, @NotNull Entity dismounted) {
        super(what);
        this.dismounted = dismounted;
    }

    /**
     * Gets the entity which will no longer be ridden.
     *
     * @return dismounted entity
     */
    @NotNull
    public Entity getDismounted() {
        return dismounted;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
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

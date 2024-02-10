package org.vulcanium.event.entity;

import org.vulcanium.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.Cancellable;
import org.vulcanium.event.HandlerList;

/**
 * Called when an entity attempts to ride another entity.
 */
public class EntityMountEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Entity mount;

    public EntityMountEvent(@NotNull Entity what, @NotNull Entity mount) {
        super(what);
        this.mount = mount;
    }

    /**
     * Gets the entity which will be ridden.
     *
     * @return mounted entity
     */
    @NotNull
    public Entity getMount() {
        return mount;
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

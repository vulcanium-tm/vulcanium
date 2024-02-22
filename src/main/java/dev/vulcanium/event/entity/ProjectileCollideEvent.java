package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.Projectile;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

/** @deprecated */
@Deprecated
public class ProjectileCollideEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull Entity collidedWith;
    private boolean cancelled;

    @Internal
    public ProjectileCollideEvent(@NotNull Projectile projectile, @NotNull Entity collidedWith) {
        super(projectile);
        this.collidedWith = collidedWith;
    }

    public @NotNull Projectile getEntity() {
        return (Projectile)super.getEntity();
    }

    public @NotNull Entity getCollidedWith() {
        return this.collidedWith;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}

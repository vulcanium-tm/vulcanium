package org.vulcanium.event.entity;

import org.vulcanium.entity.Entity;
import org.vulcanium.entity.Projectile;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.Cancellable;

/**
 * Called when a projectile is launched.
 */
public class ProjectileLaunchEvent extends EntitySpawnEvent implements Cancellable {
    private boolean cancelled;

    public ProjectileLaunchEvent(@NotNull Entity what) {
        super(what);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    @NotNull
    @Override
    public Projectile getEntity() {
        return (Projectile) entity;
    }
}

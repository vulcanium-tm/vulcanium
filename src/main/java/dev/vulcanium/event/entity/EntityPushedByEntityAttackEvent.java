package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Entity;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EntityPushedByEntityAttackEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull Entity pushedBy;
    private @NotNull Vector acceleration;
    private boolean cancelled;

    @Internal
    public EntityPushedByEntityAttackEvent(@NotNull Entity entity, @NotNull Entity pushedBy, @NotNull Vector acceleration) {
        super(entity);
        this.pushedBy = pushedBy;
        this.acceleration = acceleration;
    }

    public @NotNull Entity getPushedBy() {
        return this.pushedBy;
    }

    public @NotNull Vector getAcceleration() {
        return this.acceleration;
    }

    public void setAcceleration(@NotNull Vector acceleration) {
        this.acceleration = acceleration.clone();
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

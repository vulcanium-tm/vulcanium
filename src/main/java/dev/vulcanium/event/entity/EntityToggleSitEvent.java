package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Entity;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EntityToggleSitEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final boolean isSitting;
    private boolean cancelled;

    @Internal
    public EntityToggleSitEvent(@NotNull Entity entity, boolean isSitting) {
        super(entity);
        this.isSitting = isSitting;
    }

    public boolean getSittingState() {
        return this.isSitting;
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

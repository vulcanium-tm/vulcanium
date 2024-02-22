package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Enderman;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EndermanEscapeEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull Reason reason;
    private boolean cancelled;

    @Internal
    public EndermanEscapeEvent(@NotNull Enderman entity, @NotNull Reason reason) {
        super(entity);
        this.reason = reason;
    }

    public @NotNull Enderman getEntity() {
        return (Enderman)super.getEntity();
    }

    public @NotNull Reason getReason() {
        return this.reason;
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

    public static enum Reason {
        RUNAWAY,
        INDIRECT,
        CRITICAL_HIT,
        STARE,
        DROWN;

        private Reason() {
        }
    }
}

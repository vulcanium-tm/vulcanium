package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Creeper;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class CreeperIgniteEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private boolean ignited;
    private boolean cancelled;

    @Internal
    public CreeperIgniteEvent(@NotNull Creeper creeper, boolean ignited) {
        super(creeper);
        this.ignited = ignited;
    }

    public @NotNull Creeper getEntity() {
        return (Creeper)super.getEntity();
    }

    public boolean isIgnited() {
        return this.ignited;
    }

    public void setIgnited(boolean ignited) {
        this.ignited = ignited;
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

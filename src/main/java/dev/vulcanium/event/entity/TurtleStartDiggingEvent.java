package dev.vulcanium.event.entity;

import dev.vulcanium.Location;
import dev.vulcanium.entity.Turtle;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class TurtleStartDiggingEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull Location location;
    private boolean cancelled;

    @Internal
    public TurtleStartDiggingEvent(@NotNull Turtle turtle, @NotNull Location location) {
        super(turtle);
        this.location = location;
    }

    public @NotNull Turtle getEntity() {
        return (Turtle)super.getEntity();
    }

    public @NotNull Location getLocation() {
        return this.location;
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

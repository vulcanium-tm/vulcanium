package dev.vulcanium.event.entity;

import dev.vulcanium.Location;
import dev.vulcanium.entity.Turtle;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class TurtleLayEggEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull Location location;
    private int eggCount;
    private boolean cancelled;

    @Internal
    public TurtleLayEggEvent(@NotNull Turtle turtle, @NotNull Location location, int eggCount) {
        super(turtle);
        this.location = location;
        this.eggCount = eggCount;
    }

    public @NotNull Turtle getEntity() {
        return (Turtle)super.getEntity();
    }

    public @NotNull Location getLocation() {
        return this.location;
    }

    public int getEggCount() {
        return this.eggCount;
    }

    public void setEggCount(int eggCount) {
        if (eggCount < 1) {
            this.cancelled = true;
        } else {
            this.eggCount = Math.min(eggCount, 4);
        }
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

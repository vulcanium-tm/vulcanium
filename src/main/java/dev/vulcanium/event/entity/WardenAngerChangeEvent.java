package dev.vulcanium.event.entity;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.annotation.Range;
import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.Warden;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;

public class WardenAngerChangeEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Entity target;
    private final int oldAnger;
    private int newAnger;
    private boolean cancelled;

    @Internal
    public WardenAngerChangeEvent(@NotNull Warden warden, @NotNull Entity target, int oldAnger, int newAnger) {
        super(warden);
        this.target = target;
        this.oldAnger = oldAnger;
        this.newAnger = newAnger;
    }

    public @NotNull Entity getTarget() {
        return this.target;
    }

    public @Range(
            from = 0L,
            to = 150L
    ) int getOldAnger() {
        return this.oldAnger;
    }

    public @Range(
            from = 0L,
            to = 150L
    ) int getNewAnger() {
        return this.newAnger;
    }

    public void setNewAnger(@Range(
            from = 0L,
            to = 150L
    ) int newAnger) {
        Preconditions.checkArgument(newAnger <= 150, "newAnger must not be greater than 150");
        this.newAnger = newAnger;
    }

    public @NotNull Warden getEntity() {
        return (Warden)super.getEntity();
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

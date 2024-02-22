package dev.vulcanium.event.entity;

import dev.vulcanium.entity.PufferFish;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PufferFishStateChangeEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final int newPuffState;
    private boolean cancelled;

    @Internal
    public PufferFishStateChangeEvent(@NotNull PufferFish entity, int newPuffState) {
        super(entity);
        this.newPuffState = newPuffState;
    }

    public @NotNull PufferFish getEntity() {
        return (PufferFish)super.getEntity();
    }

    public int getNewPuffState() {
        return this.newPuffState;
    }

    public boolean isInflating() {
        return this.newPuffState > this.getEntity().getPuffState();
    }

    public boolean isDeflating() {
        return this.newPuffState < this.getEntity().getPuffState();
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

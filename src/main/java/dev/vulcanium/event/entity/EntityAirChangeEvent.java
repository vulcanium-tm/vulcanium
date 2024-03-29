package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Entity;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;

/**
 * Called when the amount of air an entity has remaining changes.
 */
public class EntityAirChangeEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private int amount;
    //
    private boolean cancelled;

    public EntityAirChangeEvent(@NotNull Entity what, int amount) {
        super(what);
        this.amount = amount;
    }

    /**
     * Gets the amount of air the entity has left (measured in ticks).
     *
     * @return amount of air remaining
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets the amount of air remaining for the entity (measured in ticks.
     *
     * @param amount amount of air remaining
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}

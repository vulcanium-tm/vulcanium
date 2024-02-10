package org.vulcanium.event.block;

import org.vulcanium.block.Block;
import org.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.HandlerList;

/**
 * Called when a brewing stand starts to brew.
 */
public class BrewingStartEvent extends InventoryBlockStartEvent {

    private static final HandlerList handlers = new HandlerList();
    private int brewingTime;

    public BrewingStartEvent(@NotNull final Block furnace, @NotNull ItemStack source, int brewingTime) {
        super(furnace, source);
        this.brewingTime = brewingTime;
    }

    /**
     * Gets the total brew time associated with this event.
     *
     * @return the total brew time
     */
    public int getTotalBrewTime() {
        return brewingTime;
    }

    /**
     * Sets the total brew time for this event.
     *
     * @param brewTime the new total brew time
     */
    public void setTotalBrewTime(int brewTime) {
        this.brewingTime = brewTime;
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

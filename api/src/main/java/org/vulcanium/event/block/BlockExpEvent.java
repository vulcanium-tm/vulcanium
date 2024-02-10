package org.vulcanium.event.block;

import org.vulcanium.block.Block;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.HandlerList;

/**
 * An event that's called when a block yields experience.
 */
public class BlockExpEvent extends BlockEvent {
    private static final HandlerList handlers = new HandlerList();
    private int exp;

    public BlockExpEvent(@NotNull Block block, int exp) {
        super(block);

        this.exp = exp;
    }

    /**
     * Get the experience dropped by the block after the event has processed
     *
     * @return The experience to drop
     */
    public int getExpToDrop() {
        return exp;
    }

    /**
     * Set the amount of experience dropped by the block after the event has
     * processed
     *
     * @param exp 1 or higher to drop experience, else nothing will drop
     */
    public void setExpToDrop(int exp) {
        this.exp = exp;
    }

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}

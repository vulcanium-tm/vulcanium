package org.vulcanium.event.block;

import org.vulcanium.block.Block;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.Event;

/**
 * Represents a block related event.
 */
public abstract class BlockEvent extends Event {
    protected Block block;

    public BlockEvent(@NotNull final Block theBlock) {
        block = theBlock;
    }

    /**
     * Gets the block involved in this event.
     *
     * @return The Block which block is involved in this event
     */
    @NotNull
    public final Block getBlock() {
        return block;
    }
}

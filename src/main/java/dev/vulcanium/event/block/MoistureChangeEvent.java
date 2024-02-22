package dev.vulcanium.event.block;

import dev.vulcanium.block.Block;
import dev.vulcanium.block.BlockState;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;

/**
 * Called when the moisture level of a soil block changes.
 */
public class MoistureChangeEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final BlockState newState;

    public MoistureChangeEvent(@NotNull final Block block, @NotNull final BlockState newState) {
        super(block);
        this.newState = newState;
        this.cancelled = false;
    }

    /**
     * Gets the new state of the affected block.
     *
     * @return new block state
     */
    @NotNull
    public BlockState getNewState() {
        return newState;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
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

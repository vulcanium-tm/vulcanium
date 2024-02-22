package dev.vulcanium.event.block;

import dev.vulcanium.block.Block;
import dev.vulcanium.block.BlockFace;
import dev.vulcanium.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;

/**
 * Called when a bell is being rung.
 */
public class BellRingEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final BlockFace direction;
    private final Entity entity;
    private boolean cancelled;

    public BellRingEvent(@NotNull Block theBlock, @NotNull BlockFace direction, @Nullable Entity entity) {
        super(theBlock);
        this.direction = direction;
        this.entity = entity;
    }

    /**
     * Get the direction in which the bell was rung.
     *
     * @return the direction
     */
    @NotNull
    public BlockFace getDirection() {
        return direction;
    }

    /**
     * Get the {@link Entity} that rang the bell (if there was one).
     *
     * @return the entity
     */
    @Nullable
    public Entity getEntity() {
        return entity;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
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

package dev.vulcanium.event.block;

import dev.vulcanium.block.Block;
import dev.vulcanium.entity.Entity;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;

/**
 * Event fired when a dispenser shears a nearby sheep.
 */
public class BlockShearEntityEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private final Entity sheared;
    private final ItemStack tool;
    private boolean cancelled;

    public BlockShearEntityEvent(@NotNull Block dispenser, @NotNull Entity sheared, @NotNull ItemStack tool) {
        super(dispenser);
        this.sheared = sheared;
        this.tool = tool;
    }

    /**
     * Gets the entity that was sheared.
     *
     * @return the entity that was sheared.
     */
    @NotNull
    public Entity getEntity() {
        return sheared;
    }

    /**
     * Gets the item used to shear this sheep.
     *
     * @return the item used to shear this sheep.
     */
    @NotNull
    public ItemStack getTool() {
        return tool.clone();
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

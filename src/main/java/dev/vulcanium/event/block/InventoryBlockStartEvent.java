package dev.vulcanium.event.block;

import dev.vulcanium.block.Block;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.event.inventory.FurnaceStartSmeltEvent;

/**
 * Used when:
 * <ul>
 * <li>A Furnace starts smelting {@link FurnaceStartSmeltEvent}</li>
 * <li>A Brewing-Stand starts brewing {@link BrewingStartEvent}</li>
 * <li>A Campfire starts cooking {@link CampfireStartEvent}</li>
 * </ul>
 *
 * @apiNote draft API
 */
@ApiStatus.Experimental
public class InventoryBlockStartEvent extends BlockEvent {

    private static final HandlerList handlers = new HandlerList();
    private final ItemStack source;

    public InventoryBlockStartEvent(@NotNull final Block block, @NotNull ItemStack source) {
        super(block);
        this.source = source;
    }

    /**
     * Gets the source ItemStack for this event.
     *
     * @return the source ItemStack
     */
    @NotNull
    public ItemStack getSource() {
        return source;
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

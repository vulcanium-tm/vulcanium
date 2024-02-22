package dev.vulcanium.event.inventory;

import dev.vulcanium.block.Block;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.block.BlockCookEvent;

/**
 * Called when an ItemStack is successfully smelted in a furnace.
 */
public class FurnaceSmeltEvent extends BlockCookEvent {

    public FurnaceSmeltEvent(@NotNull final Block furnace, @NotNull final ItemStack source, @NotNull final ItemStack result) {
        super(furnace, source, result);
    }
}

package dev.vulcanium.block;

import dev.vulcanium.inventory.ItemStack;
import dev.vulcanium.loot.Lootable;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a captured state of suspicious sand or gravel.
 */
public interface BrushableBlock extends Lootable, TileState {

    /**
     * Get the item which will be revealed when the sand is fully brushed away
     * and uncovered.
     *
     * @return the item
     */
    @Nullable
    public ItemStack getItem();

    /**
     * Sets the item which will be revealed when the sand is fully brushed away
     * and uncovered.
     *
     * @param item the item
     */
    public void setItem(@Nullable ItemStack item);
}

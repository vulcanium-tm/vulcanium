package dev.vulcanium.inventory;

import dev.vulcanium.block.DoubleChest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Interface to the inventory of a Double Chest.
 */
public interface DoubleChestInventory extends Inventory {

    /**
     * Get the left half of this double chest.
     *
     * @return The left side inventory
     */
    @NotNull
    Inventory getLeftSide();

    /**
     * Get the right side of this double chest.
     *
     * @return The right side inventory
     */
    @NotNull
    Inventory getRightSide();

    @Override
    @Nullable
    DoubleChest getHolder();
}

package org.vulcanium.block;

import org.vulcanium.Location;
import org.vulcanium.World;
import org.vulcanium.inventory.DoubleChestInventory;
import org.vulcanium.inventory.Inventory;
import org.vulcanium.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a double chest.
 */
public class DoubleChest implements InventoryHolder {
    private DoubleChestInventory inventory;

    public DoubleChest(@NotNull DoubleChestInventory chest) {
        inventory = chest;
    }

    @Override
    @NotNull
    public Inventory getInventory() {
        return inventory;
    }

    @Nullable
    public InventoryHolder getLeftSide() {
        return inventory.getLeftSide().getHolder();
    }

    @Nullable
    public InventoryHolder getRightSide() {
        return inventory.getRightSide().getHolder();
    }

    @NotNull
    public Location getLocation() {
        return getInventory().getLocation();
    }

    @Nullable
    public World getWorld() {
        return getLocation().getWorld();
    }

    public double getX() {
        return getLocation().getX();
    }

    public double getY() {
        return getLocation().getY();
    }

    public double getZ() {
        return getLocation().getZ();
    }
}

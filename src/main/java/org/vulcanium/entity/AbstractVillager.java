package org.vulcanium.entity;

import org.vulcanium.inventory.Inventory;
import org.vulcanium.inventory.InventoryHolder;
import org.vulcanium.inventory.Merchant;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a villager NPC
 */
public interface AbstractVillager extends Breedable, NPC, InventoryHolder, Merchant {

    /**
     * Gets this villager's inventory.
     * <br>
     * Note that this inventory is not the Merchant inventory, rather, it is the
     * items that a villager might have collected (from harvesting crops, etc.)
     *
     * {@inheritDoc}
     */
    @NotNull
    @Override
    Inventory getInventory();
}

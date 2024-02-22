package dev.vulcanium.entity;

import dev.vulcanium.inventory.InventoryHolder;
import dev.vulcanium.loot.Lootable;

/**
 * A {@link Boat} with a chest.
 */
public interface ChestBoat extends Boat, InventoryHolder, Lootable {
}

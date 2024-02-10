package org.vulcanium.entity;

import org.vulcanium.inventory.InventoryHolder;
import org.vulcanium.loot.Lootable;

/**
 * A {@link Boat} with a chest.
 */
public interface ChestBoat extends Boat, InventoryHolder, Lootable {
}

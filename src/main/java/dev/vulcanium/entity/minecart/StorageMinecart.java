package dev.vulcanium.entity.minecart;

import dev.vulcanium.inventory.InventoryHolder;
import dev.vulcanium.loot.Lootable;
import dev.vulcanium.entity.Minecart;

/**
 * Represents a minecart with a chest. These types of {@link Minecart
 * minecarts} have their own inventory that can be accessed using methods
 * from the {@link InventoryHolder} interface.
 */
public interface StorageMinecart extends Minecart, InventoryHolder, Lootable {
}

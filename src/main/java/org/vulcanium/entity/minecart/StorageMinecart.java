package org.vulcanium.entity.minecart;

import org.vulcanium.inventory.InventoryHolder;
import org.vulcanium.loot.Lootable;
import org.vulcanium.entity.Minecart;

/**
 * Represents a minecart with a chest. These types of {@link Minecart
 * minecarts} have their own inventory that can be accessed using methods
 * from the {@link InventoryHolder} interface.
 */
public interface StorageMinecart extends Minecart, InventoryHolder, Lootable {
}

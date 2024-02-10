package org.vulcanium.event.inventory;

import org.vulcanium.event.inventory.InventoryType.SlotType;
import org.vulcanium.inventory.InventoryView;
import org.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * This event is called when a player in creative mode puts down or picks up
 * an item in their inventory / hotbar and when they drop items from their
 * Inventory while in creative mode.
 */
public class InventoryCreativeEvent extends InventoryClickEvent {
    private ItemStack item;

    public InventoryCreativeEvent(@NotNull InventoryView what, @NotNull SlotType type, int slot, @NotNull ItemStack newItem) {
        super(what, type, slot, ClickType.CREATIVE, InventoryAction.PLACE_ALL);
        this.item = newItem;
    }

    @Override
    @NotNull
    public ItemStack getCursor() {
        return item;
    }

    @Override
    public void setCursor(@NotNull ItemStack item) {
        this.item = item;
    }
}

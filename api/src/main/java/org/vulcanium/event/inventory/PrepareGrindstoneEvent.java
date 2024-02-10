package org.vulcanium.event.inventory;

import org.vulcanium.inventory.GrindstoneInventory;
import org.vulcanium.inventory.InventoryView;
import org.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.vulcanium.event.HandlerList;

/**
 * Called when an item is put in a slot for repair or unenchanting in a grindstone.
 */
public class PrepareGrindstoneEvent extends PrepareInventoryResultEvent {

    private static final HandlerList handlers = new HandlerList();

    public PrepareGrindstoneEvent(@NotNull InventoryView inventory, @Nullable ItemStack result) {
        super(inventory, result);
    }

    @NotNull
    @Override
    public GrindstoneInventory getInventory() {
        return (GrindstoneInventory) super.getInventory();
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}

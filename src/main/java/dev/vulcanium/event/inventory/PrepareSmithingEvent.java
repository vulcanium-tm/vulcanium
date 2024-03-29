package dev.vulcanium.event.inventory;

import dev.vulcanium.inventory.InventoryView;
import dev.vulcanium.inventory.ItemStack;
import dev.vulcanium.inventory.SmithingInventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import dev.vulcanium.event.HandlerList;

/**
 * Called when an item is put in a slot for upgrade by a Smithing Table.
 */
public class PrepareSmithingEvent extends PrepareInventoryResultEvent {

    private static final HandlerList handlers = new HandlerList();

    public PrepareSmithingEvent(@NotNull InventoryView inventory, @Nullable ItemStack result) {
        super(inventory, result);
    }

    @NotNull
    @Override
    public SmithingInventory getInventory() {
        return (SmithingInventory) super.getInventory();
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

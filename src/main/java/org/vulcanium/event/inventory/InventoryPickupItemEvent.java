package org.vulcanium.event.inventory;

import org.vulcanium.entity.Item;
import org.vulcanium.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.Cancellable;
import org.vulcanium.event.Event;
import org.vulcanium.event.HandlerList;

/**
 * Called when a hopper or hopper minecart picks up a dropped item.
 */
public class InventoryPickupItemEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Inventory inventory;
    private final Item item;

    public InventoryPickupItemEvent(@NotNull final Inventory inventory, @NotNull final Item item) {
        super();
        this.inventory = inventory;
        this.item = item;
    }

    /**
     * Gets the Inventory that picked up the item
     *
     * @return Inventory
     */
    @NotNull
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Gets the Item entity that was picked up
     *
     * @return Item
     */
    @NotNull
    public Item getItem() {
        return item;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
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

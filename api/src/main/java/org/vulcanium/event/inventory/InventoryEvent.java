
package org.vulcanium.event.inventory;

import java.util.List;
import org.vulcanium.entity.HumanEntity;
import org.vulcanium.inventory.Inventory;
import org.vulcanium.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.Event;
import org.vulcanium.event.HandlerList;

/**
 * Represents a player related inventory event
 */
public class InventoryEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    protected InventoryView transaction;

    public InventoryEvent(@NotNull InventoryView transaction) {
        this.transaction = transaction;
    }

    /**
     * Gets the primary Inventory involved in this transaction
     *
     * @return The upper inventory.
     */
    @NotNull
    public Inventory getInventory() {
        return transaction.getTopInventory();
    }

    /**
     * Gets the list of players viewing the primary (upper) inventory involved
     * in this event
     *
     * @return A list of people viewing.
     */
    @NotNull
    public List<HumanEntity> getViewers() {
        return transaction.getTopInventory().getViewers();
    }

    /**
     * Gets the view object itself
     *
     * @return InventoryView
     */
    @NotNull
    public InventoryView getView() {
        return transaction;
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
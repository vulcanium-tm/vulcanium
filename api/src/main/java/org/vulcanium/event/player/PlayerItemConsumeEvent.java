package org.vulcanium.event.player;

import org.vulcanium.Material;
import org.vulcanium.entity.Player;
import org.vulcanium.inventory.EquipmentSlot;
import org.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.vulcanium.event.Cancellable;
import org.vulcanium.event.HandlerList;

/**
 * This event will fire when a player is finishing consuming an item (food,
 * potion, milk bucket).
 * <br>
 * If the ItemStack is modified the server will use the effects of the new
 * item and not remove the original one from the player's inventory.
 * <br>
 * If the event is cancelled the effect will not be applied and the item will
 * not be removed from the player's inventory.
 */
public class PlayerItemConsumeEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean isCancelled = false;
    private ItemStack item;
    private final EquipmentSlot hand;

    /**
     * @param player the player consuming
     * @param item the ItemStack being consumed
     * @param hand the hand that was used
     */
    public PlayerItemConsumeEvent(@NotNull final Player player, @NotNull final ItemStack item, @NotNull final EquipmentSlot hand) {
        super(player);

        this.item = item;
        this.hand = hand;
    }

    /**
     * @param player the player consuming
     * @param item the ItemStack being consumed
     * @deprecated use {@link #PlayerItemConsumeEvent(Player, ItemStack, EquipmentSlot)}
     */
    @Deprecated
    public PlayerItemConsumeEvent(@NotNull final Player player, @NotNull final ItemStack item) {
        this(player, item, EquipmentSlot.HAND);
    }

    /**
     * Gets the item that is being consumed. Modifying the returned item will
     * have no effect, you must use {@link
     * #setItem(ItemStack)} instead.
     *
     * @return an ItemStack for the item being consumed
     */
    @NotNull
    public ItemStack getItem() {
        return item.clone();
    }

    /**
     * Set the item being consumed
     *
     * @param item the item being consumed
     */
    public void setItem(@Nullable ItemStack item) {
        if (item == null) {
            this.item = new ItemStack(Material.AIR);
        } else {
            this.item = item;
        }
    }

    /**
     * Get the hand used to consume the item.
     *
     * @return the hand
     */
    @NotNull
    public EquipmentSlot getHand() {
        return hand;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
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
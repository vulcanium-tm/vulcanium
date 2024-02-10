package org.vulcanium.event.hanging;

import org.vulcanium.block.Block;
import org.vulcanium.block.BlockFace;
import org.vulcanium.entity.Hanging;
import org.vulcanium.entity.Player;
import org.vulcanium.inventory.EquipmentSlot;
import org.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.vulcanium.event.Cancellable;
import org.vulcanium.event.HandlerList;

/**
 * Triggered when a hanging entity is created in the world
 */
public class HangingPlaceEvent extends HangingEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Player player;
    private final Block block;
    private final BlockFace blockFace;
    private final EquipmentSlot hand;
    private final ItemStack itemStack;

    @Deprecated
    public HangingPlaceEvent(@NotNull final Hanging hanging, @Nullable final Player player, @NotNull final Block block, @NotNull final BlockFace blockFace, @Nullable final EquipmentSlot hand) {
        this(hanging, player, block, blockFace, hand, null);
    }

    public HangingPlaceEvent(@NotNull final Hanging hanging, @Nullable final Player player, @NotNull final Block block, @NotNull final BlockFace blockFace, @Nullable final EquipmentSlot hand, @Nullable ItemStack itemStack) {
        super(hanging);
        this.player = player;
        this.block = block;
        this.blockFace = blockFace;
        this.hand = hand;
        this.itemStack = itemStack;
    }

    /**
     * Returns the player placing the hanging entity
     *
     * @return the player placing the hanging entity
     */
    @Nullable
    public Player getPlayer() {
        return player;
    }

    /**
     * Returns the block that the hanging entity was placed on
     *
     * @return the block that the hanging entity was placed on
     */
    @NotNull
    public Block getBlock() {
        return block;
    }

    /**
     * Returns the face of the block that the hanging entity was placed on
     *
     * @return the face of the block that the hanging entity was placed on
     */
    @NotNull
    public BlockFace getBlockFace() {
        return blockFace;
    }

    /**
     * Returns the hand that was used to place the hanging entity, or null
     * if a player did not place the hanging entity.
     *
     * @return the hand
     */
    @Nullable
    public EquipmentSlot getHand() {
        return hand;
    }

    /**
     * Gets the item from which the hanging entity originated
     *
     * @return the item from which the hanging entity originated
     */
    @Nullable
    public ItemStack getItemStack() {
        return itemStack;
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
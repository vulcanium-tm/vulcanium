package org.vulcanium.event.entity;

import org.vulcanium.block.Block;
import org.vulcanium.block.BlockFace;
import org.vulcanium.entity.Entity;
import org.vulcanium.entity.Player;
import org.vulcanium.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.vulcanium.event.Cancellable;
import org.vulcanium.event.HandlerList;

/**
 * Triggered when a entity is created in the world by a player "placing" an item
 * on a block.
 * <br>
 * Note that this event is currently only fired for four specific placements:
 * armor stands, boats, minecarts, and end crystals.
 */
public class EntityPlaceEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Player player;
    private final Block block;
    private final BlockFace blockFace;
    private final EquipmentSlot hand;

    public EntityPlaceEvent(@NotNull final Entity entity, @Nullable final Player player, @NotNull final Block block, @NotNull final BlockFace blockFace, @NotNull final EquipmentSlot hand) {
        super(entity);
        this.player = player;
        this.block = block;
        this.blockFace = blockFace;
        this.hand = hand;
    }

    @Deprecated
    public EntityPlaceEvent(@NotNull final Entity entity, @Nullable final Player player, @NotNull final Block block, @NotNull final BlockFace blockFace) {
        this(entity, player, block, blockFace, EquipmentSlot.HAND);
    }

    /**
     * Returns the player placing the entity
     *
     * @return the player placing the entity
     */
    @Nullable
    public Player getPlayer() {
        return player;
    }

    /**
     * Returns the block that the entity was placed on
     *
     * @return the block that the entity was placed on
     */
    @NotNull
    public Block getBlock() {
        return block;
    }

    /**
     * Returns the face of the block that the entity was placed on
     *
     * @return the face of the block that the entity was placed on
     */
    @NotNull
    public BlockFace getBlockFace() {
        return blockFace;
    }

    /**
     * Get the hand used to place the entity.
     *
     * @return the hand
     */
    @NotNull
    public EquipmentSlot getHand() {
        return hand;
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
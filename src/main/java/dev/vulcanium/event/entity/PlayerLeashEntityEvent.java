package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.Player;
import dev.vulcanium.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;

/**
 * Called immediately prior to a creature being leashed by a player.
 */
public class PlayerLeashEntityEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Entity leashHolder;
    private final Entity entity;
    private boolean cancelled = false;
    private final Player player;
    private final EquipmentSlot hand;

    public PlayerLeashEntityEvent(@NotNull Entity what, @NotNull Entity leashHolder, @NotNull Player leasher, @NotNull EquipmentSlot hand) {
        this.leashHolder = leashHolder;
        this.entity = what;
        this.player = leasher;
        this.hand = hand;
    }

    @Deprecated
    public PlayerLeashEntityEvent(@NotNull Entity what, @NotNull Entity leashHolder, @NotNull Player leasher) {
        this(what, leashHolder, leasher, EquipmentSlot.HAND);
    }

    /**
     * Returns the entity that is holding the leash.
     *
     * @return The leash holder
     */
    @NotNull
    public Entity getLeashHolder() {
        return leashHolder;
    }

    /**
     * Returns the entity being leashed.
     *
     * @return The entity
     */
    @NotNull
    public Entity getEntity() {
        return entity;
    }

    /**
     * Returns the player involved in this event
     *
     * @return Player who is involved in this event
     */
    @NotNull
    public final Player getPlayer() {
        return player;
    }

    /**
     * Returns the hand used by the player to leash the entity.
     *
     * @return the hand
     */
    @NotNull
    public EquipmentSlot getHand() {
        return hand;
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

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}

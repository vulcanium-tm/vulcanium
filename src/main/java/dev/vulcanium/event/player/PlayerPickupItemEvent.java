package dev.vulcanium.event.player;

import dev.vulcanium.annotation.Warning;
import dev.vulcanium.entity.Item;
import dev.vulcanium.entity.Player;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.event.entity.EntityPickupItemEvent;

/**
 * Thrown when a player picks an item up from the ground
 * @deprecated {@link EntityPickupItemEvent}
 */
@Deprecated
@Warning(false)
public class PlayerPickupItemEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Item item;
    private boolean cancel = false;
    private final int remaining;

    public PlayerPickupItemEvent(@NotNull final Player player, @NotNull final Item item, final int remaining) {
        super(player);
        this.item = item;
        this.remaining = remaining;
    }

    /**
     * Gets the Item picked up by the player.
     *
     * @return Item
     */
    @NotNull
    public Item getItem() {
        return item;
    }

    /**
     * Gets the amount remaining on the ground, if any
     *
     * @return amount remaining on the ground
     */
    public int getRemaining() {
        return remaining;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
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

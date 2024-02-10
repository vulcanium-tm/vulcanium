package org.vulcanium.event.player;

import org.vulcanium.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.Cancellable;
import org.vulcanium.event.HandlerList;

/**
 * Called when a player toggles their sneaking state
 */
public class PlayerToggleSneakEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final boolean isSneaking;
    private boolean cancel = false;

    public PlayerToggleSneakEvent(@NotNull final Player player, final boolean isSneaking) {
        super(player);
        this.isSneaking = isSneaking;
    }

    /**
     * Returns whether the player is now sneaking or not.
     *
     * @return sneaking state
     */
    public boolean isSneaking() {
        return isSneaking;
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

package dev.vulcanium.event.player;

import dev.vulcanium.block.Sign;
import dev.vulcanium.block.sign.Side;
import dev.vulcanium.entity.Player;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;

/**
 * This event is fired when a sign is opened by the player.
 */
@ApiStatus.Experimental
public class PlayerSignOpenEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Sign sign;
    private final Side side;
    private final Cause cause;
    private boolean cancelled;

    public PlayerSignOpenEvent(@NotNull final Player player, @NotNull final Sign sign, @NotNull final Side side, @NotNull final Cause cause) {
        super(player);
        this.sign = sign;
        this.side = side;
        this.cause = cause;
    }

    /**
     * Gets the sign that was opened.
     *
     * @return opened sign
     */
    @NotNull
    public Sign getSign() {
        return this.sign;
    }

    /**
     * Gets side of the sign opened.
     *
     * @return side of sign opened
     */
    @NotNull
    public Side getSide() {
        return this.side;
    }

    /**
     * Gets the cause of the sign open.
     *
     * @return sign open cause
     */
    @NotNull
    public Cause getCause() {
        return this.cause;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
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

    @ApiStatus.Experimental
    public enum Cause {

        /**
         * Indicate the sign was opened because of an interaction.
         */
        INTERACT,
        /**
         * Indicate the sign was opened because the sign was placed.
         */
        PLACE,
        /**
         * Indicate the sign was opened because of a plugin.
         */
        PLUGIN,
        /**
         * Indicate the sign was opened for an unknown reason.
         */
        UNKNOWN;
    }
}

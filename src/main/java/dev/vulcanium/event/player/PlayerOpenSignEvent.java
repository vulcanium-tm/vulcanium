package dev.vulcanium.event.player;

import dev.vulcanium.block.Sign;
import dev.vulcanium.block.sign.Side;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;

public class PlayerOpenSignEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Sign sign;
    private final Side side;
    private final Cause cause;
    private boolean cancelled;

    @Internal
    public PlayerOpenSignEvent(@NotNull Player editor, @NotNull Sign sign, @NotNull Side side, @NotNull Cause cause) {
        super(editor);
        this.sign = sign;
        this.side = side;
        this.cause = cause;
    }

    public @NotNull Sign getSign() {
        return this.sign;
    }

    public @NotNull Side getSide() {
        return this.side;
    }

    public @NotNull Cause getCause() {
        return this.cause;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public static enum Cause {
        PLACE,
        INTERACT,
        PLUGIN,
        UNKNOWN;

        private Cause() {
        }
    }
}

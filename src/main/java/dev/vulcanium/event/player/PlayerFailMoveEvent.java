package dev.vulcanium.event.player;

import dev.vulcanium.Location;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerFailMoveEvent extends PlayerEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final FailReason failReason;
    private final Location from;
    private final Location to;
    private boolean allowed;
    private boolean logWarning;

    @Internal
    public PlayerFailMoveEvent(@NotNull Player player, @NotNull FailReason failReason, boolean allowed, boolean logWarning, @NotNull Location from, @NotNull Location to) {
        super(player);
        this.failReason = failReason;
        this.allowed = allowed;
        this.logWarning = logWarning;
        this.from = from;
        this.to = to;
    }

    public @NotNull FailReason getFailReason() {
        return this.failReason;
    }

    public @NotNull Location getFrom() {
        return this.from.clone();
    }

    public @NotNull Location getTo() {
        return this.to.clone();
    }

    public boolean isAllowed() {
        return this.allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    public boolean getLogWarning() {
        return this.logWarning;
    }

    public void setLogWarning(boolean logWarning) {
        this.logWarning = logWarning;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public static enum FailReason {
        MOVED_INTO_UNLOADED_CHUNK,
        MOVED_TOO_QUICKLY,
        MOVED_WRONGLY,
        CLIPPED_INTO_BLOCK;

        private FailReason() {
        }
    }
}

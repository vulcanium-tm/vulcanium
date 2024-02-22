package dev.vulcanium.event.player;

import dev.vulcanium.Location;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerSetSpawnEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Cause cause;
    private Location location;
    private boolean forced;
    private boolean notifyPlayer;
    private Component notification;
    private boolean cancelled;

    @Internal
    public PlayerSetSpawnEvent(@NotNull Player player, @NotNull Cause cause, @Nullable Location location, boolean forced, boolean notifyPlayer, @Nullable Component notification) {
        super(player);
        this.cause = cause;
        this.location = location;
        this.forced = forced;
        this.notifyPlayer = notifyPlayer;
        this.notification = notification;
    }


    public @NotNull Cause getCause() {
        return this.cause;
    }

    public @Nullable Location getLocation() {
        return this.location;
    }

    public void setLocation(@Nullable Location location) {
        this.location = location;
    }

    public boolean isForced() {
        return this.forced;
    }

    public void setForced(boolean forced) {
        this.forced = forced;
    }

    public boolean willNotifyPlayer() {
        return this.notifyPlayer;
    }

    public void setNotifyPlayer(boolean notifyPlayer) {
        this.notifyPlayer = notifyPlayer;
    }

    public @Nullable Component getNotification() {
        return this.notification;
    }

    public void setNotification(@Nullable Component notification) {
        this.notification = notification;
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
        BED,
        RESPAWN_ANCHOR,
        PLAYER_RESPAWN,
        COMMAND,
        PLUGIN,
        UNKNOWN;

        private Cause() {
        }
    }
}

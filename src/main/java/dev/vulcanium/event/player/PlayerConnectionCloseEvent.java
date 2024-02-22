package dev.vulcanium.event.player;

import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;

import java.net.InetAddress;
import java.util.UUID;

public class PlayerConnectionCloseEvent extends Event {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull UUID playerUniqueId;
    private final @NotNull String playerName;
    private final @NotNull InetAddress ipAddress;

    @Internal
    public PlayerConnectionCloseEvent(@NotNull UUID playerUniqueId, @NotNull String playerName, @NotNull InetAddress ipAddress, boolean async) {
        super(async);
        this.playerUniqueId = playerUniqueId;
        this.playerName = playerName;
        this.ipAddress = ipAddress;
    }

    public @NotNull UUID getPlayerUniqueId() {
        return this.playerUniqueId;
    }

    public @NotNull String getPlayerName() {
        return this.playerName;
    }

    public @NotNull InetAddress getIpAddress() {
        return this.ipAddress;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

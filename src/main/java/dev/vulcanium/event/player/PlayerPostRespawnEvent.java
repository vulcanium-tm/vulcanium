package dev.vulcanium.event.player;

import dev.vulcanium.Location;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerPostRespawnEvent extends PlayerEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Location respawnedLocation;
    private final boolean isBedSpawn;

    @Internal
    public PlayerPostRespawnEvent(@NotNull Player respawnPlayer, @NotNull Location respawnedLocation, boolean isBedSpawn) {
        super(respawnPlayer);
        this.respawnedLocation = respawnedLocation;
        this.isBedSpawn = isBedSpawn;
    }

    public @NotNull Location getRespawnedLocation() {
        return this.respawnedLocation.clone();
    }

    public boolean isBedSpawn() {
        return this.isBedSpawn;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

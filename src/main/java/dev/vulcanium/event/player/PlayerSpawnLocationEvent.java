package dev.vulcanium.event.player;

import dev.vulcanium.Location;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.HandlerList;

import org.jetbrains.annotations.NotNull;

public class PlayerSpawnLocationEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private Location spawnLocation;

    public PlayerSpawnLocationEvent(@NotNull Player who, @NotNull Location spawnLocation) {
        super(who);
        this.spawnLocation = spawnLocation;
    }

    public @NotNull Location getSpawnLocation() {
        return this.spawnLocation;
    }

    public void setSpawnLocation(@NotNull Location location) {
        this.spawnLocation = location;
    }

    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static @NotNull HandlerList getHandlerList() {
        return handlers;
    }
}

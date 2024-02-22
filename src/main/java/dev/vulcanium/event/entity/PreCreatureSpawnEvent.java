package dev.vulcanium.event.entity;

import dev.vulcanium.Location;
import dev.vulcanium.entity.EntityType;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PreCreatureSpawnEvent extends Event implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull Location location;
    private final @NotNull EntityType type;
    @NotNull
    private final CreatureSpawnEvent. SpawnReason reason;
    private boolean shouldAbortSpawn;
    private boolean cancelled;

    @Internal
    public PreCreatureSpawnEvent(@NotNull Location location, @NotNull EntityType type, @NotNull CreatureSpawnEvent. SpawnReason reason) {
        this.location = location;
        this.type = type;
        this.reason = reason;
    }

    public @NotNull Location getSpawnLocation() {
        return this.location;
    }

    public @NotNull EntityType getType() {
        return this.type;
    }

    @NotNull
    public CreatureSpawnEvent. SpawnReason getReason() {
        return this.reason;
    }

    public boolean shouldAbortSpawn() {
        return this.shouldAbortSpawn;
    }

    public void setShouldAbortSpawn(boolean shouldAbortSpawn) {
        this.shouldAbortSpawn = shouldAbortSpawn;
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
}

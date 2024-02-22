package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerNaturallySpawnCreaturesEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private byte radius;
    private boolean cancelled;

    @Internal
    public PlayerNaturallySpawnCreaturesEvent(@NotNull Player player, byte radius) {
        super(player);
        this.radius = radius;
    }

    public byte getSpawnRadius() {
        return this.radius;
    }

    public void setSpawnRadius(byte radius) {
        this.radius = radius;
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

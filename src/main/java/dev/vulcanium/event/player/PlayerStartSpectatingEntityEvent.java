package dev.vulcanium.event.player;

import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerStartSpectatingEntityEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull Entity currentSpectatorTarget;
    private final @NotNull Entity newSpectatorTarget;
    private boolean cancelled;

    @Internal
    public PlayerStartSpectatingEntityEvent(@NotNull Player player, @NotNull Entity currentSpectatorTarget, @NotNull Entity newSpectatorTarget) {
        super(player);
        this.currentSpectatorTarget = currentSpectatorTarget;
        this.newSpectatorTarget = newSpectatorTarget;
    }

    public @NotNull Entity getCurrentSpectatorTarget() {
        return this.currentSpectatorTarget;
    }

    public @NotNull Entity getNewSpectatorTarget() {
        return this.newSpectatorTarget;
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

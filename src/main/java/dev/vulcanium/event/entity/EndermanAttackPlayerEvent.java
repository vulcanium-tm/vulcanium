package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Enderman;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EndermanAttackPlayerEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull Player player;
    private boolean cancelled;

    @Internal
    public EndermanAttackPlayerEvent(@NotNull Enderman entity, @NotNull Player player) {
        super(entity);
        this.player = player;
    }

    public @NotNull Enderman getEntity() {
        return (Enderman)super.getEntity();
    }

    public @NotNull Player getPlayer() {
        return this.player;
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

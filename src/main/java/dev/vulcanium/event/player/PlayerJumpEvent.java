package dev.vulcanium.event.player;

import com.google.common.base.Preconditions;
import dev.vulcanium.Location;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerJumpEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull Location to;
    private @NotNull Location from;
    private boolean cancelled;

    @Internal
    public PlayerJumpEvent(@NotNull Player player, @NotNull Location from, @NotNull Location to) {
        super(player);
        this.from = from;
        this.to = to;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public @NotNull Location getFrom() {
        return this.from;
    }

    public void setFrom(@NotNull Location from) {
        Preconditions.checkArgument(from != null, "Cannot use null from location!");
        Preconditions.checkArgument(from.getWorld() != null, "Cannot use from location with null world!");
        this.from = from;
    }

    public @NotNull Location getTo() {
        return this.to;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

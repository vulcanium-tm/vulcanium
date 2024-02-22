package dev.vulcanium.event.world.border;


import dev.vulcanium.Location;
import dev.vulcanium.world.*;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class WorldBorderCenterChangeEvent extends WorldBorderEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Location oldCenter;
    private Location newCenter;
    private boolean cancelled;

    @Internal
    public WorldBorderCenterChangeEvent(@NotNull World world, @NotNull WorldBorder worldBorder, @NotNull Location oldCenter, @NotNull Location newCenter) {
        super(world, worldBorder);
        this.oldCenter = oldCenter;
        this.newCenter = newCenter;
    }

    public @NotNull Location getOldCenter() {
        return this.oldCenter;
    }

    public @NotNull Location getNewCenter() {
        return this.newCenter;
    }

    public void setNewCenter(@NotNull Location newCenter) {
        this.newCenter = newCenter;
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

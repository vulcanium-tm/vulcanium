package dev.vulcanium.event.world.border;

import dev.vulcanium.world.*;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class WorldBorderBoundsChangeEvent extends WorldBorderEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private Type type;
    private final double oldSize;
    private double newSize;
    private long duration;
    private boolean cancelled;

    @Internal
    public WorldBorderBoundsChangeEvent(@NotNull World world, @NotNull WorldBorder worldBorder, @NotNull Type type, double oldSize, double newSize, long duration) {
        super(world, worldBorder);
        this.type = type;
        this.oldSize = oldSize;
        this.newSize = newSize;
        this.duration = duration;
    }
    public @NotNull Type getType() {
        return this.type;
    }

    public double getOldSize() {
        return this.oldSize;
    }

    public double getNewSize() {
        return this.newSize;
    }

    public void setNewSize(double newSize) {
        this.newSize = Math.min(this.worldBorder.getMaxSize(), Math.max(1.0, newSize));
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long duration) {
        this.duration = Math.min(9223372036854775L, Math.max(0L, duration));
        if (duration >= 0L && this.type == WorldBorderBoundsChangeEvent.Type.INSTANT_MOVE) {
            this.type = WorldBorderBoundsChangeEvent.Type.STARTED_MOVE;
        }

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

    public static enum Type {
        STARTED_MOVE,
        INSTANT_MOVE;

        private Type() {
        }
    }
}

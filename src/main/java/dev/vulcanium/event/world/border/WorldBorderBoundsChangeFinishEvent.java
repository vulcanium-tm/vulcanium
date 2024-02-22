package dev.vulcanium.event.world.border;

import dev.vulcanium.world.*;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class WorldBorderBoundsChangeFinishEvent extends WorldBorderEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final double oldSize;
    private final double newSize;
    private final double duration;

    @Internal
    public WorldBorderBoundsChangeFinishEvent(@NotNull World world, @NotNull WorldBorder worldBorder, double oldSize, double newSize, double duration) {
        super(world, worldBorder);
        this.oldSize = oldSize;
        this.newSize = newSize;
        this.duration = duration;
    }

    public double getOldSize() {
        return this.oldSize;
    }

    public double getNewSize() {
        return this.newSize;
    }

    public double getDuration() {
        return this.duration;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

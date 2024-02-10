package org.vulcanium.event.world;

import org.vulcanium.World;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.HandlerList;

/**
 * Called when a World is loaded
 */
public class WorldLoadEvent extends WorldEvent {
    private static final HandlerList handlers = new HandlerList();

    public WorldLoadEvent(@NotNull final World world) {
        super(world);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}

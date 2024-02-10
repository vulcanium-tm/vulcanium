package org.vulcanium.event.world;

import org.vulcanium.World;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.Event;

/**
 * Represents events within a world
 */
public abstract class WorldEvent extends Event {
    private final World world;

    public WorldEvent(@NotNull final World world) {
        this(world, false);
    }

    public WorldEvent(@NotNull World world, boolean isAsync) {
        super(isAsync);
        this.world = world;
    }

    /**
     * Gets the world primarily involved with this event
     *
     * @return World which caused this event
     */
    @NotNull
    public World getWorld() {
        return world;
    }
}

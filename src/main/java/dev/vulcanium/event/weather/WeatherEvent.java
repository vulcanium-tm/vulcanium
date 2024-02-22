package dev.vulcanium.event.weather;

import dev.vulcanium.world.World;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Event;

/**
 * Represents a Weather-related event
 */
public abstract class WeatherEvent extends Event {
    protected World world;

    public WeatherEvent(@NotNull final World where) {
        world = where;
    }

    /**
     * Returns the World where this event is occurring
     *
     * @return World this event is occurring in
     */
    @NotNull
    public final World getWorld() {
        return world;
    }
}

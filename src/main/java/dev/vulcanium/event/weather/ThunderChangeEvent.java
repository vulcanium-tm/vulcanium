package dev.vulcanium.event.weather;

import dev.vulcanium.world.World;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;

/**
 * Stores data for thunder state changing in a world
 */
public class ThunderChangeEvent extends WeatherEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean canceled;
    private final boolean to;

    public ThunderChangeEvent(@NotNull final World world, final boolean to) {
        super(world);
        this.to = to;
    }

    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        canceled = cancel;
    }

    /**
     * Gets the state of thunder that the world is being set to
     *
     * @return true if the weather is being set to thundering, false otherwise
     */
    public boolean toThunderState() {
        return to;
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

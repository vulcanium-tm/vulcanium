package org.vulcanium.event.vehicle;

import org.vulcanium.Location;
import org.vulcanium.entity.Vehicle;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.HandlerList;

/**
 * Raised when a vehicle moves.
 */
public class VehicleMoveEvent extends VehicleEvent {
    private static final HandlerList handlers = new HandlerList();
    private final Location from;
    private final Location to;

    public VehicleMoveEvent(@NotNull final Vehicle vehicle, @NotNull final Location from, @NotNull final Location to) {
        super(vehicle);

        this.from = from;
        this.to = to;
    }

    /**
     * Get the previous position.
     *
     * @return Old position.
     */
    @NotNull
    public Location getFrom() {
        return from;
    }

    /**
     * Get the next position.
     *
     * @return New position.
     */
    @NotNull
    public Location getTo() {
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

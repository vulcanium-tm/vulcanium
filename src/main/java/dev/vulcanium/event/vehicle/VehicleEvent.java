package dev.vulcanium.event.vehicle;

import dev.vulcanium.entity.Vehicle;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Event;

/**
 * Represents a vehicle-related event.
 */
public abstract class VehicleEvent extends Event {
    protected Vehicle vehicle;

    public VehicleEvent(@NotNull final Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Get the vehicle.
     *
     * @return the vehicle
     */
    @NotNull
    public final Vehicle getVehicle() {
        return vehicle;
    }
}

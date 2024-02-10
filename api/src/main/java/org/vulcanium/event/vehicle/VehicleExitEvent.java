package org.vulcanium.event.vehicle;

import org.vulcanium.entity.LivingEntity;
import org.vulcanium.entity.Vehicle;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.Cancellable;
import org.vulcanium.event.HandlerList;

/**
 * Raised when a living entity exits a vehicle.
 */
public class VehicleExitEvent extends VehicleEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final LivingEntity exited;

    public VehicleExitEvent(@NotNull final Vehicle vehicle, @NotNull final LivingEntity exited) {
        super(vehicle);
        this.exited = exited;
    }

    /**
     * Get the living entity that exited the vehicle.
     *
     * @return The entity.
     */
    @NotNull
    public LivingEntity getExited() {
        return exited;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
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

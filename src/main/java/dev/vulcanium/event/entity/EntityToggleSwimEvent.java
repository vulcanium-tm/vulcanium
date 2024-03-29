package dev.vulcanium.event.entity;

import dev.vulcanium.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;

/**
 * Sent when an entity's swimming status is toggled.
 */
public class EntityToggleSwimEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private boolean cancel = false;
    private final boolean isSwimming;

    public EntityToggleSwimEvent(@NotNull LivingEntity who, final boolean isSwimming) {
        super(who);
        this.isSwimming = isSwimming;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * Returns true if the entity is now swims or
     * false if the entity stops swimming.
     *
     * @return new swimming state
     */
    public boolean isSwimming() {
        return isSwimming;
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

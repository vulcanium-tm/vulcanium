package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.Pose;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.HandlerList;

/**
 * Called when an entity changes its pose.
 *
 * @see Entity#getPose()
 */
public class EntityPoseChangeEvent extends EntityEvent {

    private static final HandlerList handlers = new HandlerList();
    //
    private final Pose pose;

    public EntityPoseChangeEvent(@NotNull Entity who, @NotNull Pose pose) {
        super(who);
        this.pose = pose;
    }

    /**
     * Gets the entity's new pose.
     *
     * @return the new pose
     */
    @NotNull
    public Pose getPose() {
        return pose;
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

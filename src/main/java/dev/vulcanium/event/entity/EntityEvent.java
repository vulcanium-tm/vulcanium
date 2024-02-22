package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.EntityType;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Event;

/**
 * Represents an Entity-related event
 */
public abstract class EntityEvent extends Event {
    protected Entity entity;

    public EntityEvent(@NotNull final Entity what) {
        entity = what;
    }

    /**
     * Returns the Entity involved in this event
     *
     * @return Entity who is involved in this event
     */
    @NotNull
    public Entity getEntity() {
        return entity;
    }

    /**
     * Gets the EntityType of the Entity involved in this event.
     *
     * @return EntityType of the Entity involved in this event
     */
    @NotNull
    public EntityType getEntityType() {
        return entity.getType();
    }
}

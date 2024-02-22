package dev.vulcanium.event.hanging;

import dev.vulcanium.entity.Hanging;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Event;

/**
 * Represents a hanging entity-related event.
 */
public abstract class HangingEvent extends Event {
    protected Hanging hanging;

    protected HangingEvent(@NotNull final Hanging painting) {
        this.hanging = painting;
    }

    /**
     * Gets the hanging entity involved in this event.
     *
     * @return the hanging entity
     */
    @NotNull
    public Hanging getEntity() {
        return hanging;
    }
}

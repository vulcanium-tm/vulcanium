package org.vulcanium.event.hanging;

import org.vulcanium.entity.Entity;
import org.vulcanium.entity.Hanging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Triggered when a hanging entity is removed by an entity
 */
public class HangingBreakByEntityEvent extends HangingBreakEvent {
    private final Entity remover;

    public HangingBreakByEntityEvent(@NotNull final Hanging hanging, @Nullable final Entity remover) {
        this(hanging, remover, RemoveCause.ENTITY);
    }

    public HangingBreakByEntityEvent(@NotNull final Hanging hanging, @Nullable final Entity remover, @NotNull final RemoveCause cause) {
        super(hanging, cause);
        this.remover = remover;
    }

    /**
     * Gets the entity that removed the hanging entity.
     * May be null, for example when broken by an explosion.
     *
     * @return the entity that removed the hanging entity
     */
    @Nullable
    public Entity getRemover() {
        return remover;
    }
}

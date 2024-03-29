package dev.vulcanium.event.entity;

import dev.vulcanium.entity.AreaEffectCloud;
import dev.vulcanium.entity.LivingEntity;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Called when a lingering potion applies it's effects. Happens
 * once every 5 ticks
 */
public class AreaEffectCloudApplyEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final List<LivingEntity> affectedEntities;
    private boolean cancelled = false;

    public AreaEffectCloudApplyEvent(@NotNull final AreaEffectCloud entity, @NotNull final List<LivingEntity> affectedEntities) {
        super(entity);
        this.affectedEntities = affectedEntities;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    @NotNull
    public AreaEffectCloud getEntity() {
        return (AreaEffectCloud) entity;
    }

    /**
     * Retrieves a mutable list of the effected entities
     * <p>
     * It is important to note that not every entity in this list
     * is guaranteed to be effected.  The cloud may die during the
     * application of its effects due to the depletion of {@link AreaEffectCloud#getDurationOnUse()}
     * or {@link AreaEffectCloud#getRadiusOnUse()}
     *
     * @return the affected entity list
     */
    @NotNull
    public List<LivingEntity> getAffectedEntities() {
        return affectedEntities;
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

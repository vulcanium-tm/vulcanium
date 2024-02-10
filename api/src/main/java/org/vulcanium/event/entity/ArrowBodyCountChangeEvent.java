package org.vulcanium.event.entity;

import com.google.common.base.Preconditions;
import lombok.Getter;
import org.vulcanium.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.Cancellable;
import org.vulcanium.event.HandlerList;

/**
 * Called when an arrow enters or exists an entity's body.
 */
public class ArrowBodyCountChangeEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private boolean cancelled;
    private final boolean isReset;
    /**
     * -- GETTER --
     *  Gets the old amount of arrows in the entity's body.
     *
     * @return amount of arrows
     */
    @Getter
    private final int oldAmount;
    /**
     * -- GETTER --
     *  Get the new amount of arrows in the entity's body.
     *
     * @return amount of arrows
     */
    @Getter
    private int newAmount;

    public ArrowBodyCountChangeEvent(@NotNull LivingEntity entity, int oldAmount, int newAmount, boolean isReset) {
        super(entity);

        this.oldAmount = oldAmount;
        this.newAmount = newAmount;
        this.isReset = isReset;
    }

    /**
     * Whether the event was called because the entity was reset.
     *
     * @return was reset
     */
    public boolean isReset() {
        return isReset;
    }

    /**
     * Sets the final amount of arrows in the entity's body.
     *
     * @param newAmount amount of arrows
     */
    public void setNewAmount(int newAmount) {
        Preconditions.checkArgument(newAmount >= 0, "New arrow amount must be >= 0");
        this.newAmount = newAmount;
    }

    @Override
    @NotNull
    public LivingEntity getEntity() {
        return (LivingEntity) entity;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}

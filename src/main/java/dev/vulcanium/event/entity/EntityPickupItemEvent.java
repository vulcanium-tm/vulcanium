package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Item;
import dev.vulcanium.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;

/**
 * Thrown when a entity picks an item up from the ground
 */
public class EntityPickupItemEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Item item;
    private boolean cancel = false;
    private final int remaining;

    public EntityPickupItemEvent(@NotNull final LivingEntity entity, @NotNull final Item item, final int remaining) {
        super(entity);
        this.item = item;
        this.remaining = remaining;
    }

    @NotNull
    @Override
    public LivingEntity getEntity() {
        return (LivingEntity) entity;
    }

    /**
     * Gets the Item picked up by the entity.
     *
     * @return Item
     */
    @NotNull
    public Item getItem() {
        return item;
    }

    /**
     * Gets the amount remaining on the ground, if any
     *
     * @return amount remaining on the ground
     */
    public int getRemaining() {
        return remaining;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
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

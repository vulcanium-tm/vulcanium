package dev.vulcanium.event.entity;

import dev.vulcanium.entity.LivingEntity;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.EquipmentSlot;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EntityLoadCrossbowEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final ItemStack crossbow;
    private final EquipmentSlot hand;
    private boolean consumeItem = true;
    private boolean cancelled;

    @Internal
    public EntityLoadCrossbowEvent(@NotNull LivingEntity entity, @NotNull ItemStack crossbow, @NotNull EquipmentSlot hand) {
        super(entity);
        this.crossbow = crossbow;
        this.hand = hand;
    }

    public @NotNull LivingEntity getEntity() {
        return (LivingEntity)super.getEntity();
    }

    public @NotNull ItemStack getCrossbow() {
        return this.crossbow;
    }

    public @NotNull EquipmentSlot getHand() {
        return this.hand;
    }

    public boolean shouldConsumeItem() {
        return this.consumeItem;
    }

    public void setConsumeItem(boolean consume) {
        this.consumeItem = consume;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

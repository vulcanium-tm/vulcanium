package dev.vulcanium.event.entity;

import dev.vulcanium.entity.LivingEntity;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EntityFertilizeEggEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final LivingEntity mother;
    private final LivingEntity father;
    private final Player breeder;
    private final ItemStack bredWith;
    private int experience;
    private boolean cancelled;

    @Internal
    public EntityFertilizeEggEvent(@NotNull LivingEntity mother, @NotNull LivingEntity father, @Nullable Player breeder, @Nullable ItemStack bredWith, int experience) {
        super(mother);
        this.mother = mother;
        this.father = father;
        this.breeder = breeder;
        this.bredWith = bredWith;
        this.experience = experience;
    }

    public @NotNull LivingEntity getEntity() {
        return (LivingEntity)super.getEntity();
    }

    public @NotNull LivingEntity getMother() {
        return this.mother;
    }

    public @NotNull LivingEntity getFather() {
        return this.father;
    }

    public @Nullable Player getBreeder() {
        return this.breeder;
    }

    public @Nullable ItemStack getBredWith() {
        return this.bredWith;
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
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

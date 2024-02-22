package dev.vulcanium.event.entity;

import dev.vulcanium.entity.LivingEntity;
import dev.vulcanium.entity.Witch;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

public class WitchThrowPotionEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull LivingEntity target;
    private @Nullable ItemStack potion;
    private boolean cancelled;

    @Internal
    public WitchThrowPotionEvent(@NotNull Witch witch, @NotNull LivingEntity target, @Nullable ItemStack potion) {
        super(witch);
        this.target = target;
        this.potion = potion;
    }

    public @NotNull Witch getEntity() {
        return (Witch)super.getEntity();
    }

    public @NotNull LivingEntity getTarget() {
        return this.target;
    }

    public @Nullable ItemStack getPotion() {
        return this.potion;
    }

    public void setPotion(@Nullable ItemStack potion) {
        this.potion = potion != null ? potion.clone() : null;
    }

    public boolean isCancelled() {
        return this.cancelled || this.potion == null;
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

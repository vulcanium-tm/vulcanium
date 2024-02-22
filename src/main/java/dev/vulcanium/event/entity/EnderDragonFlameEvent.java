package dev.vulcanium.event.entity;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.entity.AreaEffectCloud;
import dev.vulcanium.entity.EnderDragon;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;

public class EnderDragonFlameEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull AreaEffectCloud areaEffectCloud;
    private boolean cancelled;

    @Internal
    public EnderDragonFlameEvent(@NotNull EnderDragon enderDragon, @NotNull AreaEffectCloud areaEffectCloud) {
        super(enderDragon);
        this.areaEffectCloud = areaEffectCloud;
    }

    public @NotNull EnderDragon getEntity() {
        return (EnderDragon)super.getEntity();
    }

    public @NotNull AreaEffectCloud getAreaEffectCloud() {
        return this.areaEffectCloud;
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

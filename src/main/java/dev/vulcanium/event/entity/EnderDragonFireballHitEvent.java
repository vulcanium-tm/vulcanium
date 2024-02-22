package dev.vulcanium.event.entity;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.entity.AreaEffectCloud;
import dev.vulcanium.entity.DragonFireball;
import dev.vulcanium.entity.LivingEntity;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;

import java.util.Collection;

public class EnderDragonFireballHitEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull Collection<LivingEntity> targets;
    private final @NotNull AreaEffectCloud areaEffectCloud;
    private boolean cancelled;

    @Internal
    public EnderDragonFireballHitEvent(@NotNull DragonFireball fireball, @NotNull Collection<LivingEntity> targets, @NotNull AreaEffectCloud areaEffectCloud) {
        super(fireball);
        this.targets = targets;
        this.areaEffectCloud = areaEffectCloud;
    }

    public @NotNull DragonFireball getEntity() {
        return (DragonFireball)super.getEntity();
    }

    public @NotNull Collection<LivingEntity> getTargets() {
        return this.targets;
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

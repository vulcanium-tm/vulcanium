package dev.vulcanium.event.entity;

import dev.vulcanium.entity.LivingEntity;
import dev.vulcanium.entity.Slime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class SlimeTargetLivingEntityEvent extends SlimePathfindEvent {
    private final @NotNull LivingEntity target;

    @Internal
    public SlimeTargetLivingEntityEvent(@NotNull Slime slime, @NotNull LivingEntity target) {
        super(slime);
        this.target = target;
    }

    public @NotNull LivingEntity getTarget() {
        return this.target;
    }
}

package dev.vulcanium.event.entity;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import dev.vulcanium.block.Block;
import dev.vulcanium.block.BlockFace;
import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.LivingEntity;
import dev.vulcanium.entity.ThrownPotion;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WaterBottleSplashEvent extends PotionSplashEvent {
    private final @NotNull Set<LivingEntity> rehydrate;
    private final @NotNull Set<LivingEntity> extinguish;

    @Internal
    public WaterBottleSplashEvent(@NotNull ThrownPotion potion, @Nullable Entity hitEntity, @Nullable Block hitBlock, @Nullable BlockFace hitFace, @NotNull Map<LivingEntity, Double> affectedEntities, @NotNull Set<LivingEntity> rehydrate, @NotNull Set<LivingEntity> extinguish) {
        super(potion, hitEntity, hitBlock, hitFace, affectedEntities);
        this.rehydrate = rehydrate;
        this.extinguish = extinguish;
    }

    public @NotNull Collection<LivingEntity> getToDamage() {
        return (Collection)this.affectedEntities.entrySet().stream().filter((entry) -> {
            return (Double)entry.getValue() > 0.0;
        }).map(Map.Entry::getKey).collect(Collectors.toUnmodifiableSet());
    }

    public void doNotDamageAsWaterSensitive(@NotNull LivingEntity entity) {
        this.affectedEntities.remove(entity);
    }

    public void damageAsWaterSensitive(@NotNull LivingEntity entity) {
        this.affectedEntities.put(entity, 1.0);
    }

    public @NotNull Collection<LivingEntity> getToRehydrate() {
        return this.rehydrate;
    }

    public @NotNull Collection<LivingEntity> getToExtinguish() {
        return this.extinguish;
    }

    /** @deprecated */
    @Deprecated
    public @NotNull Collection<LivingEntity> getAffectedEntities() {
        return super.getAffectedEntities();
    }

    /** @deprecated */
    @Deprecated
    public double getIntensity(@NotNull LivingEntity entity) {
        return super.getIntensity(entity);
    }

    /** @deprecated */
    @Deprecated
    public void setIntensity(@NotNull LivingEntity entity, double intensity) {
        super.setIntensity(entity, intensity);
    }
}


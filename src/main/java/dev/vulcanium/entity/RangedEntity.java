package dev.vulcanium.entity;

import org.jetbrains.annotations.NotNull;

public interface RangedEntity extends Mob {
    void rangedAttack(@NotNull LivingEntity var1, float var2);

    /** @deprecated */
    @Deprecated
    void setChargingAttack(boolean var1);

    /** @deprecated */
    @Deprecated
    default boolean isChargingAttack() {
        return this.isHandRaised();
    }
}

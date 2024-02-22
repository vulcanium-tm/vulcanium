package dev.vulcanium.entity;

import dev.vulcanium.annotation.MinecraftExperimental;
import org.jetbrains.annotations.ApiStatus;

/**
 * Represents a Wind Charge.
 */
@MinecraftExperimental
@ApiStatus.Experimental
public interface WindCharge extends Fireball {

    /**
     * Immediately explode this WindCharge.
     */
    public void explode();

}

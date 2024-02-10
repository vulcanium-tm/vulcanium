package org.vulcanium.entity;

import org.vulcanium.MinecraftExperimental;
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

/*
 Copyright © 2023

 Owner: Vulcanium

 Contributor: Shadowflare
 ────────────────────────────────────────────────────────────────────
 Permission is hereby granted to use and modify the Vulcanium plugin freely:

 1. Include copyright and permission notice in all copies of the Software.
 2. Users can depend on Vulcanium, create, and distribute plugins that rely on it.
 3. Republishing Vulcanium elsewhere is prohibited.
 4. Source code distribution is not allowed.
 5. Publishing a derivative version of the plugin is prohibited.
 ────────────────────────────────────────────────────────────────────
 SOFTWARE PROVIDED "AS IT IS," NO WARRANTY. AUTHORS NOT LIABLE FOR DAMAGES.
 */
package org.vulcanium.block.data.type;

import org.jetbrains.annotations.NotNull;
import org.vulcanium.block.data.AnaloguePowerable;
import org.vulcanium.block.data.Waterlogged;

/**
 * 'sculk_sensor_phase' indicates the current operational phase of the sensor.
 */
public interface SculkSensor extends AnaloguePowerable, Waterlogged {

    /**
     * Gets the value of the 'sculk_sensor_phase' property.
     *
     * @return the 'sculk_sensor_phase' value
     */
    @NotNull
    Phase getPhase();

    /**
     * Sets the value of the 'sculk_sensor_phase' property.
     *
     * @param phase the new 'sculk_sensor_phase' value
     */
    void setPhase(@NotNull Phase phase);

    /**
     * The Phase of the sensor.
     */
    public enum Phase {

        /**
         * The sensor is inactive.
         */
        INACTIVE,
        /**
         * The sensor is active.
         */
        ACTIVE,
        /**
         * The sensor is cooling down.
         */
        COOLDOWN;
    }
}

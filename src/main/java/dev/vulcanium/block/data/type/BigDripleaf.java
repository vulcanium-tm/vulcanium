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
package dev.vulcanium.block.data.type;

import org.jetbrains.annotations.NotNull;

/**
 * 'tilt' indicates how far the leaf is tilted.
 */
public interface BigDripleaf extends Dripleaf {

    /**
     * Gets the value of the 'tilt' property.
     *
     * @return the 'tilt' value
     */
    @NotNull
    Tilt getTilt();

    /**
     * Sets the value of the 'tilt' property.
     *
     * @param tilt the new 'tilt' value
     */
    void setTilt(@NotNull Tilt tilt);

    /**
     * The tilt of a leaf.
     */
    public enum Tilt {
        /**
         * No tilt.
         */
        NONE,
        /**
         * Unstable tilt.
         */
        UNSTABLE,
        /**
         * Partial tilt.
         */
        PARTIAL,
        /**
         * Pinball.
         */
        FULL;
    }
}

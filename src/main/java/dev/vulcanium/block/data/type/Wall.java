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
import dev.vulcanium.block.BlockFace;
import dev.vulcanium.block.data.Waterlogged;

/**
 * This class encompasses the 'north', 'east', 'south', 'west', height flags
 * which are used to set the height of a wall.
 *
 * 'up' denotes whether the well has a center post.
 */
public interface Wall extends Waterlogged {

    /**
     * Gets the value of the 'up' property.
     *
     * @return the 'up' value
     */
    boolean isUp();

    /**
     * Sets the value of the 'up' property.
     *
     * @param up the new 'up' value
     */
    void setUp(boolean up);

    /**
     * Gets the height of the specified face.
     *
     * @param face to check
     * @return if face is enabled
     */
    @NotNull
    Height getHeight(@NotNull BlockFace face);

    /**
     * Set the height of the specified face.
     *
     * @param face to set
     * @param height the height
     */
    void setHeight(@NotNull BlockFace face, @NotNull Height height);

    /**
     * The different heights a face of a wall may have.
     */
    public enum Height {
        /**
         * No wall present.
         */
        NONE,
        /**
         * Low wall present.
         */
        LOW,
        /**
         * Tall wall present.
         */
        TALL;
    }
}

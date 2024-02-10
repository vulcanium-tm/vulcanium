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

import java.util.Set;

import org.jetbrains.annotations.NotNull;
import org.vulcanium.block.BlockFace;
import org.vulcanium.block.data.Waterlogged;

/**
 * 'thickness' represents the dripstone thickness.
 * <br>
 * 'vertical_direction' represents the dripstone orientation.
 * <br>
 * Some blocks may not be able to face in all directions, use
 * {@link #getVerticalDirections()} to get all possible directions for this
 * block.
 */
public interface PointedDripstone extends Waterlogged {

    /**
     * Gets the value of the 'vertical_direction' property.
     *
     * @return the 'vertical_direction' value
     */
    @NotNull
    BlockFace getVerticalDirection();

    /**
     * Sets the value of the 'vertical_direction' property.
     *
     * @param direction the new 'vertical_direction' value
     */
    void setVerticalDirection(@NotNull BlockFace direction);

    /**
     * Gets the faces which are applicable to this block.
     *
     * @return the allowed 'vertical_direction' values
     */
    @NotNull
    Set<BlockFace> getVerticalDirections();

    /**
     * Gets the value of the 'thickness' property.
     *
     * @return the 'thickness' value
     */
    @NotNull
    Thickness getThickness();

    /**
     * Sets the value of the 'thickness' property.
     *
     * @param thickness the new 'thickness' value
     */
    void setThickness(@NotNull Thickness thickness);

    /**
     * Represents the thickness of the dripstone, corresponding to its position
     * within a multi-block dripstone formation.
     */
    public enum Thickness {
        /**
         * Extended tip.
         */
        TIP_MERGE,
        /**
         * Just the tip.
         */
        TIP,
        /**
         * Top section.
         */
        FRUSTUM,
        /**
         * Middle section.
         */
        MIDDLE,
        /**
         * Base.
         */
        BASE;
    }
}

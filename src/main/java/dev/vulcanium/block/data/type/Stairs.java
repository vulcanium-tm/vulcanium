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
import dev.vulcanium.block.data.Bisected;
import dev.vulcanium.block.data.Directional;
import dev.vulcanium.block.data.Waterlogged;

/**
 * 'shape' represents the texture and bounding box shape of these stairs.
 */
public interface Stairs extends Bisected, Directional, Waterlogged {

    /**
     * Gets the value of the 'shape' property.
     *
     * @return the 'shape' value
     */
    @NotNull
    Shape getShape();

    /**
     * Sets the value of the 'shape' property.
     *
     * @param shape the new 'shape' value
     */
    void setShape(@NotNull Shape shape);

    /**
     * The shape of a stair block - used for constructing corners.
     */
    public enum Shape {
        /**
         * Regular stair block.
         */
        STRAIGHT,
        /**
         * Inner corner stair block with higher left side.
         */
        INNER_LEFT,
        /**
         * Inner corner stair block with higher right side.
         */
        INNER_RIGHT,
        /**
         * Outer corner stair block with higher left side.
         */
        OUTER_LEFT,
        /**
         * Outer corner stair block with higher right side.
         */
        OUTER_RIGHT;
    }
}

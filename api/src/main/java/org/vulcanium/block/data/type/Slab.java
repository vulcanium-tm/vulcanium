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
import org.vulcanium.block.data.Waterlogged;

/**
 * 'type' represents what state the slab is in - either top, bottom, or a double
 * slab occupying the full block.
 */
public interface Slab extends Waterlogged {

    /**
     * Gets the value of the 'type' property.
     *
     * @return the 'type' value
     */
    @NotNull
    Type getType();

    /**
     * Sets the value of the 'type' property.
     *
     * @param type the new 'type' value
     */
    void setType(@NotNull Type type);

    /**
     * The type of the slab.
     */
    public enum Type {
        /**
         * The slab occupies the upper y half of the block.
         */
        TOP,
        /**
         * The slab occupies the lower y half of the block.
         */
        BOTTOM,
        /**
         * The slab occupies the entire block.
         */
        DOUBLE;
    }
}

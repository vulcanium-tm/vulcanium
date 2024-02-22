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
import dev.vulcanium.block.data.Directional;
import dev.vulcanium.block.data.Waterlogged;

/**
 * 'type' represents which part of a double chest this block is, or if it is a
 * single chest.
 */
public interface Chest extends Directional, Waterlogged {

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
     * Type of this chest block.
     * <br>
     * NB: Left and right are relative to the chest itself, i.e opposite to what
     * a player placing the appropriate block would see.
     */
    public enum Type {
        /**
         * The chest is not linked to any others and contains only one 27 slot
         * inventory.
         */
        SINGLE,
        /**
         * The chest is the left hand side of a double chest and shares a 54
         * block inventory with the chest to its right.
         */
        LEFT,
        /**
         * The chest is the right hand side of a double chest and shares a 54
         * block inventory with the chest to its left.
         */
        RIGHT;
    }
}

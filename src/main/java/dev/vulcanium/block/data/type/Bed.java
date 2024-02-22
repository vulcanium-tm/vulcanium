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

/**
 * Similar to {@link Bisected}, 'part' denotes which half of the bed this block
 * corresponds to.
 * <br>
 * 'occupied' property is a quick flag to check if a player is currently
 * sleeping in this bed block.
 */
public interface Bed extends Directional {

    /**
     * Gets the value of the 'part' property.
     *
     * @return the 'part' value
     */
    @NotNull
    Part getPart();

    /**
     * Sets the value of the 'part' property.
     *
     * @param part the new 'part' value
     */
    void setPart(@NotNull Part part);

    /**
     * Gets the value of the 'occupied' property.
     *
     * @return the 'occupied' value
     */
    boolean isOccupied();

    /**
     * Horizontal half of a bed.
     */
    public enum Part {

        /**
         * The head is the upper part of the bed containing the pillow.
         */
        HEAD,
        /**
         * The foot is the lower half of the bed.
         */
        FOOT;
    }
}

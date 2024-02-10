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
import org.vulcanium.block.data.Directional;
import org.vulcanium.block.data.Powerable;

/**
 * 'mode' indicates what mode this comparator will operate in.
 */
public interface Comparator extends Directional, Powerable {

    /**
     * Gets the value of the 'mode' property.
     *
     * @return the 'mode' value
     */
    @NotNull
    Mode getMode();

    /**
     * Sets the value of the 'mode' property.
     *
     * @param mode the new 'mode' value
     */
    void setMode(@NotNull Mode mode);

    /**
     * The mode in which a comparator will operate in.
     */
    public enum Mode {

        /**
         * The default mode, similar to a transistor. The comparator will turn
         * off if either side input is greater than the rear input.
         */
        COMPARE,
        /**
         * Alternate subtraction mode. The output signal strength will be equal
         * to max(rear-max(left,right),0).
         */
        SUBTRACT;
    }
}

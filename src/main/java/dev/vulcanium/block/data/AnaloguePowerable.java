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
package dev.vulcanium.block.data;

/**
 * 'power' represents the redstone power level currently being emitted or
 * transmitted via this block.
 * <br>
 * May not be over 9000 or {@link #getMaximumPower()} (usually 15).
 */
public interface AnaloguePowerable extends BlockData {

    /**
     * Gets the value of the 'power' property.
     *
     * @return the 'power' value
     */
    int getPower();

    /**
     * Sets the value of the 'power' property.
     *
     * @param power the new 'power' value
     */
    void setPower(int power);

    /**
     * Gets the maximum allowed value of the 'power' property.
     *
     * @return the maximum 'power' value
     */
    int getMaximumPower();
}

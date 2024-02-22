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

import dev.vulcanium.block.data.BlockData;

/**
 * The 'moisture' level of farmland indicates how close it is to a water source
 * (if any).
 * <br>
 * A higher moisture level leads, to faster growth of crops on this block, but
 * cannot be higher than {@link #getMaximumMoisture()}.
 */
public interface Farmland extends BlockData {

    /**
     * Gets the value of the 'moisture' property.
     *
     * @return the 'moisture' value
     */
    int getMoisture();

    /**
     * Sets the value of the 'moisture' property.
     *
     * @param moisture the new 'moisture' value
     */
    void setMoisture(int moisture);

    /**
     * Gets the maximum allowed value of the 'moisture' property.
     *
     * @return the maximum 'moisture' value
     */
    int getMaximumMoisture();
}

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
 * 'charges' represents the amount of times the anchor may still be used.
 */
public interface RespawnAnchor extends BlockData {

    /**
     * Gets the value of the 'charges' property.
     *
     * @return the 'charges' value
     */
    int getCharges();

    /**
     * Sets the value of the 'charges' property.
     *
     * @param charges the new 'charges' value
     */
    void setCharges(int charges);

    /**
     * Gets the maximum allowed value of the 'charges' property.
     *
     * @return the maximum 'charges' value
     */
    int getMaximumCharges();
}

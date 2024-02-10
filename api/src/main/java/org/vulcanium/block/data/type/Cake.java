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

import org.vulcanium.block.data.BlockData;

/**
 * 'bites' represents the amount of bites which have been taken from this slice
 * of cake.
 * <br>
 * A value of 0 indicates that the cake has not been eaten, whilst a value of
 * {@link #getMaximumBites()} indicates that it is all gone :(
 */
public interface Cake extends BlockData {

    /**
     * Gets the value of the 'bites' property.
     *
     * @return the 'bites' value
     */
    int getBites();

    /**
     * Sets the value of the 'bites' property.
     *
     * @param bites the new 'bites' value
     */
    void setBites(int bites);

    /**
     * Gets the maximum allowed value of the 'bites' property.
     *
     * @return the maximum 'bites' value
     */
    int getMaximumBites();
}
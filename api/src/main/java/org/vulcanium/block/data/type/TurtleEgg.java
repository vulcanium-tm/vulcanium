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

import org.vulcanium.block.data.Hatchable;

/**
 * 'eggs' is the number of eggs which appear in this block.
 */
public interface TurtleEgg extends Hatchable {

    /**
     * Gets the value of the 'eggs' property.
     *
     * @return the 'eggs' value
     */
    int getEggs();

    /**
     * Sets the value of the 'eggs' property.
     *
     * @param eggs the new 'eggs' value
     */
    void setEggs(int eggs);

    /**
     * Gets the minimum allowed value of the 'eggs' property.
     *
     * @return the minimum 'eggs' value
     */
    int getMinimumEggs();

    /**
     * Gets the maximum allowed value of the 'eggs' property.
     *
     * @return the maximum 'eggs' value
     */
    int getMaximumEggs();
}

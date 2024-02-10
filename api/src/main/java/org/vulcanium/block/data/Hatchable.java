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
package org.vulcanium.block.data;

/**
 * 'hatch' is the number of entities which may hatch from these eggs.
 */
public interface Hatchable extends BlockData {

    /**
     * Gets the value of the 'hatch' property.
     *
     * @return the 'hatch' value
     */
    int getHatch();

    /**
     * Sets the value of the 'hatch' property.
     *
     * @param hatch the new 'hatch' value
     */
    void setHatch(int hatch);

    /**
     * Gets the maximum allowed value of the 'hatch' property.
     *
     * @return the maximum 'hatch' value
     */
    int getMaximumHatch();
}

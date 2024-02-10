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

import org.vulcanium.block.data.Directional;

/**
 * 'honey_level' represents the amount of honey stored in the hive.
 */
public interface Beehive extends Directional {

    /**
     * Gets the value of the 'honey_level' property.
     *
     * @return the 'honey_level' value
     */
    int getHoneyLevel();

    /**
     * Sets the value of the 'honey_level' property.
     *
     * @param honeyLevel the new 'honey_level' value
     */
    void setHoneyLevel(int honeyLevel);

    /**
     * Gets the maximum allowed value of the 'honey_level' property.
     *
     * @return the maximum 'honey_level' value
     */
    int getMaximumHoneyLevel();
}

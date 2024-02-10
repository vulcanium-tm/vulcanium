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
 * 'flower_amount' represents the number of petals.
 */
public interface PinkPetals extends Directional {

    /**
     * Gets the value of the 'flower_amount' property.
     *
     * @return the 'flower_amount' value
     */
    int getFlowerAmount();

    /**
     * Sets the value of the 'flower_amount' property.
     *
     * @param flower_amount the new 'flower_amount' value
     */
    void setFlowerAmount(int flower_amount);

    /**
     * Gets the maximum allowed value of the 'flower_amount' property.
     *
     * @return the maximum 'flower_amount' value
     */
    int getMaximumFlowerAmount();
}

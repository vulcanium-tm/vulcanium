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
 * 'layers' represents the amount of layers of snow which are present in this
 * block.
 * <br>
 * May not be lower than {@link #getMinimumLayers()} or higher than
 * {@link #getMaximumLayers()}.
 */
public interface Snow extends BlockData {

    /**
     * Gets the value of the 'layers' property.
     *
     * @return the 'layers' value
     */
    int getLayers();

    /**
     * Sets the value of the 'layers' property.
     *
     * @param layers the new 'layers' value
     */
    void setLayers(int layers);

    /**
     * Gets the minimum allowed value of the 'layers' property.
     *
     * @return the minimum 'layers' value
     */
    int getMinimumLayers();

    /**
     * Gets the maximum allowed value of the 'layers' property.
     *
     * @return the maximum 'layers' value
     */
    int getMaximumLayers();
}

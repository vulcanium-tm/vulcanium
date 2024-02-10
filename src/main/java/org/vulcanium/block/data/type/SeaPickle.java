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

import org.vulcanium.block.data.Waterlogged;

/**
 * 'pickles' indicates the number of pickles in this block.
 */
public interface SeaPickle extends Waterlogged {

    /**
     * Gets the value of the 'pickles' property.
     *
     * @return the 'pickles' value
     */
    int getPickles();

    /**
     * Sets the value of the 'pickles' property.
     *
     * @param pickles the new 'pickles' value
     */
    void setPickles(int pickles);

    /**
     * Gets the minimum allowed value of the 'pickles' property.
     *
     * @return the minimum 'pickles' value
     */
    int getMinimumPickles();

    /**
     * Gets the maximum allowed value of the 'pickles' property.
     *
     * @return the maximum 'pickles' value
     */
    int getMaximumPickles();
}

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
 * 'dusted' represents how far uncovered by brush the block is.
 */
public interface Brushable extends BlockData {

    /**
     * Gets the value of the 'dusted' property.
     *
     * @return the 'dusted' value
     */
    int getDusted();

    /**
     * Sets the value of the 'dusted' property.
     *
     * @param dusted the new 'dusted' value
     */
    void setDusted(int dusted);

    /**
     * Gets the maximum allowed value of the 'dusted' property.
     *
     * @return the maximum 'dusted' value
     */
    int getMaximumDusted();
}

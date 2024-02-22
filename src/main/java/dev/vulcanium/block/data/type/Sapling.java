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
 * 'stage' represents the growth stage of a sapling.
 * <br>
 * When the sapling reaches {@link #getMaximumStage()} it will attempt to grow
 * into a tree as the next stage.
 */
public interface Sapling extends BlockData {

    /**
     * Gets the value of the 'stage' property.
     *
     * @return the 'stage' value
     */
    int getStage();

    /**
     * Sets the value of the 'stage' property.
     *
     * @param stage the new 'stage' value
     */
    void setStage(int stage);

    /**
     * Gets the maximum allowed value of the 'stage' property.
     *
     * @return the maximum 'stage' value
     */
    int getMaximumStage();
}

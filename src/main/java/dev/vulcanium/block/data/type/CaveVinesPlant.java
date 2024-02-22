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
 * 'berries' indicates whether the block has berries.
 */
public interface CaveVinesPlant extends BlockData {

    /**
     * Gets the value of the 'berries' property.
     *
     * @return the 'berries' value
     */
    boolean isBerries();

    /**
     * Sets the value of the 'berries' property.
     *
     * @param berries the new 'berries' value
     */
    void setBerries(boolean berries);
}

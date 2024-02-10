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

import org.jetbrains.annotations.NotNull;
import org.vulcanium.block.BlockFace;

/**
 * 'rotation' represents the current rotation of this block.
 */
public interface Rotatable extends BlockData {

    /**
     * Gets the value of the 'rotation' property.
     *
     * @return the 'rotation' value
     */
    @NotNull
    BlockFace getRotation();

    /**
     * Sets the value of the 'rotation' property.
     *
     * @param rotation the new 'rotation' value
     */
    void setRotation(@NotNull BlockFace rotation);
}

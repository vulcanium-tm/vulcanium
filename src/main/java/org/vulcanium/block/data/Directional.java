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

import java.util.Set;

import org.jetbrains.annotations.NotNull;
import org.vulcanium.block.BlockFace;

/**
 * 'facing' represents the face towards which the block is pointing.
 * <br>
 * Some blocks may not be able to face in all directions, use
 * {@link #getFaces()} to get all possible directions for this block.
 */
public interface Directional extends BlockData {

    /**
     * Gets the value of the 'facing' property.
     *
     * @return the 'facing' value
     */
    @NotNull
    BlockFace getFacing();

    /**
     * Sets the value of the 'facing' property.
     *
     * @param facing the new 'facing' value
     */
    void setFacing(@NotNull BlockFace facing);

    /**
     * Gets the faces which are applicable to this block.
     *
     * @return the allowed 'facing' values
     */
    @NotNull
    Set<BlockFace> getFaces();
}

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
 * This class encompasses the 'north', 'east', 'south', 'west', 'up', 'down'
 * boolean flags which are used to set which faces of the block textures are
 * displayed on.
 * <br>
 * Some blocks may not be able to have faces on all directions, use
 * {@link #getAllowedFaces()} to get all possible faces for this block. It is
 * not valid to call any methods on non-allowed faces.
 */
public interface MultipleFacing extends BlockData {

    /**
     * Checks if this block has the specified face enabled.
     *
     * @param face to check
     * @return if face is enabled
     */
    boolean hasFace(@NotNull BlockFace face);

    /**
     * Set whether this block has the specified face enabled.
     *
     * @param face to set
     * @param has the face
     */
    void setFace(@NotNull BlockFace face, boolean has);

    /**
     * Get all of the faces which are enabled on this block.
     *
     * @return all faces enabled
     */
    @NotNull
    Set<BlockFace> getFaces();

    /**
     * Gets all of this faces which may be set on this block.
     *
     * @return all allowed faces
     */
    @NotNull
    Set<BlockFace> getAllowedFaces();
}

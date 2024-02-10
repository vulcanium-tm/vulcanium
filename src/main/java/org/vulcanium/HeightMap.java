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
package org.vulcanium;


/**
 * Further information regarding heightmaps.
 *
 * @see <a href="https://minecraft.wiki/w/Chunk_format">Minecraft Wiki</a>
 */
public enum HeightMap {

    /**
     * The highest block that blocks motion or contains a fluid.
     */
    MOTION_BLOCKING,
    /**
     * The highest block that blocks motion or contains a fluid or is in the
     * {@link Tag#LEAVES}.
     */
    MOTION_BLOCKING_NO_LEAVES,
    /**
     * The highest non-air block, solid block.
     */
    OCEAN_FLOOR,
    /**
     * The highest block that is neither air nor contains a fluid, for worldgen.
     */
    OCEAN_FLOOR_WG,
    /**
     * The highest non-air block.
     */
    WORLD_SURFACE,
    /**
     * The highest non-air block, for worldgen.
     */
    WORLD_SURFACE_WG,
}

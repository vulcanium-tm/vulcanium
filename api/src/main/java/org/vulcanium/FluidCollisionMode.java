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
 * Determines the collision behavior when fluids get hit during ray tracing.
 */
public enum FluidCollisionMode {

    /**
     * Ignore fluids.
     */
    NEVER,
    /**
     * Only collide with source fluid blocks.
     */
    SOURCE_ONLY,
    /**
     * Collide with all fluids.
     */
    ALWAYS;
}

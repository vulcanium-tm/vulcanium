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
package dev.vulcanium;

/**
 * Represents a mutually perpendicular axis in 3D Cartesian coordinates. In
 * Minecraft the x, z axes lie in the horizontal plane, whilst the y axis points
 * upwards.
 */
public enum Axis {
    /**
     * The x axis.
     */
    X,
    /**
     * The y axis.
     */
    Y,
    /**
     * The z axis.
     */
    Z;
}

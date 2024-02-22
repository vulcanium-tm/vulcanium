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
package dev.vulcanium.block.data;

/**
 * 'snowy' denotes whether this block has a snow covered side and top texture
 * (normally because the block above is snow).
 */
public interface Snowable extends BlockData {

    /**
     * Gets the value of the 'snowy' property.
     *
     * @return the 'snowy' value
     */
    boolean isSnowy();

    /**
     * Sets the value of the 'snowy' property.
     *
     * @param snowy the new 'snowy' value
     */
    void setSnowy(boolean snowy);
}

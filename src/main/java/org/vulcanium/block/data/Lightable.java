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
 * 'lit' denotes whether this block (either a redstone torch or furnace) is
 * currently lit - that is not burned out.
 */
public interface Lightable extends BlockData {

    /**
     * Gets the value of the 'lit' property.
     *
     * @return the 'lit' value
     */
    boolean isLit();

    /**
     * Sets the value of the 'lit' property.
     *
     * @param lit the new 'lit' value
     */
    void setLit(boolean lit);
}

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
 * 'powered' indicates whether this block is in the powered state or not, i.e.
 * receiving a redstone current of power &gt; 0.
 */
public interface Powerable extends BlockData {

    /**
     * Gets the value of the 'powered' property.
     *
     * @return the 'powered' value
     */
    boolean isPowered();

    /**
     * Sets the value of the 'powered' property.
     *
     * @param powered the new 'powered' value
     */
    void setPowered(boolean powered);
}

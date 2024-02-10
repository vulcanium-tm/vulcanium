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
package org.vulcanium.block.data.type;

import org.vulcanium.block.data.Directional;

/**
 * 'eye' denotes whether this end portal frame has been activated by having an
 * eye of ender placed in it.
 */
public interface EndPortalFrame extends Directional {

    /**
     * Gets the value of the 'eye' property.
     *
     * @return the 'eye' value
     */
    boolean hasEye();

    /**
     * Sets the value of the 'eye' property.
     *
     * @param eye the new 'eye' value
     */
    void setEye(boolean eye);
}

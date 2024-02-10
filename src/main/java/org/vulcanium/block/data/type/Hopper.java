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
import org.vulcanium.block.data.Powerable;

/**
 * Similar to {@link Powerable}, 'enabled' indicates whether or not the hopper
 * is currently activated.
 * <br>
 * Unlike most other blocks, a hopper is only enabled when it is <b>not</b>
 * receiving any power.
 */
public interface Hopper extends Directional {

    /**
     * Gets the value of the 'enabled' property.
     *
     * @return the 'enabled' value
     */
    boolean isEnabled();

    /**
     * Sets the value of the 'enabled' property.
     *
     * @param enabled the new 'enabled' value
     */
    void setEnabled(boolean enabled);
}

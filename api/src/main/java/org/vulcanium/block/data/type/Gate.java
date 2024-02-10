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
import org.vulcanium.block.data.Openable;
import org.vulcanium.block.data.Powerable;

/**
 * 'in_wall" indicates if the fence gate is attached to a wall, and if true the
 * texture is lowered by a small amount to blend in better.
 */
public interface Gate extends Directional, Openable, Powerable {

    /**
     * Gets the value of the 'in_wall' property.
     *
     * @return the 'in_wall' value
     */
    boolean isInWall();

    /**
     * Sets the value of the 'in_wall' property.
     *
     * @param inWall the new 'in_wall' value
     */
    void setInWall(boolean inWall);
}

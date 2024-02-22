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
package dev.vulcanium.block.data.type;

import dev.vulcanium.block.data.Waterlogged;

/**
 * 'bottom' indicates whether the scaffolding is floating or not.
 * <br>
 * 'distance' indicates the distance from a scaffolding block placed above a
 * 'bottom' scaffold.
 * <br>
 * When 'distance' reaches {@link #getMaximumDistance()} the block will drop.
 */
public interface Scaffolding extends Waterlogged {

    /**
     * Gets the value of the 'bottom' property.
     *
     * @return the 'bottom' value
     */
    boolean isBottom();

    /**
     * Sets the value of the 'bottom' property.
     *
     * @param bottom the new 'bottom' value
     */
    void setBottom(boolean bottom);

    /**
     * Gets the value of the 'distance' property.
     *
     * @return the 'distance' value
     */
    int getDistance();

    /**
     * Sets the value of the 'distance' property.
     *
     * @param distance the new 'distance' value
     */
    void setDistance(int distance);

    /**
     * Gets the maximum allowed value of the 'distance' property.
     *
     * @return the maximum 'distance' value
     */
    int getMaximumDistance();
}

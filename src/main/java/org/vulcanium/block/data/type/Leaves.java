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

import org.vulcanium.block.data.Waterlogged;

/**
 * 'persistent' indicates whether or not leaves will be checked by the server to
 * see if they are subject to decay or not.
 * <br>
 * 'distance' denotes how far the block is from a tree and is used in
 * conjunction with 'persistent' flag to determine if the leaves will decay or
 * not.
 */
public interface Leaves extends Waterlogged {

    /**
     * Gets the value of the 'persistent' property.
     *
     * @return the persistent value
     */
    boolean isPersistent();

    /**
     * Sets the value of the 'persistent' property.
     *
     * @param persistent the new 'persistent' value
     */
    void setPersistent(boolean persistent);

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
}

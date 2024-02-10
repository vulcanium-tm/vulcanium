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

import org.vulcanium.block.data.BlockData;

/**
 * 'drag' indicates whether a force will be applied on entities moving through
 * this block.
 */
public interface BubbleColumn extends BlockData {

    /**
     * Gets the value of the 'drag' property.
     *
     * @return the 'drag' value
     */
    boolean isDrag();

    /**
     * Sets the value of the 'drag' property.
     *
     * @param drag the new 'drag' value
     */
    void setDrag(boolean drag);

}

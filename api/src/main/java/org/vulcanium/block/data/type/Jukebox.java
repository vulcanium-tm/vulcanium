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
 * 'has_record' is a quick flag to check whether this jukebox has a record
 * inside it.
 */
public interface Jukebox extends BlockData {

    /**
     * Gets the value of the 'has_record' property.
     *
     * @return the 'has_record' value
     */
    boolean hasRecord();
}

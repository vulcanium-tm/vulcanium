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

import dev.vulcanium.block.data.Directional;

/**
 * 'conditional' denotes whether this command block is conditional or not, i.e.
 * will only execute if the preceeding command block also executed successfully.
 */
public interface CommandBlock extends Directional {

    /**
     * Gets the value of the 'conditional' property.
     *
     * @return the 'conditional' value
     */
    boolean isConditional();

    /**
     * Sets the value of the 'conditional' property.
     *
     * @param conditional the new 'conditional' value
     */
    void setConditional(boolean conditional);
}

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
package dev.vulcanium.block.data;

/**
 * 'attached' denotes whether a tripwire hook or string forms a complete
 * tripwire circuit and is ready to trigger.
 * <br>
 * Updating the property on a tripwire hook will change the texture to indicate
 * a connected string, but will not have any effect when used on the tripwire
 * string itself. It may however still be used to check whether the string forms
 * a circuit.
 */
public interface Attachable extends BlockData {

    /**
     * Gets the value of the 'attached' property.
     *
     * @return the 'attached' value
     */
    boolean isAttached();

    /**
     * Sets the value of the 'attached' property.
     *
     * @param attached the new 'attached' value
     */
    void setAttached(boolean attached);
}

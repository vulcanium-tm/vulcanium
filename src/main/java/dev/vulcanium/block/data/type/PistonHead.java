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

/**
 * 'short' denotes this piston head is shorter than the usual amount because it
 * is currently retracting.
 */
public interface PistonHead extends TechnicalPiston {

    /**
     * Gets the value of the 'short' property.
     *
     * @return the 'short' value
     */
    boolean isShort();

    /**
     * Sets the value of the 'short' property.
     *
     * @param _short the new 'short' value
     */
    void setShort(boolean _short);
}
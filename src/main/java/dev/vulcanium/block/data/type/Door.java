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

import org.jetbrains.annotations.NotNull;
import dev.vulcanium.block.data.Bisected;
import dev.vulcanium.block.data.Directional;
import dev.vulcanium.block.data.Openable;
import dev.vulcanium.block.data.Powerable;

/**
 * 'hinge' indicates which hinge this door is attached to and will rotate around
 * when opened.
 */
public interface Door extends Bisected, Directional, Openable, Powerable {

    /**
     * Gets the value of the 'hinge' property.
     *
     * @return the 'hinge' value
     */
    @NotNull
    Hinge getHinge();

    /**
     * Sets the value of the 'hinge' property.
     *
     * @param hinge the new 'hinge' value
     */
    void setHinge(@NotNull Hinge hinge);

    /**
     * The hinge of a door.
     */
    public enum Hinge {
        /**
         * Door is attached to the left side.
         */
        LEFT,
        /**
         * Door is attached to the right side.
         */
        RIGHT;
    }
}

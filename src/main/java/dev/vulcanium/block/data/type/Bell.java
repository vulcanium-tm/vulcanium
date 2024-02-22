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
import dev.vulcanium.block.data.Directional;
import dev.vulcanium.block.data.Powerable;

/**
 * 'attachment' denotes how the bell is attached to its block.
 */
public interface Bell extends Directional, Powerable {

    /**
     * Gets the value of the 'attachment' property.
     *
     * @return the 'attachment' value
     */
    @NotNull
    Attachment getAttachment();

    /**
     * Sets the value of the 'attachment' property.
     *
     * @param attachment the new 'attachment' value
     */
    void setAttachment(@NotNull Attachment attachment);

    /**
     * What the bell is attached to.
     */
    public enum Attachment {

        /**
         * Placed on floor.
         */
        FLOOR,
        /**
         * Placed on ceiling.
         */
        CEILING,
        /**
         * Placed on one wall.
         */
        SINGLE_WALL,
        /**
         * Placed between two walls.
         */
        DOUBLE_WALL;
    }
}

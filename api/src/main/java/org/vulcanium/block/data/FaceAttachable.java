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
package org.vulcanium.block.data;

import org.jetbrains.annotations.NotNull;

/**
 * 'face' represents the face to which a lever or button is stuck.
 * <br>
 * This is used in conjunction with {@link Directional} to compute the
 * orientation of these blocks.
 */
public interface FaceAttachable extends BlockData {

    /**
     * Gets the value of the 'face' property.
     *
     * @return the 'face' value
     */
    @NotNull
    AttachedFace getAttachedFace();

    /**
     * Sets the value of the 'face' property.
     *
     * @param face the new 'face' value
     */
    void setAttachedFace(@NotNull AttachedFace face);

    /**
     * The face to which a switch type block is stuck.
     */
    public enum AttachedFace {
        /**
         * The switch is mounted to the floor and pointing upwards.
         */
        FLOOR,
        /**
         * The switch is mounted to the wall.
         */
        WALL,
        /**
         * The switch is mounted to the ceiling and pointing dowanrds.
         */
        CEILING;
    }
}

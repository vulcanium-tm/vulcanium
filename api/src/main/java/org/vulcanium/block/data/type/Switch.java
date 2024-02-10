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

import org.jetbrains.annotations.NotNull;
import org.vulcanium.block.data.Directional;
import org.vulcanium.block.data.FaceAttachable;
import org.vulcanium.block.data.Powerable;

public interface Switch extends Directional, FaceAttachable, Powerable {

    /**
     * Gets the value of the 'face' property.
     *
     * @return the 'face' value
     * @deprecated use {@link #getAttachedFace()}
     */
    @NotNull
    @Deprecated
    Face getFace();

    /**
     * Sets the value of the 'face' property.
     *
     * @param face the new 'face' value
     * @deprecated use {@link #getAttachedFace()}
     */
    @Deprecated
    void setFace(@NotNull Face face);

    /**
     * The face to which a switch type block is stuck.
     *
     * @deprecated use {@link AttachedFace}
     */
    @Deprecated
    public enum Face {
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

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

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.MinecraftExperimental;
import org.vulcanium.block.data.BlockData;
import org.vulcanium.block.data.Powerable;

/**
 * 'orientation' is the direction the block is facing.
 * <br>
 * Similar to {@link Powerable}, 'triggered' indicates whether or not the
 * dispenser is currently activated.
 * <br>
 * 'crafting' is whether crafter's mouth is open and top is glowing.
 */
@ApiStatus.Experimental
@MinecraftExperimental
public interface Crafter extends BlockData {

    /**
     * Gets the value of the 'crafting' property.
     *
     * @return the 'crafting' value
     */
    boolean isCrafting();

    /**
     * Sets the value of the 'crafting' property.
     *
     * @param crafting the new 'crafting' value
     */
    void setCrafting(boolean crafting);

    /**
     * Gets the value of the 'triggered' property.
     *
     * @return the 'triggered' value
     */
    boolean isTriggered();

    /**
     * Sets the value of the 'triggered' property.
     *
     * @param triggered the new 'triggered' value
     */
    void setTriggered(boolean triggered);

    /**
     * Gets the value of the 'orientation' property.
     *
     * @return the 'orientation' value
     */
    @NotNull
    Orientation getOrientation();

    /**
     * Sets the value of the 'orientation' property.
     *
     * @param orientation the new 'orientation' value
     */
    void setOrientation(@NotNull Orientation orientation);

    /**
     * The directions the Crafter can be oriented.
     */
    public enum Orientation {

        DOWN_EAST,
        DOWN_NORTH,
        DOWN_SOUTH,
        DOWN_WEST,
        UP_EAST,
        UP_NORTH,
        UP_SOUTH,
        UP_WEST,
        WEST_UP,
        EAST_UP,
        NORTH_UP,
        SOUTH_UP;
    }
}

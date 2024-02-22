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

import dev.vulcanium.Axis;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * 'axis' represents the axis along whilst this block is oriented.
 * <br>
 * Some blocks such as the portal block may not be able to be placed in all
 * orientations, use {@link #getAxes()} to retrieve all possible such
 * orientations.
 */
public interface Orientable extends BlockData {

    /**
     * Gets the value of the 'axis' property.
     *
     * @return the 'axis' value
     */
    @NotNull
    Axis getAxis();

    /**
     * Sets the value of the 'axis' property.
     *
     * @param axis the new 'axis' value
     */
    void setAxis(@NotNull Axis axis);

    /**
     * Gets the axes which are applicable to this block.
     *
     * @return the allowed 'axis' values
     */
    @NotNull
    Set<Axis> getAxes();
}

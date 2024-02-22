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
import dev.vulcanium.block.data.BlockData;

/**
 * 'mode' represents the different modes in which this structure block may
 * operate.
 */
public interface StructureBlock extends BlockData {

    /**
     * Gets the value of the 'mode' property.
     *
     * @return the 'mode' value
     */
    @NotNull
    Mode getMode();

    /**
     * Sets the value of the 'mode' property.
     *
     * @param mode the new 'mode' value
     */
    void setMode(@NotNull Mode mode);

    /**
     * Operating mode of a structure block.
     */
    public enum Mode {
        /**
         * Allows selection and saving of a structure.
         */
        SAVE,
        /**
         * Allows loading of a structure.
         */
        LOAD,
        /**
         * Used for detection of two opposite corners of a structure.
         */
        CORNER,
        /**
         * Dummy block used to run a custom function during world generation
         * before being removed.
         */
        DATA;
    }
}

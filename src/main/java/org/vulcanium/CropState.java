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
package org.vulcanium;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/**
 * Represents the different growth states of crops
 */
public enum CropState {

    /**
     * State when first seeded
     */
    SEEDED(0x0),
    /**
     * First growth stage
     */
    GERMINATED(0x1),
    /**
     * Second growth stage
     */
    VERY_SMALL(0x2),
    /**
     * Third growth stage
     */
    SMALL(0x3),
    /**
     * Fourth growth stage
     */
    MEDIUM(0x4),
    /**
     * Fifth growth stage
     */
    TALL(0x5),
    /**
     * Almost ripe stage
     */
    VERY_TALL(0x6),
    /**
     * Ripe stage
     */
    RIPE(0x7);

    private final byte data;
    private static final Map<Byte, CropState> BY_DATA = new HashMap<>();

    private CropState(final int data) {
        this.data = (byte) data;
    }

    /**
     * Gets the associated data value representing this growth state
     *
     * @return A byte containing the data value of this growth state
     * @deprecated Magic value
     */
    @Deprecated
    public byte getData() {
        return data;
    }

    /**
     * Gets the CropState with the given data value
     *
     * @param data Data value to fetch
     * @return The {@link CropState} representing the given value, or null if
     * it doesn't exist
     * @deprecated Magic value
     */
    @Deprecated
    @Nullable
    public static CropState getByData(final byte data) {
        return BY_DATA.get(data);
    }

    static {
        for (CropState cropState : values()) {
            BY_DATA.put(cropState.getData(), cropState);
        }
    }
}
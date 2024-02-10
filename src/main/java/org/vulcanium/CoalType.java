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

import org.jetbrains.annotations.Nullable;

/**
 * Represents the two types of coal
 */
public enum CoalType {
    COAL(0x0),
    CHARCOAL(0x1);

    private final byte data;
    private static final CoalType[] BY_DATA = new CoalType[Byte.MAX_VALUE + 1];

    static {
        for (CoalType type : values()) {
            BY_DATA[type.data & 0xFF] = type;
        }
    }

    private CoalType(final int data) {
        this.data = (byte) data;
    }

    /**
     * Gets the associated data value representing this type of coal
     *
     * @return A byte containing the data value of this coal type
     * @deprecated Magic value
     */
    @Deprecated
    public byte getData() {
        return data;
    }

    /**
     * Gets the type of coal with the given data value
     *
     * @param data Data value to fetch
     * @return The {@link CoalType} representing the given value, or null if
     *     it doesn't exist
     * @deprecated Magic value
     */
    @Deprecated
    @Nullable
    public static CoalType getByData(final byte data) {
        return BY_DATA[data & 0xFF];
    }
}
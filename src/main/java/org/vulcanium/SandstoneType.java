package org.vulcanium;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/**
 * Represents the three different types of Sandstone
 */
public enum SandstoneType {
    CRACKED(0x0),
    GLYPHED(0x1),
    SMOOTH(0x2);

    private final byte data;
    private static final Map<Byte, SandstoneType> BY_DATA;

    SandstoneType(final int data) {
        this.data = (byte) data;
    }

    /**
     * Gets the associated data value representing this type of sandstone
     *
     * @return A byte containing the data value of this sandstone type
     */
    public byte getData() {
        return data;
    }

    /**
     * Gets the type of sandstone with the given data value
     *
     * @param data Data value to fetch
     * @return The {@link SandstoneType} representing the given value, or null
     *     if it doesn't exist
     */
    @Nullable
    public static SandstoneType getByData(final byte data) {
        return BY_DATA.get(data);
    }

    static {
        BY_DATA = new HashMap<>();
        for (SandstoneType type : values()) {
            BY_DATA.put(type.data, type);
        }
    }
}
package org.vulcanium;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents various types of worlds that may exist
 */
public enum WorldType {
    NORMAL("DEFAULT"),
    FLAT("FLAT"),
    LARGE_BIOMES("LARGEBIOMES"),
    AMPLIFIED("AMPLIFIED");

    private static final Map<String, WorldType> BY_NAME = new HashMap<>();
    private final String name;

    private WorldType(String name) {
        this.name = name;
    }

    /**
     * Gets the name of this WorldType
     *
     * @return Name of this type
     */
    public String getName() {
        return name;
    }

    /**
     * Gets a WorldType by its name
     *
     * @param name Name of the WorldType to get
     * @return Requested WorldType, or null if not found
     */
    public static WorldType getByName(String name) {
        return BY_NAME.get(name.toUpperCase());
    }

    static {
        for (WorldType type : values()) {
            BY_NAME.put(type.name.toUpperCase(), type);
        }
    }
}

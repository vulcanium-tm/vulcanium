package org.vulcanium;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the various types of game modes that {@link HumanEntity}s may have
 */
public enum GameMode {
    CREATIVE(1),
    SURVIVAL(0),
    ADVENTURE(2),
    SPECTATOR(3);

    private final int value;
    private static final Map<Integer, GameMode> BY_ID;

    static {
        BY_ID = new HashMap<>();
        for (GameMode mode : values()) {
            BY_ID.put(mode.getValue(), mode);
        }
    }

    private GameMode(final int value) {
        this.value = value;
    }

    /**
     * Gets the mode value associated with this GameMode
     *
     * @return An integer value of this gamemode
     * @deprecated Magic value
     */
    @Deprecated
    public int getValue() {
        return value;
    }

    /**
     * Gets the GameMode represented by the specified value
     *
     * @param value Value to check
     * @return Associative {@link GameMode} with the given value, or null if
     * it doesn't exist
     * @deprecated Magic value
     */
    @Deprecated
    public static GameMode getByValue(final int value) {
        return BY_ID.get(value);
    }
}
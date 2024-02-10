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

import org.vulcanium.entity.HumanEntity;

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
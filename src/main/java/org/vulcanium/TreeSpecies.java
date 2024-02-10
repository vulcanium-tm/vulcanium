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

import com.google.common.collect.Maps;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Represents the different species of trees regardless of size.
 */
public enum TreeSpecies {

    /**
     * Represents the common tree species.
     */
    GENERIC(0x0),
    /**
     * Represents the darker barked/leaved tree species.
     */
    REDWOOD(0x1),
    /**
     * Represents birches.
     */
    BIRCH(0x2),
    /**
     * Represents jungle trees.
     */
    JUNGLE(0x3),
    /**
     * Represents acacia trees.
     */
    ACACIA(0x4),
    /**
     * Represents dark oak trees.
     */
    DARK_OAK(0x5),
    ;

    private final byte data;
    private static final Map<Byte, TreeSpecies> BY_DATA = Maps.newHashMap();

    private TreeSpecies(final int data) {
        this.data = (byte) data;
    }

    /**
     * Gets the associated data value representing this species
     *
     * @return A byte containing the data value of this tree species
     */
    public byte getData() {
        return data;
    }

    /**
     * Gets the TreeSpecies with the given data value
     *
     * @param data Data value to fetch
     * @return The {@link TreeSpecies} representing the given value, or null
     *     if it doesn't exist
     */
    @Nullable
    public static TreeSpecies getByData(final byte data) {
        return BY_DATA.get(data);
    }

    static {
        for (TreeSpecies species : values()) {
            BY_DATA.put(species.data, species);
        }
    }
}

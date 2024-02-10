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

import org.jetbrains.annotations.NotNull;
import org.vulcanium.entity.Raider;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Represents a raid event.
 */
public interface Raid {

    /**
     * Checks whether this raid started.
     *
     * @return true if the raid is started, false otherwise
     */
    boolean isStarted();

    /**
     * Gets the amount of ticks this raid has existed.
     *
     * @return active ticks
     */
    long getActiveTicks();

    /**
     * Gets the Bad Omen level of this raid.
     *
     * @return Bad Omen level (between 0 and 5)
     */
    int getBadOmenLevel();

    /**
     * Sets the Bad Omen level.
     * <br>
     * If the level is higher than 1, there will be an additional wave that is as strong as the final wave.
     *
     * @param badOmenLevel new Bad Omen level (from 0-5)
     * @throws IllegalArgumentException if an invalid Bad Omen level is provided
     */
    void setBadOmenLevel(int badOmenLevel);

    /**
     * Gets the center location where the raid occurs.
     *
     * @return location
     */
    @NotNull
    Location getLocation();

    /**
     * Gets the current status of the raid.
     * <br>
     * Do not use this method to check if the raid has been started; call {@link #isStarted()} instead.
     *
     * @return Raids status
     */
    @NotNull
    RaidStatus getStatus();

    /**
     * Gets the number of raider groups which have spawned.
     *
     * @return total spawned groups
     */
    int getSpawnedGroups();

    /**
     * Gets the number of raider groups which would spawn.
     * <br>
     * This also includes the group which spawns in the additional wave (if present).
     *
     * @return total groups
     */
    int getTotalGroups();

    /**
     * Gets the number of waves in this raid (exclude the additional wave).
     *
     * @return number of waves
     */
    int getTotalWaves();

    /**
     * Gets the sum of all raider's health.
     *
     * @return total raiders' health
     */
    float getTotalHealth();

    /**
     * Get the UUID of all heroes in this raid.
     *
     * @return a set of unique ids
     */
    @NotNull
    Set<UUID> getHeroes();

    /**
     * Gets all remaining {@link Raider}s in the present wave.
     *
     * @return a list of current raiders
     */
    @NotNull
    List<Raider> getRaiders();

    /**
     * Represents the status of a {@link Raid}.
     */
    enum RaidStatus {
        ONGOING,
        VICTORY,
        LOSS,
        STOPPED
    }
}

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
package dev.vulcanium.advancement;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Date;

/**
 * The individual status of an advancement for a player. This class is not
 * reference safe as the underlying advancement may be reloaded.
 */
public interface AdvancementProgress {

    /**
     * The advancement this progress is concerning.
     *
     * @return the relevant advancement
     */
    @NotNull
    Advancement getAdvancement();

    /**
     * Check if all criteria for this advancement have been met.
     *
     * @return true if this advancement is done
     */
    boolean isDone();

    /**
     * Mark the specified criteria as awarded at the current time.
     *
     * @param criteria the criteria to mark
     * @return true if awarded, false if criteria does not exist or already
     * awarded.
     */
    boolean awardCriteria(@NotNull String criteria);

    /**
     * Mark the specified criteria as uncompleted.
     *
     * @param criteria the criteria to mark
     * @return true if removed, false if criteria does not exist or not awarded
     */
    boolean revokeCriteria(@NotNull String criteria);

    /**
     * Get the date the specified criteria was awarded.
     *
     * @param criteria the criteria to check
     * @return date awarded or null if unawarded or criteria does not exist
     */
    @Nullable
    Date getDateAwarded(@NotNull String criteria);

    /**
     * Get the criteria which have not been awarded.
     *
     * @return unmodifiable copy of criteria remaining
     */
    @NotNull
    Collection<String> getRemainingCriteria();

    /**
     * Gets the criteria which have been awarded.
     *
     * @return unmodifiable copy of criteria awarded
     */
    @NotNull
    Collection<String> getAwardedCriteria();
}

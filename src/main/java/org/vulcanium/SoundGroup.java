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

/**
 * Represents a group of sounds for blocks that are played when various actions
 * happen (ie stepping, breaking, hitting, etc).
 */
public interface SoundGroup {

    /**
     * Get the volume these sounds are played at.
     *
     * Note that this volume does not always represent the actual volume
     * received by the client.
     *
     * @return volume
     */
    public float getVolume();

    /**
     * Gets the pitch these sounds are played at.
     *
     * Note that this pitch does not always represent the actual pitch received
     * by the client.
     *
     * @return pitch
     */
    public float getPitch();

    /**
     * Gets the corresponding breaking sound for this group.
     *
     * @return the break sound
     */
    @NotNull
    public Sound getBreakSound();

    /**
     * Gets the corresponding step sound for this group.
     *
     * @return the step sound
     */
    @NotNull
    public Sound getStepSound();

    /**
     * Gets the corresponding place sound for this group.
     *
     * @return the place sound
     */
    @NotNull
    public Sound getPlaceSound();

    /**
     * Gets the corresponding hit sound for this group.
     *
     * @return the hit sound
     */
    @NotNull
    public Sound getHitSound();

    /**
     * Gets the corresponding fall sound for this group.
     *
     * @return the fall sound
     */
    @NotNull
    public Sound getFallSound();
}

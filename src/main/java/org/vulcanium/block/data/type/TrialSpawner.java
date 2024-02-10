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
package org.vulcanium.block.data.type;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.MinecraftExperimental;
import org.vulcanium.block.data.BlockData;

/**
 * 'trial_spawner_state' indicates the current operational phase of the spawner.
 */
@MinecraftExperimental
@ApiStatus.Experimental
public interface TrialSpawner extends BlockData {

    /**
     * Gets the value of the 'trial_spawner_state' property.
     *
     * @return the 'trial_spawner_state' value
     */
    @NotNull
    State getTrialSpawnerState();

    /**
     * Sets the value of the 'trial_spawner_state' property.
     *
     * @param state the new 'trial_spawner_state' value
     */
    void setTrialSpawnerState(@NotNull State state);

    public enum State {

        INACTIVE,
        WAITING_FOR_PLAYERS,
        ACTIVE,
        WAITING_FOR_REWARD_EJECTION,
        EJECTING_REWARD,
        COOLDOWN;
    }
}

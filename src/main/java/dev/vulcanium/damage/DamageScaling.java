package dev.vulcanium.damage;

import org.jetbrains.annotations.ApiStatus.Experimental;

@Experimental
public enum DamageScaling {
    NEVER,
    WHEN_CAUSED_BY_LIVING_NON_PLAYER,
    ALWAYS;

    private DamageScaling() {
    }
}

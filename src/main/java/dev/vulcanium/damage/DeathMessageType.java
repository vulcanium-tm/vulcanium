package dev.vulcanium.damage;

import org.jetbrains.annotations.ApiStatus.Experimental;

@Experimental
public enum DeathMessageType {
    DEFAULT,
    FALL_VARIANTS,
    INTENTIONAL_GAME_DESIGN;

    private DeathMessageType() {
    }
}

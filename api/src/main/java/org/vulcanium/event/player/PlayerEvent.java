package org.vulcanium.event.player;

import org.vulcanium.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.Event;

/**
 * Represents a player related event
 */
public abstract class PlayerEvent extends Event {
    protected Player player;

    public PlayerEvent(@NotNull final Player who) {
        player = who;
    }

    PlayerEvent(@NotNull final Player who, boolean async) {
        super(async);
        player = who;

    }

    /**
     * Returns the player involved in this event
     *
     * @return Player who is involved in this event
     */
    @NotNull
    public final Player getPlayer() {
        return player;
    }
}

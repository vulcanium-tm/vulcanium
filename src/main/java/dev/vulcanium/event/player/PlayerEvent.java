package dev.vulcanium.event.player;

import dev.vulcanium.entity.Player;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Event;

/**
 * Represents a player related event
 */
public abstract class PlayerEvent extends Event {
    protected Player player;

    public PlayerEvent(@NotNull Player who) {
        this.player = who;
    }

    public PlayerEvent(@NotNull Player who, boolean async) {
        super(async);
        this.player = who;
    }

    /**
     * Returns the player involved in this event
     *
     * @return Player who is involved in this event
     */
    public final @NotNull Player getPlayer() {
    return this.player;
}
}

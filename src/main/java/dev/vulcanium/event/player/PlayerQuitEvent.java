package dev.vulcanium.event.player;

import dev.vulcanium.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import dev.vulcanium.event.HandlerList;

/**
 * Called when a player leaves a server
 */
public class PlayerQuitEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private String quitMessage;

    public PlayerQuitEvent(@NotNull final Player who, @Nullable final String quitMessage) {
        super(who);
        this.quitMessage = quitMessage;
    }

    /**
     * Gets the quit message to send to all online players
     *
     * @return string quit message
     */
    @Nullable
    public String getQuitMessage() {
        return quitMessage;
    }

    /**
     * Sets the quit message to send to all online players
     *
     * @param quitMessage quit message
     */
    public void setQuitMessage(@Nullable String quitMessage) {
        this.quitMessage = quitMessage;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}

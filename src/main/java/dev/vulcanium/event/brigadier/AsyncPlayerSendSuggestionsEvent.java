package dev.vulcanium.event.brigadier;

import com.mojang.brigadier.suggestion.Suggestions;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.Vulcanium;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.event.player.PlayerEvent;

public class AsyncPlayerSendSuggestionsEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled = false;
    private Suggestions suggestions;
    private final String buffer;

    public AsyncPlayerSendSuggestionsEvent(Player player, Suggestions suggestions, String buffer) {
        super(player, !Vulcanium.isPrimaryThread());
        this.suggestions = suggestions;
        this.buffer = buffer;
    }

    public String getBuffer() {
        return this.buffer;
    }

    public Suggestions getSuggestions() {
        return this.suggestions;
    }

    public void setSuggestions(Suggestions suggestions) {
        this.suggestions = suggestions;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static @NotNull HandlerList getHandlerList() {
        return handlers;
    }
}

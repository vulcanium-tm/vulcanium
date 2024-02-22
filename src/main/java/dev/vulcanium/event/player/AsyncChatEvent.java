package dev.vulcanium.event.player;

import dev.vulcanium.chat.ChatRenderer;
import java.util.Set;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.chat.SignedMessage;
import net.kyori.adventure.text.Component;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class AsyncChatEvent extends AbstractChatEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    @Internal
    public AsyncChatEvent(boolean async, @NotNull Player player, @NotNull Set<Audience> viewers, @NotNull ChatRenderer renderer, @NotNull Component message, @NotNull Component originalMessage, @NotNull SignedMessage signedMessage) {
        super(async, player, viewers, renderer, message, originalMessage, signedMessage);
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

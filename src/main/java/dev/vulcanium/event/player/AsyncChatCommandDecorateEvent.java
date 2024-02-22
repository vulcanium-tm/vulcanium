package dev.vulcanium.event.player;

import net.kyori.adventure.text.Component;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.Internal;

@Experimental
public class AsyncChatCommandDecorateEvent extends AsyncChatDecorateEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    @Internal
    public AsyncChatCommandDecorateEvent(boolean async, @Nullable Player player, @NotNull Component originalMessage, @NotNull Component result) {
        super(async, player, originalMessage, result);
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

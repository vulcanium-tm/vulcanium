package dev.vulcanium.event.player;

import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.event.server.ServerEvent;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Experimental
public class AsyncChatDecorateEvent extends ServerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Player player;
    private final Component originalMessage;
    private Component result;
    private boolean cancelled;

    @Internal
    public AsyncChatDecorateEvent(boolean async, @Nullable Player player, @NotNull Component originalMessage, @NotNull Component result) {
        super(async);
        this.player = player;
        this.originalMessage = originalMessage;
        this.result = result;
    }

    public @Nullable Player player() {
        return this.player;
    }

    public @NotNull Component originalMessage() {
        return this.originalMessage;
    }

    public @NotNull Component result() {
        return this.result;
    }

    public void result(@NotNull Component result) {
        this.result = result;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

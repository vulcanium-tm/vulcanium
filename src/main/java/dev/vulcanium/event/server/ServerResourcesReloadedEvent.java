package dev.vulcanium.event.server;

import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class ServerResourcesReloadedEvent extends ServerEvent {
    public static final HandlerList HANDLER_LIST = new HandlerList();
    private final Cause cause;

    @Internal
    public ServerResourcesReloadedEvent(@NotNull Cause cause) {
        this.cause = cause;
    }

    public @NotNull Cause getCause() {
        return this.cause;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static enum Cause {
        COMMAND,
        PLUGIN;

        private Cause() {
        }
    }
}

package dev.vulcanium.event.server;

import dev.vulcanium.exception.ServerException;
import dev.vulcanium.Vulcanium;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class ServerExceptionEvent extends Event {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull ServerException exception;

    @Internal
    public ServerExceptionEvent(@NotNull ServerException exception) {
        super(!Vulcanium.isPrimaryThread());
        this.exception = exception;
    }

    public @NotNull ServerException getException() {
        return this.exception;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

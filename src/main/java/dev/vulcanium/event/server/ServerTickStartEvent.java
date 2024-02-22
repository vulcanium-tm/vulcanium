package dev.vulcanium.event.server;

import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class ServerTickStartEvent extends Event {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final int tickNumber;

    @Internal
    public ServerTickStartEvent(int tickNumber) {
        this.tickNumber = tickNumber;
    }

    public int getTickNumber() {
        return this.tickNumber;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

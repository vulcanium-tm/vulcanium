package dev.vulcanium.event.server;

import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class ServerTickEndEvent extends Event {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final int tickNumber;
    private final double tickDuration;
    private final long timeEnd;

    @Internal
    public ServerTickEndEvent(int tickNumber, double tickDuration, long timeRemaining) {
        this.tickNumber = tickNumber;
        this.tickDuration = tickDuration;
        this.timeEnd = System.nanoTime() + timeRemaining;
    }

    public int getTickNumber() {
        return this.tickNumber;
    }

    public double getTickDuration() {
        return this.tickDuration;
    }

    public long getTimeRemaining() {
        return this.timeEnd - System.nanoTime();
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

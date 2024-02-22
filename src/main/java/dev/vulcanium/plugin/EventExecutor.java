package dev.vulcanium.plugin;

import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.EventException;
import dev.vulcanium.event.Listener;

/**
 * Interface which defines the class for event call backs to plugins
 */
public interface EventExecutor {
    public void execute(@NotNull Listener listener, @NotNull Event event) throws EventException;
}

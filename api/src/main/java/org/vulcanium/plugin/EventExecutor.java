package org.vulcanium.plugin;

import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.Event;
import org.vulcanium.event.EventException;
import org.vulcanium.event.Listener;

/**
 * Interface which defines the class for event call backs to plugins
 */
public interface EventExecutor {
    public void execute(@NotNull Listener listener, @NotNull Event event) throws EventException;
}

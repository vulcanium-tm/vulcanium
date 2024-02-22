package dev.vulcanium.plugin.lifecycle.event.handler;

import dev.vulcanium.plugin.lifecycle.event.LifecycleEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;

@FunctionalInterface

@Experimental
public interface LifecycleEventHandler<E extends LifecycleEvent> {
    void run(@NotNull E var1);
}

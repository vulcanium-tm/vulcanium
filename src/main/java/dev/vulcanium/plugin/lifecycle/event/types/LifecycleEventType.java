package dev.vulcanium.plugin.lifecycle.event.types;

import dev.vulcanium.plugin.lifecycle.event.LifecycleEvent;
import dev.vulcanium.plugin.lifecycle.event.LifecycleEventOwner;
import dev.vulcanium.plugin.lifecycle.event.handler.LifecycleEventHandler;
import dev.vulcanium.plugin.lifecycle.event.handler.configuration.LifecycleEventHandlerConfiguration;
import dev.vulcanium.plugin.lifecycle.event.handler.configuration.MonitorLifecycleEventHandlerConfiguration;
import dev.vulcanium.plugin.lifecycle.event.handler.configuration.PrioritizedLifecycleEventHandlerConfiguration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

@Experimental
@NonExtendable
public interface LifecycleEventType<O extends LifecycleEventOwner, E extends LifecycleEvent, C extends LifecycleEventHandlerConfiguration<O>> {
    @Contract(
            pure = true
    )
    @NotNull String name();

    @Contract("_ -> new")
    @NotNull C newHandler(@NotNull LifecycleEventHandler<? super E> var1);

    @Experimental
    @NonExtendable
    public interface Prioritizable<O extends LifecycleEventOwner, E extends LifecycleEvent> extends LifecycleEventType<O, E, PrioritizedLifecycleEventHandlerConfiguration<O>> {
    }

    @Experimental
    @NonExtendable
    public interface Monitorable<O extends LifecycleEventOwner, E extends LifecycleEvent> extends LifecycleEventType<O, E, MonitorLifecycleEventHandlerConfiguration<O>> {
    }
}

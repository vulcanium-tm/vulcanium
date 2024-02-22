package dev.vulcanium.plugin.lifecycle.event.handler.configuration;

import dev.vulcanium.plugin.lifecycle.event.LifecycleEventOwner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

@Experimental
@NonExtendable
public interface MonitorLifecycleEventHandlerConfiguration<O extends LifecycleEventOwner> extends LifecycleEventHandlerConfiguration<O> {
    @Contract("-> this")
    MonitorLifecycleEventHandlerConfiguration<O> monitor();
}

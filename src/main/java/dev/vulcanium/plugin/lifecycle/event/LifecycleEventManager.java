package dev.vulcanium.plugin.lifecycle.event;

import dev.vulcanium.plugin.lifecycle.event.handler.LifecycleEventHandler;
import dev.vulcanium.plugin.lifecycle.event.handler.configuration.LifecycleEventHandlerConfiguration;
import dev.vulcanium.plugin.lifecycle.event.types.LifecycleEventType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

@Experimental
@NonExtendable
public interface LifecycleEventManager<O extends LifecycleEventOwner> {
    default <E extends LifecycleEvent> void registerEventHandler(@NotNull LifecycleEventType<? super O, ? extends E, ?> eventType, @NotNull LifecycleEventHandler<? super E> eventHandler) {
        this.registerEventHandler(eventType.newHandler(eventHandler));
    }

    void registerEventHandler(@NotNull LifecycleEventHandlerConfiguration<? super O> var1);
}

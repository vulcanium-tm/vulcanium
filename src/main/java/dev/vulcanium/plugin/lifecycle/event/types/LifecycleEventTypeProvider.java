package dev.vulcanium.plugin.lifecycle.event.types;

import dev.vulcanium.plugin.lifecycle.event.LifecycleEvent;
import dev.vulcanium.plugin.lifecycle.event.LifecycleEventOwner;
import java.util.ServiceLoader;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
interface LifecycleEventTypeProvider {
    LifecycleEventTypeProvider PROVIDER = (LifecycleEventTypeProvider)ServiceLoader.load(LifecycleEventTypeProvider.class).findFirst().orElseThrow();

    <O extends LifecycleEventOwner, E extends LifecycleEvent> LifecycleEventType.Monitorable<O, E> monitor(String var1, Class<? extends O> var2);

    <O extends LifecycleEventOwner, E extends LifecycleEvent> LifecycleEventType.Prioritizable<O, E> prioritized(String var1, Class<? extends O> var2);
}

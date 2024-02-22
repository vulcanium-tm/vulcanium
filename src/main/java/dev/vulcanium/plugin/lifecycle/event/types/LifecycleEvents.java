package dev.vulcanium.plugin.lifecycle.event.types;

import dev.vulcanium.plugin.bootstrap.BootstrapContext;
import dev.vulcanium.plugin.lifecycle.event.LifecycleEvent;
import dev.vulcanium.plugin.lifecycle.event.LifecycleEventOwner;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.Internal;

@Experimental
public final class LifecycleEvents {
    @Internal
    private static <E extends LifecycleEvent> LifecycleEventType.Monitorable<BootstrapContext, E> bootstrap(String name) {
        return monitor(name, BootstrapContext.class);
    }

    @Internal
    private static <E extends LifecycleEvent> LifecycleEventType.Prioritizable<BootstrapContext, E> bootstrapPrioritized(String name) {
        return prioritized(name, BootstrapContext.class);
    }

    @Internal
    private static <O extends LifecycleEventOwner, E extends LifecycleEvent, O2 extends O> LifecycleEventType.Monitorable<O, E> monitor(String name, Class<O2> ownerType) {
        return LifecycleEventTypeProvider.PROVIDER.monitor(name, ownerType);
    }

    @Internal
    private static <O extends LifecycleEventOwner, E extends LifecycleEvent> LifecycleEventType.Prioritizable<O, E> prioritized(String name, Class<? extends O> ownerType) {
        return LifecycleEventTypeProvider.PROVIDER.prioritized(name, ownerType);
    }

    private LifecycleEvents() {
    }
}

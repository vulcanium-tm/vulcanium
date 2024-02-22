package dev.vulcanium.plugin.bootstrap;

import dev.vulcanium.plugin.lifecycle.event.LifecycleEventManager;
import dev.vulcanium.plugin.lifecycle.event.LifecycleEventOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

@Experimental
@NonExtendable
public interface BootstrapContext extends PluginProviderContext, LifecycleEventOwner {
    @NotNull LifecycleEventManager<BootstrapContext> getLifecycleManager();
}

package dev.vulcanium.plugin.lifecycle.event;

import dev.vulcanium.plugin.configuration.PluginMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

@Experimental
@NonExtendable
public interface LifecycleEventOwner {
    @NotNull PluginMeta getPluginMeta();
}
package dev.vulcanium.plugin.provider.entrypoint;

import dev.vulcanium.plugin.configuration.PluginMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public interface DependencyContext {
    boolean isTransitiveDependency(@NotNull PluginMeta var1, @NotNull PluginMeta var2);

    boolean hasDependency(@NotNull String var1);
}
package dev.vulcanium.plugin.loader;

import dev.vulcanium.plugin.bootstrap.PluginProviderContext;
import dev.vulcanium.plugin.loader.library.ClassPathLibrary;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

@NonExtendable
@Experimental
public interface PluginClasspathBuilder {
    @Contract("_ -> this")
    @NotNull PluginClasspathBuilder addLibrary(@NotNull ClassPathLibrary var1);

    @NotNull PluginProviderContext getContext();
}

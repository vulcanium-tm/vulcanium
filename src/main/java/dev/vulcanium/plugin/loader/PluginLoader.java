package dev.vulcanium.plugin.loader;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.OverrideOnly;

@OverrideOnly
@Experimental
public interface PluginLoader {
    void classloader(@NotNull PluginClasspathBuilder var1);
}

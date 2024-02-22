package dev.vulcanium.plugin.provider.classloader;

import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public interface ClassLoaderAccess {
    boolean canAccess(ConfiguredPluginClassLoader var1);
}

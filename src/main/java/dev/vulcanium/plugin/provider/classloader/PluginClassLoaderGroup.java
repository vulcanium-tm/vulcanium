package dev.vulcanium.plugin.provider.classloader;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public interface PluginClassLoaderGroup {
    @Nullable Class<?> getClassByName(String var1, boolean var2, ConfiguredPluginClassLoader var3);

    @Contract(
            mutates = "this"
    )
    void remove(ConfiguredPluginClassLoader var1);

    @Contract(
            mutates = "this"
    )
    void add(ConfiguredPluginClassLoader var1);

    ClassLoaderAccess getAccess();
}

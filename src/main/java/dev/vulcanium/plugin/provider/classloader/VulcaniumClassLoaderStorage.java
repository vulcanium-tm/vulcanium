package dev.vulcanium.plugin.provider.classloader;

import dev.vulcanium.plugin.java.PluginClassLoader;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public interface VulcaniumClassLoaderStorage {
    static VulcaniumClassLoaderStorage instance() {
        return VulcaniumClassLoaderStorageAccess.INSTANCE;
    }

    PluginClassLoaderGroup registerSpigotGroup(PluginClassLoader var1);

    PluginClassLoaderGroup registerOpenGroup(ConfiguredPluginClassLoader var1);

    PluginClassLoaderGroup registerAccessBackedGroup(ConfiguredPluginClassLoader var1, ClassLoaderAccess var2);

    void unregisterClassloader(ConfiguredPluginClassLoader var1);

    boolean registerUnsafePlugin(ConfiguredPluginClassLoader var1);
}

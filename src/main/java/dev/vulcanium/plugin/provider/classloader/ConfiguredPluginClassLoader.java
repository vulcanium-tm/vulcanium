package dev.vulcanium.plugin.provider.classloader;

import dev.vulcanium.plugin.configuration.PluginMeta;
import java.io.Closeable;
import dev.vulcanium.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public interface ConfiguredPluginClassLoader extends Closeable {
    PluginMeta getConfiguration();

    Class<?> loadClass(@NotNull String var1, boolean var2, boolean var3, boolean var4) throws ClassNotFoundException;

    void init(JavaPlugin var1);

    @Nullable JavaPlugin getPlugin();

    @Nullable PluginClassLoaderGroup getGroup();
}

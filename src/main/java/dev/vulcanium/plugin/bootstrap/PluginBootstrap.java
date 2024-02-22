package dev.vulcanium.plugin.bootstrap;

import dev.vulcanium.plugin.provider.util.ProviderUtil;
import dev.vulcanium.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.OverrideOnly;

@OverrideOnly
@Experimental
public interface PluginBootstrap {
    void bootstrap(@NotNull BootstrapContext var1);

    default @NotNull JavaPlugin createPlugin(@NotNull PluginProviderContext context) {
        return (JavaPlugin)ProviderUtil.loadClass(context.getConfiguration().getMainClass(), JavaPlugin.class, this.getClass().getClassLoader());
    }
}
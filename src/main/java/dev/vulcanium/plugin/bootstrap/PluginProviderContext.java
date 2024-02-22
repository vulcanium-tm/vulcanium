package dev.vulcanium.plugin.bootstrap;

import dev.vulcanium.plugin.configuration.PluginMeta;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.NonExtendable;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

@NonExtendable
@Experimental
public interface PluginProviderContext {
    @NotNull PluginMeta getConfiguration();

    @NotNull Path getDataDirectory();

    @NotNull ComponentLogger getLogger();

    @NotNull Path getPluginSource();
}

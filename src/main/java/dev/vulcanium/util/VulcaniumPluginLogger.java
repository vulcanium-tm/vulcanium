package dev.vulcanium.util;

import org.jetbrains.annotations.NotNull;
import dev.vulcanium.plugin.configuration.PluginMeta;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class VulcaniumPluginLogger extends Logger {
    private VulcaniumPluginLogger(@NotNull PluginMeta meta) {
        super(meta.getLoggerPrefix() != null ? meta.getLoggerPrefix() : meta.getName(), (String)null);
    }
    public static @NotNull Logger getLogger(@NotNull PluginMeta meta) {
        Logger logger = new VulcaniumPluginLogger(meta);
        if (!LogManager.getLogManager().addLogger((Logger)logger)) {
            logger = LogManager.getLogManager().getLogger(meta.getLoggerPrefix() != null ? meta.getLoggerPrefix() : meta.getName());
        }

        return (Logger)logger;
    }

    public void setParent(@NotNull Logger parent) {
        if (this.getParent() != null) {
            this.warning("Ignoring attempt to change parent of plugin logger");
        } else {
            this.log(Level.FINE, "Setting plugin logger parent to {0}", parent);
            super.setParent(parent);
        }

    }
}

package dev.vulcanium.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.Vulcanium;

public interface VersionFetcher {
    long getCacheTime();

    @NotNull Component getVersionMessage(@NotNull String var1);

    public static class DummyVersionFetcher implements VersionFetcher {
        public DummyVersionFetcher() {
        }

        public long getCacheTime() {
            return -1L;
        }

        public @NotNull Component getVersionMessage(@NotNull String serverVersion) {
            Vulcanium.getLogger().warning("Version provider has not been set, cannot check for updates!");
            Vulcanium.getLogger().info("Override the default implementation of org.bukkit.UnsafeValues#getVersionFetcher()");
            (new Throwable()).printStackTrace();
            return Component.text("Unable to check for updates. No version provider set.", NamedTextColor.RED);
        }
    }
}

package dev.vulcanium.plugin.configuration;

import java.util.List;
import dev.vulcanium.permissions.Permission;
import dev.vulcanium.permissions.PermissionDefault;
import dev.vulcanium.plugin.PluginLoadOrder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

@NonExtendable
@Experimental
public interface PluginMeta {
    @NotNull String getName();

    default @NotNull String getDisplayName() {
        String var10000 = this.getName();
        return var10000 + " v" + this.getVersion();
    }

    @NotNull String getMainClass();

    @NotNull PluginLoadOrder getLoadOrder();

    @NotNull String getVersion();

    @Nullable String getLoggerPrefix();

    @NotNull List<String> getPluginDependencies();

    @NotNull List<String> getPluginSoftDependencies();

    @NotNull List<String> getLoadBeforePlugins();

    @NotNull List<String> getProvidedPlugins();

    @NotNull List<String> getAuthors();

    @NotNull List<String> getContributors();

    @Nullable String getDescription();

    @Nullable String getWebsite();

    @NotNull List<Permission> getPermissions();

    @NotNull PermissionDefault getPermissionDefault();

    @Nullable String getAPIVersion();
}

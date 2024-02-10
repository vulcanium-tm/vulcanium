package org.vulcanium.command.defaults;

import org.vulcanium.Vulcanium;
import org.vulcanium.ChatColor;
import org.vulcanium.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.command.CommandSender;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PluginsCommand extends VulcaniumCommand {
    public PluginsCommand(@NotNull String name) {
        super(name);
        this.description = "Gets a list of plugins running on the server";
        this.usageMessage = "/plugins";
        this.setPermission("vulcanium.command.plugins");
        this.setAliases(List.of("pl"));
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String currentAlias, @NotNull String[] args) {
        if (!testPermission(sender)) return true;

        sender.sendMessage("Plugins " + getPluginList());
        return true;
    }

    @NotNull
    @Override
    public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        return Collections.emptyList();
    }

    @NotNull
    private String getPluginList() {
        StringBuilder pluginList = new StringBuilder();
        Plugin[] plugins = Vulcanium.getPluginManager().getPlugins();

        for (Plugin plugin : plugins) {
            if (pluginList.length() > 0) {
                pluginList.append(ChatColor.WHITE);
                pluginList.append(", ");
            }

            pluginList.append(plugin.isEnabled() ? ChatColor.GREEN : ChatColor.RED);
            pluginList.append(plugin.getDescription().getName());

            if (plugin.getDescription().getProvides().size() > 0) {
                pluginList.append(" (").append(String.join(", ", plugin.getDescription().getProvides())).append(")");
            }
        }

        return "(" + plugins.length + "): " + pluginList.toString();
    }
}

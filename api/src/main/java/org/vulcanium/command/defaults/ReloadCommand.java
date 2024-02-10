package org.vulcanium.command.defaults;

import java.util.Collections;
import java.util.List;
import org.vulcanium.Vulcanium;
import org.vulcanium.ChatColor;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.command.Command;
import org.vulcanium.command.CommandSender;

public class ReloadCommand extends VulcaniumCommand {
    public ReloadCommand(@NotNull String name) {
        super(name);
        this.description = "Reloads the server configuration and plugins";
        this.usageMessage = "/reload";
        this.setPermission("vulcanium.command.reload");
        this.setAliases(List.of("rl"));
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String currentAlias, @NotNull String[] args) {
        if (!testPermission(sender)) return true;

        Command.broadcastCommandMessage(sender, ChatColor.RED + "Please note that this command is not supported and may cause issues when using some plugins.");
        Command.broadcastCommandMessage(sender, ChatColor.RED + "If you encounter any issues please use the /stop command to restart your server.");
        Vulcanium.reload();
        Command.broadcastCommandMessage(sender, ChatColor.GREEN + "Reload complete.");

        return true;
    }

    @NotNull
    @Override
    public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        return Collections.emptyList();
    }
}

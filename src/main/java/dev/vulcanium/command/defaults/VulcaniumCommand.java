package dev.vulcanium.command.defaults;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import dev.vulcanium.command.Command;

public abstract class VulcaniumCommand extends Command {
    protected VulcaniumCommand(@NotNull String name) {
        super(name);
    }

    protected VulcaniumCommand(@NotNull String name, @NotNull String description, @NotNull String usageMessage, @NotNull List<String> aliases) {
        super(name, description, usageMessage, aliases);
    }
}

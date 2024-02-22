package dev.vulcanium.event.brigadier;

import com.mojang.brigadier.tree.ArgumentCommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import dev.vulcanium.command.Command;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.event.server.ServerEvent;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.brigadier.BrigadierCommand;
import dev.vulcanium.brigadier.BrigadierCommandSource;

@Experimental
public class CommandRegisteredEvent<S extends BrigadierCommandSource> extends ServerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final String commandLabel;
    private final Command command;
    private final BrigadierCommand<S> brigadierCommand;
    private final RootCommandNode<S> root;
    private final ArgumentCommandNode<S, String> defaultArgs;
    private LiteralCommandNode<S> literal;
    private boolean rawCommand = false;
    private boolean cancelled = false;

    public CommandRegisteredEvent(String commandLabel, BrigadierCommand<S> brigadierCommand, Command command, RootCommandNode<S> root, LiteralCommandNode<S> literal, ArgumentCommandNode<S, String> defaultArgs) {
        this.commandLabel = commandLabel;
        this.brigadierCommand = brigadierCommand;
        this.command = command;
        this.root = root;
        this.literal = literal;
        this.defaultArgs = defaultArgs;
    }

    public String getCommandLabel() {
        return this.commandLabel;
    }

    public BrigadierCommand<S> getBrigadierCommand() {
        return this.brigadierCommand;
    }

    public Command getCommand() {
        return this.command;
    }

    public RootCommandNode<S> getRoot() {
        return this.root;
    }

    public ArgumentCommandNode<S, String> getDefaultArgs() {
        return this.defaultArgs;
    }

    public LiteralCommandNode<S> getLiteral() {
        return this.literal;
    }

    public void setLiteral(LiteralCommandNode<S> literal) {
        this.literal = literal;
    }

    public boolean isRawCommand() {
        return this.rawCommand;
    }

    public void setRawCommand(boolean rawCommand) {
        this.rawCommand = rawCommand;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static @NotNull HandlerList getHandlerList() {
        return handlers;
    }
}

package dev.vulcanium.event.world;

import dev.vulcanium.GameRule;
import dev.vulcanium.command.CommandSender;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.world.World;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WorldGameRuleChangeEvent extends WorldEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final CommandSender commandSender;
    private final GameRule<?> gameRule;
    private String value;
    private boolean cancelled;

    @Internal
    public WorldGameRuleChangeEvent(@NotNull World world, @Nullable CommandSender commandSender, @NotNull GameRule<?> gameRule, @NotNull String value) {
        super(world);
        this.commandSender = commandSender;
        this.gameRule = gameRule;
        this.value = value;
    }

    public @Nullable CommandSender getCommandSender() {
        return this.commandSender;
    }

    public @NotNull GameRule<?> getGameRule() {
        return this.gameRule;
    }

    public @NotNull String getValue() {
        return this.value;
    }

    public void setValue(@NotNull String value) {
        this.value = value;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

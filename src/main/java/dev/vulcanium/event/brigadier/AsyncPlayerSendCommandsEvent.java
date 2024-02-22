package dev.vulcanium.event.brigadier;

import dev.vulcanium.brigadier.BrigadierCommandSource;
import com.mojang.brigadier.tree.RootCommandNode;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.Vulcanium;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.event.player.PlayerEvent;

@Experimental
public class AsyncPlayerSendCommandsEvent<S extends BrigadierCommandSource> extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final RootCommandNode<S> node;
    private final boolean hasFiredAsync;

    public AsyncPlayerSendCommandsEvent(Player player, RootCommandNode<S> node, boolean hasFiredAsync) {
        super(player, !Vulcanium.isPrimaryThread());
        this.node = node;
        this.hasFiredAsync = hasFiredAsync;
    }

    public RootCommandNode<S> getCommandNode() {
        return this.node;
    }

    public boolean hasFiredAsync() {
        return this.hasFiredAsync;
    }

    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static @NotNull HandlerList getHandlerList() {
        return handlers;
    }
}

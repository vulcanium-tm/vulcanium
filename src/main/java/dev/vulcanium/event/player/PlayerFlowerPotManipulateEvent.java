package dev.vulcanium.event.player;

import dev.vulcanium.block.Block;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerFlowerPotManipulateEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull Block flowerpot;
    private final @NotNull ItemStack item;
    private final boolean placing;
    private boolean cancelled;

    @Internal
    public PlayerFlowerPotManipulateEvent(@NotNull Player player, @NotNull Block flowerpot, @NotNull ItemStack item, boolean placing) {
        super(player);
        this.flowerpot = flowerpot;
        this.item = item;
        this.placing = placing;
    }

    public @NotNull Block getFlowerpot() {
        return this.flowerpot;
    }

    public @NotNull ItemStack getItem() {
        return this.item;
    }

    public boolean isPlacing() {
        return this.placing;
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

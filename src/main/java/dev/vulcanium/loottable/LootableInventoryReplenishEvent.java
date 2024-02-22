package dev.vulcanium.loottable;

import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class LootableInventoryReplenishEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull LootableInventory inventory;
    private boolean cancelled;

    @Internal
    public LootableInventoryReplenishEvent(@NotNull Player player, @NotNull LootableInventory inventory) {
        super(player);
        this.inventory = inventory;
    }

    public @NotNull LootableInventory getInventory() {
        return this.inventory;
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

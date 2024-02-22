package dev.vulcanium.event.player;

import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PlayerReadyArrowEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull ItemStack bow;
    private final @NotNull ItemStack arrow;
    private boolean cancelled;

    public PlayerReadyArrowEvent(@NotNull Player player, @NotNull ItemStack bow, @NotNull ItemStack arrow) {
        super(player);
        this.bow = bow;
        this.arrow = arrow;
    }

    public @NotNull ItemStack getBow() {
        return this.bow;
    }

    public @NotNull ItemStack getArrow() {
        return this.arrow;
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

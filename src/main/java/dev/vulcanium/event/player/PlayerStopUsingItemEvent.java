package dev.vulcanium.event.player;

import dev.vulcanium.entity.Player;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PlayerStopUsingItemEvent extends PlayerEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull ItemStack item;
    private final int ticksHeldFor;

    public PlayerStopUsingItemEvent(@NotNull Player player, @NotNull ItemStack item, int ticksHeldFor) {
        super(player);
        this.item = item;
        this.ticksHeldFor = ticksHeldFor;
    }

    public @NotNull ItemStack getItem() {
        return this.item;
    }

    public int getTicksHeldFor() {
        return this.ticksHeldFor;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

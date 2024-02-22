package dev.vulcanium.event.player;

import dev.vulcanium.entity.Firework;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerElytraBoostEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull ItemStack itemStack;
    private final @NotNull Firework firework;
    private boolean consume = true;
    private boolean cancelled;

    @Internal
    public PlayerElytraBoostEvent(@NotNull Player player, @NotNull ItemStack itemStack, @NotNull Firework firework) {
        super(player);
        this.itemStack = itemStack;
        this.firework = firework;
    }

    public @NotNull ItemStack getItemStack() {
        return this.itemStack;
    }

    public @NotNull Firework getFirework() {
        return this.firework;
    }

    public boolean shouldConsume() {
        return this.consume;
    }

    public void setShouldConsume(boolean consume) {
        this.consume = consume;
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

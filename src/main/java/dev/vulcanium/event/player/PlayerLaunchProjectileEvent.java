package dev.vulcanium.event.player;

import dev.vulcanium.entity.Player;
import dev.vulcanium.entity.Projectile;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerLaunchProjectileEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull Projectile projectile;
    private final @NotNull ItemStack itemStack;
    private boolean consumeItem = true;
    private boolean cancelled;

    @Internal
    public PlayerLaunchProjectileEvent(@NotNull Player shooter, @NotNull ItemStack itemStack, @NotNull Projectile projectile) {
        super(shooter);
        this.itemStack = itemStack;
        this.projectile = projectile;
    }

    public @NotNull Projectile getProjectile() {
        return this.projectile;
    }

    public @NotNull ItemStack getItemStack() {
        return this.itemStack;
    }

    public boolean shouldConsume() {
        return this.consumeItem;
    }

    public void setShouldConsume(boolean consumeItem) {
        this.consumeItem = consumeItem;
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

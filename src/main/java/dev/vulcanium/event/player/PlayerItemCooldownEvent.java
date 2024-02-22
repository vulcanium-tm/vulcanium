package dev.vulcanium.event.player;

import com.google.common.base.Preconditions;
import dev.vulcanium.Material;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerItemCooldownEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull Material type;
    private int cooldown;
    private boolean cancelled;

    @Internal
    public PlayerItemCooldownEvent(@NotNull Player player, @NotNull Material type, int cooldown) {
        super(player);
        this.type = type;
        this.cooldown = cooldown;
    }

    public @NotNull Material getType() {
        return this.type;
    }

    public int getCooldown() {
        return this.cooldown;
    }

    public void setCooldown(int cooldown) {
        Preconditions.checkArgument(cooldown >= 0, "The cooldown has to be equal to or greater than 0!");
        this.cooldown = cooldown;
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

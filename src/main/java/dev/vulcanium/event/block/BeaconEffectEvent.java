package dev.vulcanium.event.block;

import dev.vulcanium.block.Block;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class BeaconEffectEvent extends BlockEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Player player;
    private final boolean primary;
    private PotionEffect effect;
    private boolean cancelled;

    @Internal
    public BeaconEffectEvent(@NotNull Block block, @NotNull PotionEffect effect, @NotNull Player player, boolean primary) {
        super(block);
        this.effect = effect;
        this.player = player;
        this.primary = primary;
    }

    public @NotNull PotionEffect getEffect() {
        return this.effect;
    }

    public void setEffect(@NotNull PotionEffect effect) {
        this.effect = effect;
    }

    public @NotNull Player getPlayer() {
        return this.player;
    }

    public boolean isPrimary() {
        return this.primary;
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

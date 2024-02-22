package dev.vulcanium.event.player;

import dev.vulcanium.block.Block;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.potion.PotionEffectType;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerChangeBeaconEffectEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Block beacon;
    private PotionEffectType primary;
    private PotionEffectType secondary;
    private boolean consumeItem = true;
    private boolean cancelled;

    @Internal
    public PlayerChangeBeaconEffectEvent(@NotNull Player player, @Nullable PotionEffectType primary, @Nullable PotionEffectType secondary, @NotNull Block beacon) {
        super(player);
        this.primary = primary;
        this.secondary = secondary;
        this.beacon = beacon;
    }

    public @Nullable PotionEffectType getPrimary() {
        return this.primary;
    }

    public void setPrimary(@Nullable PotionEffectType primary) {
        this.primary = primary;
    }

    public @Nullable PotionEffectType getSecondary() {
        return this.secondary;
    }

    public void setSecondary(@Nullable PotionEffectType secondary) {
        this.secondary = secondary;
    }

    public @NotNull Block getBeacon() {
        return this.beacon;
    }

    public boolean willConsumeItem() {
        return this.consumeItem;
    }

    public void setConsumeItem(boolean consumeItem) {
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

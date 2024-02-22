package dev.vulcanium.event.block;

import java.util.List;
import dev.vulcanium.block.Block;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.event.player.PlayerEvent;
import dev.vulcanium.inventory.EquipmentSlot;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerShearBlockEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Block block;
    private final ItemStack item;
    private final EquipmentSlot hand;
    private final List<ItemStack> drops;
    private boolean cancelled;

    @Internal
    public PlayerShearBlockEvent(@NotNull Player player, @NotNull Block block, @NotNull ItemStack item, @NotNull EquipmentSlot hand, @NotNull List<ItemStack> drops) {
        super(player);
        this.block = block;
        this.item = item;
        this.hand = hand;
        this.drops = drops;
    }

    public @NotNull Block getBlock() {
        return this.block;
    }

    public @NotNull ItemStack getItem() {
        return this.item;
    }

    public @NotNull EquipmentSlot getHand() {
        return this.hand;
    }

    public @NotNull List<ItemStack> getDrops() {
        return this.drops;
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

package dev.vulcanium.event.block;

import dev.vulcanium.block.Block;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class BlockPreDispenseEvent extends BlockEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final ItemStack itemStack;
    private final int slot;
    private boolean cancelled;

    @Internal
    public BlockPreDispenseEvent(@NotNull Block block, @NotNull ItemStack itemStack, int slot) {
        super(block);
        this.itemStack = itemStack;
        this.slot = slot;
    }

    public @NotNull ItemStack getItemStack() {
        return this.itemStack;
    }

    public int getSlot() {
        return this.slot;
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

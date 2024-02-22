package dev.vulcanium.event.block;

import dev.vulcanium.block.Block;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BlockBreakBlockEvent extends BlockExpEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Block source;
    private final List<ItemStack> drops;

    @Internal
    public BlockBreakBlockEvent(@NotNull Block block, @NotNull Block source, @NotNull List<ItemStack> drops) {
        super(block, 0);
        this.source = source;
        this.drops = drops;
    }

    public @NotNull List<ItemStack> getDrops() {
        return this.drops;
    }

    public @NotNull Block getSource() {
        return this.source;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

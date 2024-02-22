package dev.vulcanium.loottable;

import dev.vulcanium.block.Block;
import org.jetbrains.annotations.NotNull;

public interface LootableBlockInventory extends LootableInventory {
    @NotNull Block getBlock();
}
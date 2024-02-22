package dev.vulcanium.loottable;


import dev.vulcanium.entity.Entity;
import org.jetbrains.annotations.NotNull;

public interface LootableEntityInventory extends LootableInventory {
    @NotNull Entity getEntity();
}

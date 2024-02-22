package dev.vulcanium.event.inventory;

import dev.vulcanium.inventory.InventoryView;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PrepareResultEvent extends PrepareInventoryResultEvent {
    @Internal
    public PrepareResultEvent(@NotNull InventoryView inventory, @Nullable ItemStack result) {
        super(inventory, result);
    }

    public @Nullable ItemStack getResult() {
        return super.getResult();
    }

    public void setResult(@Nullable ItemStack result) {
        super.setResult(result);
    }
}

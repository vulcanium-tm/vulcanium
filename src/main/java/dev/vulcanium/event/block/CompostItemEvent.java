package dev.vulcanium.event.block;

import dev.vulcanium.block.Block;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class CompostItemEvent extends BlockEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final ItemStack item;
    private boolean willRaiseLevel;

    @Internal
    public CompostItemEvent(@NotNull Block composter, @NotNull ItemStack item, boolean willRaiseLevel) {
        super(composter);
        this.item = item;
        this.willRaiseLevel = willRaiseLevel;
    }

    public @NotNull ItemStack getItem() {
        return this.item;
    }

    public boolean willRaiseLevel() {
        return this.willRaiseLevel;
    }

    public void setWillRaiseLevel(boolean willRaiseLevel) {
        this.willRaiseLevel = willRaiseLevel;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

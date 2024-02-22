package dev.vulcanium.event.player;

import dev.vulcanium.entity.ItemFrame;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerItemFrameChangeEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final ItemFrame itemFrame;
    private final ItemFrameChangeAction action;
    private ItemStack itemStack;
    private boolean cancelled;

    @Internal
    public PlayerItemFrameChangeEvent(@NotNull Player player, @NotNull ItemFrame itemFrame, @NotNull ItemStack itemStack, @NotNull ItemFrameChangeAction action) {
        super(player);
        this.itemFrame = itemFrame;
        this.itemStack = itemStack;
        this.action = action;
    }

    public @NotNull ItemFrame getItemFrame() {
        return this.itemFrame;
    }

    public @NotNull ItemStack getItemStack() {
        return this.itemStack;
    }

    public void setItemStack(@Nullable ItemStack itemStack) {
        this.itemStack = itemStack == null ? ItemStack.empty() : itemStack;
    }

    public @NotNull ItemFrameChangeAction getAction() {
        return this.action;
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

    public static enum ItemFrameChangeAction {
        PLACE,
        REMOVE,
        ROTATE;

        private ItemFrameChangeAction() {
        }
    }
}

package dev.vulcanium.event.player;

import dev.vulcanium.entity.Player;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PlayerInventorySlotChangeEvent extends PlayerEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final int rawSlot;
    private final int slot;
    private final ItemStack oldItemStack;
    private final ItemStack newItemStack;
    private boolean triggerAdvancements = true;

    public PlayerInventorySlotChangeEvent(@NotNull Player player, int rawSlot, @NotNull ItemStack oldItemStack, @NotNull ItemStack newItemStack) {
        super(player);
        this.rawSlot = rawSlot;
        this.slot = player.getOpenInventory().convertSlot(rawSlot);
        this.oldItemStack = oldItemStack;
        this.newItemStack = newItemStack;
    }

    public int getRawSlot() {
        return this.rawSlot;
    }

    public int getSlot() {
        return this.slot;
    }

    public @NotNull ItemStack getOldItemStack() {
        return this.oldItemStack;
    }

    public @NotNull ItemStack getNewItemStack() {
        return this.newItemStack;
    }

    public boolean shouldTriggerAdvancements() {
        return this.triggerAdvancements;
    }

    public void setShouldTriggerAdvancements(boolean triggerAdvancements) {
        this.triggerAdvancements = triggerAdvancements;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

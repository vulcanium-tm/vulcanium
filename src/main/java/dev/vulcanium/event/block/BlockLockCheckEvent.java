package dev.vulcanium.event.block;

import com.google.common.base.Preconditions;
import dev.vulcanium.block.LockableTileState;
import java.util.Objects;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import dev.vulcanium.block.Block;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.ItemStack;
import dev.vulcanium.inventory.PlayerInventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

public class BlockLockCheckEvent extends BlockEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final LockableTileState state;
    private final Player player;
    private Component lockedMessage;
    private Sound lockedSound;
    private ItemStack itemStack;
    private Event.Result result;

    @Internal
    public BlockLockCheckEvent(@NotNull Block block, @NotNull LockableTileState state, @NotNull Player player, @NotNull Component lockedMessage, @NotNull Sound lockedSound) {
        super(block);
        this.result = Result.DEFAULT;
        this.state = state;
        this.player = player;
        this.lockedMessage = lockedMessage;
        this.lockedSound = lockedSound;
    }

    public @NotNull LockableTileState getBlockState() {
        return this.state;
    }

    public @NotNull Player getPlayer() {
        return this.player;
    }

    public @NotNull ItemStack getKeyItem() {
        ItemStack var10000 = this.itemStack;
        PlayerInventory var10001 = this.player.getInventory();
        Objects.requireNonNull(var10001);
        return (ItemStack)Objects.requireNonNullElseGet(var10000, var10001::getItemInMainHand);
    }

    public void setKeyItem(@NotNull ItemStack stack) {
        Preconditions.checkArgument(stack != null, "stack cannot be null");
        this.itemStack = stack;
    }

    public void resetKeyItem() {
        this.itemStack = null;
    }

    public boolean isUsingCustomKeyItemStack() {
        return this.itemStack != null;
    }

    @NotNull
    public Event.@NotNull Result getResult() {
        return this.result;
    }

    public void setResult(@NotNull Event.@NotNull Result result) {
        this.result = result;
    }

    public void denyWithMessageAndSound(@Nullable Component lockedMessage, @Nullable Sound lockedSound) {
        this.result = Result.DENY;
        this.lockedMessage = lockedMessage;
        this.lockedSound = lockedSound;
    }

    public @Nullable Component getLockedMessage() {
        return this.lockedMessage;
    }

    public void setLockedMessage(@Nullable Component lockedMessage) {
        this.lockedMessage = lockedMessage;
    }

    public @Nullable Sound getLockedSound() {
        return this.lockedSound;
    }

    public void setLockedSound(@Nullable Sound lockedSound) {
        this.lockedSound = lockedSound;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

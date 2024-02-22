package dev.vulcanium.event.block;

import dev.vulcanium.block.Block;
import dev.vulcanium.block.data.BlockData;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class BlockDestroyEvent extends BlockExpEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull BlockData newState;
    private boolean willDrop;
    private boolean playEffect = true;
    private BlockData effectBlock;
    private boolean cancelled;

    @Internal
    public BlockDestroyEvent(@NotNull Block block, @NotNull BlockData newState, @NotNull BlockData effectBlock, int xp, boolean willDrop) {
        super(block, xp);
        this.newState = newState;
        this.effectBlock = effectBlock;
        this.willDrop = willDrop;
    }

    public @NotNull BlockData getEffectBlock() {
        return this.effectBlock;
    }

    public void setEffectBlock(@NotNull BlockData effectBlock) {
        this.effectBlock = effectBlock;
    }

    public @NotNull BlockData getNewState() {
        return this.newState;
    }

    public boolean willDrop() {
        return this.willDrop;
    }

    public void setWillDrop(boolean willDrop) {
        this.willDrop = willDrop;
    }

    public boolean playEffect() {
        return this.playEffect;
    }

    public void setPlayEffect(boolean playEffect) {
        this.playEffect = playEffect;
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

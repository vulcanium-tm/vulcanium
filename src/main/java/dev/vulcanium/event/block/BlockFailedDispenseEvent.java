package dev.vulcanium.event.block;

import dev.vulcanium.block.Block;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;
import dev.vulcanium.event.Event;

public class BlockFailedDispenseEvent extends BlockEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private boolean shouldPlayEffect = true;

    @Internal
    public BlockFailedDispenseEvent(@NotNull Block theBlock) {
        super(theBlock);
    }

    public boolean shouldPlayEffect() {
        return this.shouldPlayEffect;
    }

    public void shouldPlayEffect(boolean playEffect) {
        this.shouldPlayEffect = playEffect;
    }

    public boolean callEvent() {
        super.callEvent();
        return this.shouldPlayEffect();
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

package dev.vulcanium.event.block;

import dev.vulcanium.block.Block;
import dev.vulcanium.entity.Raider;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

/** @deprecated */
@Deprecated
public class BellRevealRaiderEvent extends BlockEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Raider raider;
    private boolean cancelled;

    @Internal
    public BellRevealRaiderEvent(@NotNull Block theBlock, @NotNull Raider raider) {
        super(theBlock);
        this.raider = raider;
    }

    public @NotNull Raider getEntity() {
        return this.raider;
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

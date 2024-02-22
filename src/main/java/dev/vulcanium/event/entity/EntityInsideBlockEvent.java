package dev.vulcanium.event.entity;

import dev.vulcanium.block.Block;
import dev.vulcanium.entity.Entity;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EntityInsideBlockEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Block block;
    private boolean cancelled;

    @Internal
    public EntityInsideBlockEvent(@NotNull Entity entity, @NotNull Block block) {
        super(entity);
        this.block = block;
    }

    public @NotNull Block getBlock() {
        return this.block;
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

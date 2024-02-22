package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Shulker;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class ShulkerDuplicateEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Shulker parent;
    private boolean cancelled;

    @Internal
    public ShulkerDuplicateEvent(@NotNull Shulker child, @NotNull Shulker parent) {
        super(child);
        this.parent = parent;
    }

    public @NotNull Shulker getEntity() {
        return (Shulker)super.getEntity();
    }

    public @NotNull Shulker getParent() {
        return this.parent;
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

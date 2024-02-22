package dev.vulcanium.event.entity;

import dev.vulcanium.Location;
import dev.vulcanium.entity.Entity;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EntityPathfindEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @Nullable Entity targetEntity;
    private final @NotNull Location location;
    private boolean cancelled;

    @Internal
    public EntityPathfindEvent(@NotNull Entity entity, @NotNull Location location, @Nullable Entity targetEntity) {
        super(entity);
        this.targetEntity = targetEntity;
        this.location = location;
    }

    public @NotNull Entity getEntity() {
        return this.entity;
    }

    public @Nullable Entity getTargetEntity() {
        return this.targetEntity;
    }

    public @NotNull Location getLoc() {
        return this.location;
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

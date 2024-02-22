package dev.vulcanium.event.entity;

import dev.vulcanium.PortalType;
import dev.vulcanium.world.World;
import dev.vulcanium.entity.Entity;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EntityPortalReadyEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final PortalType portalType;
    private World targetWorld;
    private boolean cancelled;

    @Internal
    public EntityPortalReadyEvent(@NotNull Entity entity, @Nullable World targetWorld, @NotNull PortalType portalType) {
        super(entity);
        this.targetWorld = targetWorld;
        this.portalType = portalType;
    }

    public @Nullable World getTargetWorld() {
        return this.targetWorld;
    }

    public void setTargetWorld(@Nullable World targetWorld) {
        this.targetWorld = targetWorld;
    }

    public @NotNull PortalType getPortalType() {
        return this.portalType;
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

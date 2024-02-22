package dev.vulcanium.event.entity;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.LightningStrike;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;

import java.util.Collections;

public class EntityZapEvent extends EntityTransformEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull LightningStrike bolt;
    private boolean cancelled;

    @Internal
    public EntityZapEvent(@NotNull Entity entity, @NotNull LightningStrike bolt, @NotNull Entity replacementEntity) {
        super(entity, Collections.singletonList(replacementEntity), TransformReason.LIGHTNING);
        this.bolt = bolt;
    }

    public @NotNull LightningStrike getBolt() {
        return this.bolt;
    }

    public @NotNull Entity getReplacementEntity() {
        return super.getTransformedEntity();
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

package dev.vulcanium.event.entity;

import dev.vulcanium.DyeColor;
import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EntityDyeEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Player player;
    private DyeColor dyeColor;
    private boolean cancelled;

    @Internal
    public EntityDyeEvent(@NotNull Entity entity, @NotNull DyeColor dyeColor, @Nullable Player player) {
        super(entity);
        this.dyeColor = dyeColor;
        this.player = player;
    }

    public @NotNull DyeColor getColor() {
        return this.dyeColor;
    }

    public void setColor(@NotNull DyeColor dyeColor) {
        this.dyeColor = dyeColor;
    }

    public @Nullable Player getPlayer() {
        return this.player;
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

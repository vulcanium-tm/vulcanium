package dev.vulcanium.event.player;

import dev.vulcanium.entity.LivingEntity;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerNameEntityEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private LivingEntity entity;
    private Component name;
    private boolean persistent;
    private boolean cancelled;

    @Internal
    public PlayerNameEntityEvent(@NotNull Player player, @NotNull LivingEntity entity, @NotNull Component name, boolean persistent) {
        super(player);
        this.entity = entity;
        this.name = name;
        this.persistent = persistent;
    }

    public @Nullable Component getName() {
        return this.name;
    }

    public void setName(@Nullable Component name) {
        this.name = name;
    }

    public @NotNull LivingEntity getEntity() {
        return this.entity;
    }

    public void setEntity(@NotNull LivingEntity entity) {
        this.entity = entity;
    }

    public boolean isPersistent() {
        return this.persistent;
    }

    public void setPersistent(boolean persistent) {
        this.persistent = persistent;
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

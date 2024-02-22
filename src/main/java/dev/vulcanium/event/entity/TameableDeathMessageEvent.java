package dev.vulcanium.event.entity;

import net.kyori.adventure.text.Component;
import dev.vulcanium.entity.Tameable;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class TameableDeathMessageEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private Component deathMessage;
    private boolean cancelled;

    @Internal
    public TameableDeathMessageEvent(@NotNull Tameable tameable, @NotNull Component deathMessage) {
        super(tameable);
        this.deathMessage = deathMessage;
    }

    public void deathMessage(@NotNull Component deathMessage) {
        this.deathMessage = deathMessage;
    }

    public @NotNull Component deathMessage() {
        return this.deathMessage;
    }

    public @NotNull Tameable getEntity() {
        return (Tameable)super.getEntity();
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

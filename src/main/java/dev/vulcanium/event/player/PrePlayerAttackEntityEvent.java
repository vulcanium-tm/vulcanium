package dev.vulcanium.event.player;

import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PrePlayerAttackEntityEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull Entity attacked;
    private final boolean willAttack;
    private boolean cancelled;

    @Internal
    public PrePlayerAttackEntityEvent(@NotNull Player player, @NotNull Entity attacked, boolean willAttack) {
        super(player);
        this.attacked = attacked;
        this.willAttack = willAttack;
        this.cancelled = !willAttack;
    }

    public @NotNull Entity getAttacked() {
        return this.attacked;
    }

    public boolean willAttack() {
        return this.willAttack;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        if (this.willAttack) {
            this.cancelled = cancel;
        }
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

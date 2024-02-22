package dev.vulcanium.event.entity;

import dev.vulcanium.entity.ElderGuardian;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class ElderGuardianAppearanceEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Player affectedPlayer;
    private boolean cancelled;

    @Internal
    public ElderGuardianAppearanceEvent(@NotNull ElderGuardian guardian, @NotNull Player affectedPlayer) {
        super(guardian);
        this.affectedPlayer = affectedPlayer;
    }

    public @NotNull Player getAffectedPlayer() {
        return this.affectedPlayer;
    }

    public @NotNull ElderGuardian getEntity() {
        return (ElderGuardian)super.getEntity();
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

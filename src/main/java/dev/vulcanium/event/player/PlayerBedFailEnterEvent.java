package dev.vulcanium.event.player;

import dev.vulcanium.block.Block;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerBedFailEnterEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final FailReason failReason;
    private final Block bed;
    private boolean willExplode;
    private Component message;
    private boolean cancelled;

    @Internal
    public PlayerBedFailEnterEvent(@NotNull Player player,  @NotNull FailReason failReason, @NotNull Block bed, boolean willExplode, @Nullable Component message) {
        super(player);
        this.failReason = failReason;
        this.bed = bed;
        this.willExplode = willExplode;
        this.message = message;
    }

    public @NotNull FailReason getFailReason() {
        return this.failReason;
    }

    public @NotNull Block getBed() {
        return this.bed;
    }

    public boolean getWillExplode() {
        return this.willExplode;
    }

    public void setWillExplode(boolean willExplode) {
        this.willExplode = willExplode;
    }

    public @Nullable Component getMessage() {
        return this.message;
    }

    public void setMessage(@Nullable Component message) {
        this.message = message;
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

    public static enum FailReason {
        NOT_POSSIBLE_HERE,
        NOT_POSSIBLE_NOW,
        TOO_FAR_AWAY,
        OBSTRUCTED,
        OTHER_PROBLEM,
        NOT_SAFE;

        private FailReason() {
        }
    }
}

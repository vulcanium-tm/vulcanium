package dev.vulcanium.event.player;

import com.google.common.base.Preconditions;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerPickItemEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private int targetSlot;
    private int sourceSlot;
    private boolean cancelled;

    @Internal
    public PlayerPickItemEvent(@NotNull Player player, int targetSlot, int sourceSlot) {
        super(player);
        this.targetSlot = targetSlot;
        this.sourceSlot = sourceSlot;
    }

    public @Range(
            from = 0L,
            to = 8L
    ) int getTargetSlot() {
        return this.targetSlot;
    }

    public void setTargetSlot(@Range(
            from = 0L,
            to = 8L
    ) int targetSlot) {
        Preconditions.checkArgument(targetSlot >= 0 && targetSlot <= 8, "Target slot must be in range 0 - 8 (inclusive)");
        this.targetSlot = targetSlot;
    }

    public @Range(
            from = 0L,
            to = 35L
    ) int getSourceSlot() {
        return this.sourceSlot;
    }

    public void setSourceSlot(@Range(
            from = 0L,
            to = 35L
    ) int sourceSlot) {
        Preconditions.checkArgument(sourceSlot >= 0 && sourceSlot <= 35, "Source slot must be in range of the player's inventory slot");
        this.sourceSlot = sourceSlot;
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

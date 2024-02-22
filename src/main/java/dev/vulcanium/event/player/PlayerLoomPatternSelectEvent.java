package dev.vulcanium.event.player;

import dev.vulcanium.block.banner.PatternType;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.LoomInventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerLoomPatternSelectEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final LoomInventory loomInventory;
    private PatternType patternType;
    private boolean cancelled;

    @Internal
    public PlayerLoomPatternSelectEvent(@NotNull Player player, @NotNull LoomInventory loomInventory, @NotNull PatternType patternType) {
        super(player);
        this.loomInventory = loomInventory;
        this.patternType = patternType;
    }

    public @NotNull LoomInventory getLoomInventory() {
        return this.loomInventory;
    }

    public @NotNull PatternType getPatternType() {
        return this.patternType;
    }

    public void setPatternType(@NotNull PatternType patternType) {
        this.patternType = patternType;
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

package dev.vulcanium.event.player;

import dev.vulcanium.advancement.Advancement;
import dev.vulcanium.advancement.AdvancementProgress;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerAdvancementCriterionGrantEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull Advancement advancement;
    private final @NotNull String criterion;
    private final @NotNull AdvancementProgress advancementProgress;
    private boolean cancelled;

    @Internal
    public PlayerAdvancementCriterionGrantEvent(@NotNull Player player, @NotNull Advancement advancement, @NotNull String criterion) {
        super(player);
        this.advancement = advancement;
        this.criterion = criterion;
        this.advancementProgress = player.getAdvancementProgress(advancement);
    }

    public @NotNull Advancement getAdvancement() {
        return this.advancement;
    }

    public @NotNull String getCriterion() {
        return this.criterion;
    }

    public @NotNull AdvancementProgress getAdvancementProgress() {
        return this.advancementProgress;
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

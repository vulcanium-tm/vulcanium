package dev.vulcanium.event.entity;

import dev.vulcanium.entity.ExperienceOrb;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class ExperienceOrbMergeEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull ExperienceOrb mergeTarget;
    private final @NotNull ExperienceOrb mergeSource;
    private boolean cancelled;

    @Internal
    public ExperienceOrbMergeEvent(@NotNull ExperienceOrb mergeTarget, @NotNull ExperienceOrb mergeSource) {
        super(mergeTarget);
        this.mergeTarget = mergeTarget;
        this.mergeSource = mergeSource;
    }

    public @NotNull ExperienceOrb getMergeTarget() {
        return this.mergeTarget;
    }

    public @NotNull ExperienceOrb getMergeSource() {
        return this.mergeSource;
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

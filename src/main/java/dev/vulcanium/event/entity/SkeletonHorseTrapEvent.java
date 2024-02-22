package dev.vulcanium.event.entity;

import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.entity.HumanEntity;
import dev.vulcanium.entity.SkeletonHorse;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;

import java.util.List;

public class SkeletonHorseTrapEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final List<HumanEntity> eligibleHumans;
    private boolean cancelled;

    /** @deprecated */
    @Deprecated
    @Internal
    public SkeletonHorseTrapEvent(@NotNull SkeletonHorse horse) {
        this(horse, ImmutableList.of());
    }

    @Internal
    public SkeletonHorseTrapEvent(@NotNull SkeletonHorse horse, @NotNull List<HumanEntity> eligibleHumans) {
        super(horse);
        this.eligibleHumans = eligibleHumans;
    }

    public @NotNull SkeletonHorse getEntity() {
        return (SkeletonHorse)super.getEntity();
    }

    public @NotNull List<HumanEntity> getEligibleHumans() {
        return this.eligibleHumans;
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

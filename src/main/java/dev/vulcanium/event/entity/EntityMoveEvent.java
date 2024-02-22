package dev.vulcanium.event.entity;

import com.google.common.base.Preconditions;
import dev.vulcanium.Location;
import dev.vulcanium.entity.LivingEntity;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EntityMoveEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private Location from;
    private Location to;
    private boolean cancelled;

    @Internal
    public EntityMoveEvent(@NotNull LivingEntity entity, @NotNull Location from, @NotNull Location to) {
        super(entity);
        this.from = from;
        this.to = to;
    }

    public @NotNull LivingEntity getEntity() {
        return (LivingEntity)super.getEntity();
    }

    public @NotNull Location getFrom() {
        return this.from;
    }

    public void setFrom(@NotNull Location from) {
        this.validateLocation(from);
        this.from = from;
    }

    public @NotNull Location getTo() {
        return this.to;
    }

    public void setTo(@NotNull Location to) {
        this.validateLocation(to);
        this.to = to;
    }

    public boolean hasChangedPosition() {
        return this.hasExplicitlyChangedPosition() || !this.from.getWorld().equals(this.to.getWorld());
    }

    public boolean hasExplicitlyChangedPosition() {
        return this.from.getX() != this.to.getX() || this.from.getY() != this.to.getY() || this.from.getZ() != this.to.getZ();
    }

    public boolean hasChangedBlock() {
        return this.hasExplicitlyChangedBlock() || !this.from.getWorld().equals(this.to.getWorld());
    }

    public boolean hasExplicitlyChangedBlock() {
        return this.from.getBlockX() != this.to.getBlockX() || this.from.getBlockY() != this.to.getBlockY() || this.from.getBlockZ() != this.to.getBlockZ();
    }

    public boolean hasChangedOrientation() {
        return this.from.getPitch() != this.to.getPitch() || this.from.getYaw() != this.to.getYaw();
    }

    private void validateLocation(@NotNull Location loc) {
        Preconditions.checkArgument(loc != null, "Cannot use null location!");
        Preconditions.checkArgument(loc.getWorld() != null, "Cannot use null location with null world!");
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

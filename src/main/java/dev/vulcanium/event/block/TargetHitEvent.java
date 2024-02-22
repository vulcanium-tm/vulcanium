package dev.vulcanium.event.block;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.annotation.Range;
import dev.vulcanium.block.Block;
import dev.vulcanium.block.BlockFace;
import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.Projectile;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.event.entity.ProjectileHitEvent;

public class TargetHitEvent extends ProjectileHitEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private int signalStrength;

    @Internal
    public TargetHitEvent(@NotNull Projectile projectile, @NotNull Block block, @NotNull BlockFace blockFace, int signalStrength) {
        super(projectile, (Entity)null, block, blockFace);
        this.signalStrength = signalStrength;
    }

    public @Range(
            from = 0L,
            to = 15L
    ) int getSignalStrength() {
        return this.signalStrength;
    }

    public void setSignalStrength(@Range(
            from = 0L,
            to = 15L
    ) int signalStrength) {
        Preconditions.checkArgument(signalStrength >= 0 && signalStrength <= 15, "Signal strength out of range (%s), must be in range [0,15]", signalStrength);
        this.signalStrength = signalStrength;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

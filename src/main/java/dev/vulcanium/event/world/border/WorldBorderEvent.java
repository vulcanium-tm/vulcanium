package dev.vulcanium.event.world.border;

import dev.vulcanium.world.*;
import dev.vulcanium.event.world.WorldEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public abstract class WorldBorderEvent extends WorldEvent {
    protected final WorldBorder worldBorder;

    @Internal
    protected WorldBorderEvent(@NotNull World world, @NotNull WorldBorder worldBorder) {
        super(world);
        this.worldBorder = worldBorder;
    }

    public @NotNull WorldBorder getWorldBorder() {
        return this.worldBorder;
    }
}

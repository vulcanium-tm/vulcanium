package dev.vulcanium.event.entity;

import dev.vulcanium.Location;
import dev.vulcanium.block.EndGateway;
import dev.vulcanium.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EntityTeleportEndGatewayEvent extends EntityTeleportEvent {
    private final @NotNull EndGateway gateway;

    @Internal
    public EntityTeleportEndGatewayEvent(@NotNull Entity entity, @NotNull Location from, @NotNull Location to, @NotNull EndGateway gateway) {
        super(entity, from, to);
        this.gateway = gateway;
    }

    public @NotNull EndGateway getGateway() {
        return this.gateway;
    }
}

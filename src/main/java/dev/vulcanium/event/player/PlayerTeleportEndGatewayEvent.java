package dev.vulcanium.event.player;

import dev.vulcanium.Location;
import dev.vulcanium.block.EndGateway;
import dev.vulcanium.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerTeleportEndGatewayEvent extends PlayerTeleportEvent {
    private final @NotNull EndGateway gateway;

    @Internal
    public PlayerTeleportEndGatewayEvent(@NotNull Player player, @NotNull Location from, @NotNull Location to, @NotNull EndGateway gateway) {
        super(player, from, to, TeleportCause.END_GATEWAY);
        this.gateway = gateway;
    }

    public @NotNull EndGateway getGateway() {
        return this.gateway;
    }
}

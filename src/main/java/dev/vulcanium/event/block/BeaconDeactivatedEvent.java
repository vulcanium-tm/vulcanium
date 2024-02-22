package dev.vulcanium.event.block;

import dev.vulcanium.Material;
import dev.vulcanium.block.Beacon;
import dev.vulcanium.block.Block;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

public class BeaconDeactivatedEvent extends BlockEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    @Internal
    public BeaconDeactivatedEvent(@NotNull Block block) {
        super(block);
    }

    public @Nullable Beacon getBeacon() {
        return this.block.getType() == Material.BEACON ? (Beacon)this.block.getState() : null;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

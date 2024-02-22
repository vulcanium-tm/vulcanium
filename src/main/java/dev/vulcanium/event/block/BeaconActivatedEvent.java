package dev.vulcanium.event.block;

import dev.vulcanium.block.Beacon;
import dev.vulcanium.block.Block;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;

public class BeaconActivatedEvent extends BlockEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    @Internal
    public BeaconActivatedEvent(@NotNull Block block) {
        super(block);
    }

    public @NotNull Beacon getBeacon() {
        return (Beacon)this.block.getState();
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

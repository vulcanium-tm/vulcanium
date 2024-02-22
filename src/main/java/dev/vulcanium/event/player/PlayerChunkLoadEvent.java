package dev.vulcanium.event.player;

import dev.vulcanium.world.chunks.Chunk;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.event.world.ChunkEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerChunkLoadEvent extends ChunkEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Player player;

    @Internal
    public PlayerChunkLoadEvent(@NotNull Chunk chunk, @NotNull Player player) {
        super(chunk);
        this.player = player;
    }

    public @NotNull Player getPlayer() {
        return this.player;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

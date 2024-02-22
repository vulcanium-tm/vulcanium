package dev.vulcanium.event.world;

import dev.vulcanium.world.chunks.Chunk;
import dev.vulcanium.generator.BlockPopulator;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.HandlerList;

/**
 * Thrown when a newly generated chunk has finished being populated.
 * <p>
 * <b>Note:</b> Do not use this to generated blocks in a newly generated chunk.
 * Use a {@link BlockPopulator} instead.
 */
public class ChunkPopulateEvent extends ChunkEvent {
    private static final HandlerList handlers = new HandlerList();

    public ChunkPopulateEvent(@NotNull final Chunk chunk) {
        super(chunk);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}

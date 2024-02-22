package dev.vulcanium.event.world;

import lombok.Getter;
import dev.vulcanium.world.World;
import dev.vulcanium.generator.structure.Structure;
import dev.vulcanium.util.BoundingBox;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;

/**
 * Called when a {@link Structure} is naturally generated in the world.
 */
public class AsyncStructureSpawnEvent extends WorldEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled = false;

    private final Structure structure;
    private final BoundingBox boundingBox;

    /**
     * -- GETTER --
     *  Get the x coordinate of the origin chunk of the structure.
     *  <b>Note, it is not safe to attempt to retrieve or interact with this
     *  chunk. This event is informative only!</b>
     *
     * @return the chunk x coordinate
     */
    @Getter
    private final int chunkX, /**
     * -- GETTER --
     *  Get the z coordinate of the origin chunk of the structure.
     *  <b>Note, it is not safe to attempt to retrieve or interact with this
     *  chunk. This event is informative only!</b>
     *
     * @return the chunk z coordinate
     */
            chunkZ;

    public AsyncStructureSpawnEvent(@NotNull World world, @NotNull Structure structure, @NotNull BoundingBox boundingBox, int chunkX, int chunkZ) {
        super(world, true);
        this.structure = structure;
        this.boundingBox = boundingBox;
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
    }

    /**
     * Get the structure reference that is generated.
     *
     * @return the structure
     */
    @NotNull
    public Structure getStructure() {
        return structure;
    }

    /**
     * Get the bounding box of the structure.
     *
     * @return the bounding box
     */
    @NotNull
    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
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

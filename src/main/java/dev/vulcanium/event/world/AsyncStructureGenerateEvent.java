package dev.vulcanium.event.world;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Getter;
import dev.vulcanium.namespaced.NamespacedKey;
import dev.vulcanium.world.World;
import dev.vulcanium.generator.structure.Structure;
import dev.vulcanium.util.BlockTransformer;
import dev.vulcanium.util.BoundingBox;
import dev.vulcanium.util.EntityTransformer;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import dev.vulcanium.event.HandlerList;

/**
 * This event will sometimes fire synchronously, depending on how it was
 * triggered.
 * <p>
 * The constructor provides a boolean to indicate if the event was fired
 * synchronously or asynchronously. When asynchronous, this event can be called
 * from any thread, sans the main thread, and has limited access to the API.
 * <p>
 * If a {@link Structure} is naturally placed in a chunk of the world, this
 * event will be asynchronous. If a player executes the '/place structure'
 * command, this event will be synchronous.
 *
 * Allows to register transformers that can modify the blocks placed and
 * entities spawned by the structure.
 * <p>
 * Care should be taken to check {@link #isAsynchronous()} and treat the event
 * appropriately.
 * <p>
 */
@ApiStatus.Experimental
public class AsyncStructureGenerateEvent extends WorldEvent {

    public static enum Cause {
        COMMAND,
        WORLD_GENERATION,
        CUSTOM;
    }

    private static final HandlerList handlers = new HandlerList();

    private final Cause cause;

    private final Structure structure;
    private final BoundingBox boundingBox;

    /**
     * -- GETTER --
     *  Get the x coordinate of the origin chunk of the structure.
     *
     * @return the chunk x coordinate
     */
    @Getter
    private final int chunkX, /**
     * -- GETTER --
     *  Get the z coordinate of the origin chunk of the structure.
     *
     * @return the chunk z coordinate
     */
            chunkZ;

    private final Map<NamespacedKey, BlockTransformer> blockTransformers = new LinkedHashMap<>();
    private final Map<NamespacedKey, EntityTransformer> entityTransformers = new LinkedHashMap<>();

    public AsyncStructureGenerateEvent(@NotNull World world, boolean async, @NotNull Cause cause, @NotNull Structure structure, @NotNull BoundingBox boundingBox, int chunkX, int chunkZ) {
        super(world, async);
        this.structure = structure;
        this.boundingBox = boundingBox;
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
        this.cause = cause;
    }

    /**
     * Gets the event cause.
     *
     * @return the event cause
     */
    @NotNull
    public Cause getCause() {
        return cause;
    }

    /**
     * Gets a block transformer by key.
     *
     * @param key the key of the block transformer
     *
     * @return the block transformer or null
     */
    @Nullable
    public BlockTransformer getBlockTransformer(@NotNull NamespacedKey key) {
        Preconditions.checkNotNull(key, "NamespacedKey cannot be null");
        return blockTransformers.get(key);
    }

    /**
     * Sets a block transformer to a key.
     *
     * @param key the key
     * @param transformer the block transformer
     */
    public void setBlockTransformer(@NotNull NamespacedKey key, @NotNull BlockTransformer transformer) {
        Preconditions.checkNotNull(key, "NamespacedKey cannot be null");
        Preconditions.checkNotNull(transformer, "BlockTransformer cannot be null");
        blockTransformers.put(key, transformer);
    }

    /**
     * Removes a block transformer.
     *
     * @param key the key of the block transformer
     */
    public void removeBlockTransformer(@NotNull NamespacedKey key) {
        Preconditions.checkNotNull(key, "NamespacedKey cannot be null");
        blockTransformers.remove(key);
    }

    /**
     * Removes all block transformers.
     */
    public void clearBlockTransformers() {
        blockTransformers.clear();
    }

    /**
     * Gets all block transformers in a unmodifiable map.
     *
     * @return the block transformers in a map
     */
    @NotNull
    public Map<NamespacedKey, BlockTransformer> getBlockTransformers() {
        return Collections.unmodifiableMap(blockTransformers);
    }

    /**
     * Gets a entity transformer by key.
     *
     * @param key the key of the entity transformer
     *
     * @return the entity transformer or null
     */
    @Nullable
    public EntityTransformer getEntityTransformer(@NotNull NamespacedKey key) {
        Preconditions.checkNotNull(key, "NamespacedKey cannot be null");
        return entityTransformers.get(key);
    }

    /**
     * Sets a entity transformer to a key.
     *
     * @param key the key
     * @param transformer the entity transformer
     */
    public void setEntityTransformer(@NotNull NamespacedKey key, @NotNull EntityTransformer transformer) {
        Preconditions.checkNotNull(key, "NamespacedKey cannot be null");
        Preconditions.checkNotNull(transformer, "EntityTransformer cannot be null");
        entityTransformers.put(key, transformer);
    }

    /**
     * Removes a entity transformer.
     *
     * @param key the key of the entity transformer
     */
    public void removeEntityTransformer(@NotNull NamespacedKey key) {
        Preconditions.checkNotNull(key, "NamespacedKey cannot be null");
        entityTransformers.remove(key);
    }

    /**
     * Removes all entity transformers.
     */
    public void clearEntityTransformers() {
        entityTransformers.clear();
    }

    /**
     * Gets all entity transformers in a unmodifiable map.
     *
     * @return the entity transformers in a map
     */
    @NotNull
    public Map<NamespacedKey, EntityTransformer> getEntityTransformers() {
        return Collections.unmodifiableMap(entityTransformers);
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
        return boundingBox.clone();
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

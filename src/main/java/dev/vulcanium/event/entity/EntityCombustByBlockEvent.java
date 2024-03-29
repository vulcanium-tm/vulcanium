package dev.vulcanium.event.entity;

import dev.vulcanium.block.Block;
import dev.vulcanium.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called when a block causes an entity to combust.
 */
public class EntityCombustByBlockEvent extends EntityCombustEvent {
    private final Block combuster;

    public EntityCombustByBlockEvent(@Nullable final Block combuster, @NotNull final Entity combustee, final int duration) {
        super(combustee, duration);
        this.combuster = combuster;
    }

    /**
     * The combuster can be lava or a block that is on fire.
     * <p>
     * WARNING: block may be null.
     *
     * @return the Block that set the combustee alight.
     */
    @Nullable
    public Block getCombuster() {
        return combuster;
    }
}

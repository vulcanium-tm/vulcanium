package dev.vulcanium.event.entity;

import dev.vulcanium.Material;
import dev.vulcanium.block.Block;
import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

/**
 * Called when an {@link Entity} breaks a door
 * <p>
 * Cancelling the event will cause the event to be delayed
 */
public class EntityBreakDoorEvent extends EntityChangeBlockEvent {
    public EntityBreakDoorEvent(@NotNull final LivingEntity entity, @NotNull final Block targetBlock) {
        super(entity, targetBlock, Material.AIR.createBlockData());
    }

    @NotNull
    @Override
    public LivingEntity getEntity() {
        return (LivingEntity) entity;
    }
}

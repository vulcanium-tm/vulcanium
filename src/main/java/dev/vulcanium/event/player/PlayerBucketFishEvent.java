package dev.vulcanium.event.player;

import dev.vulcanium.Material;
import dev.vulcanium.annotation.Warning;
import dev.vulcanium.entity.Fish;
import dev.vulcanium.entity.Player;
import dev.vulcanium.inventory.EquipmentSlot;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * This event is called whenever a player attempts to put a fish in a bucket.
 *
 * @deprecated Use the more generic {@link PlayerBucketEntityEvent}
 */
@Deprecated
@Warning(false)
public class PlayerBucketFishEvent extends PlayerBucketEntityEvent {

    public PlayerBucketFishEvent(@NotNull Player player, @NotNull Fish fish, @NotNull ItemStack waterBucket, @NotNull ItemStack fishBucket, @NotNull EquipmentSlot hand) {
        super(player, fish, waterBucket, fishBucket, hand);
    }

    /**
     * Gets the fish involved with this event.
     *
     * @return The fish involved with this event
     */
    @NotNull
    @Override
    public Fish getEntity() {
        return (Fish) super.getEntity();
    }

    /**
     * Gets the bucket used.
     *
     * This refers to the bucket clicked with, ie {@link Material#WATER_BUCKET}.
     *
     * @return The used bucket
     * @deprecated Use {@link #getOriginalBucket()}
     */
    @NotNull
    @Deprecated
    public ItemStack getWaterBucket() {
        return getOriginalBucket();
    }

    /**
     * Gets the bucket that the fish will be put into.
     *
     * This refers to the bucket with the fish, ie
     * {@link Material#PUFFERFISH_BUCKET}.
     *
     * @return The bucket that the fish will be put into
     * @deprecated Use {@link #getEntityBucket()}
     */
    @NotNull
    @Deprecated
    public ItemStack getFishBucket() {
        return getEntityBucket();
    }
}

package dev.vulcanium.entity;

import dev.vulcanium.Sound;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface Bucketable extends Entity {
    boolean isFromBucket();

    void setFromBucket(boolean var1);

    @NotNull ItemStack getBaseBucketItem();

    @NotNull Sound getPickupSound();
}

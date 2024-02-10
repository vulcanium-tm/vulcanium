package org.vulcanium.entity;

import org.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface ThrowableProjectile extends Projectile {

    /**
     * Gets the ItemStack the thrown projectile will display.
     *
     * @return The thrown item display ItemStack
     */
    @NotNull
    ItemStack getItem();

    /**
     * Sets the display ItemStack for the thrown projectile.
     *
     * @param item ItemStack set to be displayed
     */
    void setItem(@NotNull ItemStack item);
}
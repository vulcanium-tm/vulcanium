package dev.vulcanium.entity;

import dev.vulcanium.DyeColor;
import org.jetbrains.annotations.NotNull;

public interface CollarColorable extends LivingEntity {
    @NotNull DyeColor getCollarColor();

    void setCollarColor(@NotNull DyeColor var1);
}

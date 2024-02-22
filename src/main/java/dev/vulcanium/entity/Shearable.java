package dev.vulcanium.entity;

import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.sound.Sound.Source;
import org.jetbrains.annotations.NotNull;

public interface Shearable extends Entity {
    default void shear() {
        this.shear(Source.PLAYER);
    }

    void shear(@NotNull Sound.Source var1);

    boolean readyToBeSheared();
}
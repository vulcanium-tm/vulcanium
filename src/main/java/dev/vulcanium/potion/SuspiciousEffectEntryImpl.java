package dev.vulcanium.potion;

import dev.vulcanium.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

record SuspiciousEffectEntryImpl(@NotNull PotionEffectType effect, int duration) implements SuspiciousEffectEntry {
    SuspiciousEffectEntryImpl(@NotNull PotionEffectType effect, int duration) {
        this.effect = effect;
        this.duration = duration;
    }

    public @NotNull PotionEffectType effect() {
        return this.effect;
    }

    public int duration() {
        return this.duration;
    }
}

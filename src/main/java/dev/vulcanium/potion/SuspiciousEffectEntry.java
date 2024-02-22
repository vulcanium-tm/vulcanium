package dev.vulcanium.potion;


import dev.vulcanium.potion.PotionEffectType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public sealed interface SuspiciousEffectEntry permits SuspiciousEffectEntryImpl {
    @NotNull PotionEffectType effect();

    int duration();

    @Contract(
            value = "_, _ -> new",
            pure = true
    )
    static @NotNull SuspiciousEffectEntry create(@NotNull PotionEffectType effectType, int duration) {
        return new SuspiciousEffectEntryImpl(effectType, duration);
    }
}

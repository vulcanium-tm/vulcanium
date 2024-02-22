package dev.vulcanium.damage;

import com.google.common.base.Preconditions;
import dev.vulcanium.Vulcanium;
import dev.vulcanium.Sound;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;

@Experimental
public interface DamageEffect {
    DamageEffect HURT = getDamageEffect("hurt");
    DamageEffect THORNS = getDamageEffect("thorns");
    DamageEffect DROWNING = getDamageEffect("drowning");
    DamageEffect BURNING = getDamageEffect("burning");
    DamageEffect POKING = getDamageEffect("poking");
    DamageEffect FREEZING = getDamageEffect("freezing");

    private static @NotNull DamageEffect getDamageEffect(@NotNull String key) {
        return (DamageEffect)Preconditions.checkNotNull(Vulcanium.getUnsafe().getDamageEffect(key), "No DamageEffect found for %s. This is a bug.", key);
    }

    @NotNull Sound getSound();
}

package dev.vulcanium.damage;

import dev.vulcanium.Vulcanium;
import dev.vulcanium.Location;
import dev.vulcanium.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Experimental;

@Experimental
public interface DamageSource {
    @NotNull DamageType getDamageType();

    @Nullable Entity getCausingEntity();

    @Nullable Entity getDirectEntity();

    @Nullable Location getDamageLocation();

    @Nullable Location getSourceLocation();

    boolean isIndirect();

    float getFoodExhaustion();

    boolean scalesWithDifficulty();

    static @NotNull Builder builder(@NotNull DamageType damageType) {
        return Vulcanium.getUnsafe().createDamageSourceBuilder(damageType);
    }

    public interface Builder {
        @NotNull Builder withCausingEntity(@NotNull Entity var1);
        @NotNull Builder withDirectEntity(@NotNull Entity var1);
        @NotNull Builder withDamageLocation(@NotNull Location var1);

        @NotNull DamageSource build();
    }
}

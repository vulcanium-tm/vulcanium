package dev.vulcanium;

import dev.vulcanium.namespaced.Keyed;
import dev.vulcanium.namespaced.NamespacedKey;
import org.jetbrains.annotations.ApiStatus;
import dev.vulcanium.annotation.MinecraftExperimental;

/**
 * This represents a Feature Flag for a World.
 * <br>
 * Flags which are unavailable in the current version will be null and/or
 * removed.
 */
@ApiStatus.Experimental
public interface FeatureFlag extends Keyed {

    public static final FeatureFlag VANILLA = Vulcanium.getUnsafe().getFeatureFlag(NamespacedKey.minecraft("vanilla"));

    @MinecraftExperimental
    public static final FeatureFlag BUNDLE = Vulcanium.getUnsafe().getFeatureFlag(NamespacedKey.minecraft("bundle"));

    /**
     * <strong>AVAILABLE BETWEEN VERSIONS:</strong> 1.19 - 1.19.4
     *
     * @deprecated not available since 1.20
     */
    @Deprecated
    @MinecraftExperimental
    public static final FeatureFlag UPDATE_1_20 = Vulcanium.getUnsafe().getFeatureFlag(NamespacedKey.minecraft("update_1_20"));

    @MinecraftExperimental
    public static final FeatureFlag TRADE_REBALANCE = Vulcanium.getUnsafe().getFeatureFlag(NamespacedKey.minecraft("trade_rebalance"));

    @MinecraftExperimental
    public static final FeatureFlag UPDATE_121 = Vulcanium.getUnsafe().getFeatureFlag(NamespacedKey.minecraft("update_1_21"));
}

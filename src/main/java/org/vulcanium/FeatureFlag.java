package org.vulcanium;

import org.jetbrains.annotations.ApiStatus;

/**
 * This represents a Feature Flag for a World.
 * <br>
 * Flags which are unavailable in the current version will be null and/or
 * removed.
 */
@ApiStatus.Experimental
public interface FeatureFlag extends Keyed {

    public static final org.bukkit.FeatureFlag VANILLA = Bukkit.getUnsafe().getFeatureFlag(org.bukkit.NamespacedKey.minecraft("vanilla"));

    @org.bukkit.MinecraftExperimental
    public static final org.bukkit.FeatureFlag BUNDLE = Bukkit.getUnsafe().getFeatureFlag(org.bukkit.NamespacedKey.minecraft("bundle"));

    /**
     * <strong>AVAILABLE BETWEEN VERSIONS:</strong> 1.19 - 1.19.4
     *
     * @deprecated not available since 1.20
     */
    @Deprecated
    @org.bukkit.MinecraftExperimental
    public static final org.bukkit.FeatureFlag UPDATE_1_20 = Bukkit.getUnsafe().getFeatureFlag(org.bukkit.NamespacedKey.minecraft("update_1_20"));

    @org.bukkit.MinecraftExperimental
    public static final org.bukkit.FeatureFlag TRADE_REBALANCE = Bukkit.getUnsafe().getFeatureFlag(org.bukkit.NamespacedKey.minecraft("trade_rebalance"));

    @MinecraftExperimental
    public static final org.bukkit.FeatureFlag UPDATE_121 = Bukkit.getUnsafe().getFeatureFlag(NamespacedKey.minecraft("update_1_21"));
}

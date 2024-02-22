package dev.vulcanium.potion;

import com.google.common.base.Suppliers;
import dev.vulcanium.Vulcanium;
import dev.vulcanium.namespaced.*;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * This enum reflects and matches each potion state that can be obtained from
 * the Creative mode inventory
 */
public enum PotionType implements Keyed {
    UNCRAFTABLE("empty"),
    WATER("water"),
    MUNDANE("mundane"),
    THICK("thick"),
    AWKWARD("awkward"),
    NIGHT_VISION("night_vision"),
    LONG_NIGHT_VISION("long_night_vision"),
    INVISIBILITY("invisibility"),
    LONG_INVISIBILITY("long_invisibility"),
    JUMP("leaping"),
    LONG_LEAPING("long_leaping"),
    STRONG_LEAPING("strong_leaping"),
    FIRE_RESISTANCE("fire_resistance"),
    LONG_FIRE_RESISTANCE("long_fire_resistance"),
    SPEED("swiftness"),
    LONG_SWIFTNESS("long_swiftness"),
    STRONG_SWIFTNESS("strong_swiftness"),
    SLOWNESS("slowness"),
    LONG_SLOWNESS("long_slowness"),
    STRONG_SLOWNESS("strong_slowness"),
    WATER_BREATHING("water_breathing"),
    LONG_WATER_BREATHING("long_water_breathing"),
    INSTANT_HEAL("healing"),
    STRONG_HEALING("strong_healing"),
    INSTANT_DAMAGE("harming"),
    STRONG_HARMING("strong_harming"),
    POISON("poison"),
    LONG_POISON("long_poison"),
    STRONG_POISON("strong_poison"),
    REGEN("regeneration"),
    LONG_REGENERATION("long_regeneration"),
    STRONG_REGENERATION("strong_regeneration"),
    STRENGTH("strength"),
    LONG_STRENGTH("long_strength"),
    STRONG_STRENGTH("strong_strength"),
    WEAKNESS("weakness"),
    LONG_WEAKNESS("long_weakness"),
    LUCK("luck"),
    TURTLE_MASTER("turtle_master"),
    LONG_TURTLE_MASTER("long_turtle_master"),
    STRONG_TURTLE_MASTER("strong_turtle_master"),
    SLOW_FALLING("slow_falling"),
    LONG_SLOW_FALLING("long_slow_falling"),
    ;
    public static PotionBrewer brewer;

    public static final int EXTENDED_BIT = 0x40;
    public static final int POTION_BIT = 0xF;
    public static final int SPLASH_BIT = 0x4000;
    public static final int TIER_BIT = 0x20;
    public static final int TIER_SHIFT = 5;
    private final NamespacedKey key;
    private Supplier<InternalPotionData> internalPotionDataSupplier;

    PotionType(String key) {
        this.key = NamespacedKey.minecraft(key);
    }

    private InternalPotionData getInternalPotionData() {
        if (internalPotionDataSupplier == null) {
            internalPotionDataSupplier = Suppliers.memoize(() -> Vulcanium.getUnsafe().getInternalPotionData(this.key));
        }
        return internalPotionDataSupplier.get();
    }

    @Nullable
    @Deprecated
    public PotionEffectType getEffectType() {
        return getInternalPotionData().getEffectType();
    }

    @NotNull
    public List<PotionEffect> getPotionEffects() {
        return getInternalPotionData().getPotionEffects();
    }

    @Deprecated
    public boolean isInstant() {
        return getInternalPotionData().isInstant();
    }

    public boolean isUpgradeable() {
        return getInternalPotionData().isUpgradeable();
    }

    public boolean isExtendable() {
        return getInternalPotionData().isExtendable();
    }

    public int getMaxLevel() {
        return getInternalPotionData().getMaxLevel();
    }

    @Deprecated
    @Nullable
    public static PotionType getByEffect(@Nullable PotionEffectType effectType) {
        return Stream.of(values())
                .filter(type -> effectType != null && effectType.equals(type.getEffectType()))
                .findFirst()
                .orElse(WATER);
    }

    @NotNull
    @Override
    public NamespacedKey getKey() {
        return key;
    }

    @Deprecated
    @ApiStatus.Internal
    public interface InternalPotionData {
        PotionEffectType getEffectType();
        List<PotionEffect> getPotionEffects();
        boolean isInstant();
        boolean isUpgradeable();
        boolean isExtendable();
        int getMaxLevel();
    }
}

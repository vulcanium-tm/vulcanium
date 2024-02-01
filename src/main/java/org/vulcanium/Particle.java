package org.vulcanium;

import com.google.common.base.Preconditions;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.jetbrains.annotations.NotNull;

public class Particle {
    EXPLOSION_NORMAL("poof"),
    EXPLOSION_LARGE("explosion"),
    EXPLOSION_HUGE("explosion_emitter"),
    FIREWORKS_SPARK("firework"),
    WATER_BUBBLE("bubble"),
    WATER_SPLASH("splash"),
    WATER_WAKE("fishing"),
    SUSPENDED("underwater"),
    SUSPENDED_DEPTH("underwater", false),
    CRIT("crit"),
    CRIT_MAGIC("enchanted_hit"),
    SMOKE_NORMAL("smoke"),
    SMOKE_LARGE("large_smoke"),
    SPELL("effect"),
    SPELL_INSTANT("instant_effect"),
    SPELL_MOB("entity_effect"),
    SPELL_MOB_AMBIENT("ambient_entity_effect"),
    SPELL_WITCH("witch"),
    DRIP_WATER("dripping_water"),
    DRIP_LAVA("dripping_lava"),
    VILLAGER_ANGRY("angry_villager"),
    VILLAGER_HAPPY("happy_villager"),
    TOWN_AURA("mycelium"),
    NOTE("note"),
    PORTAL("portal"),
    ENCHANTMENT_TABLE("enchant"),
    FLAME("flame"),
    LAVA("lava"),
    CLOUD("cloud"),
    /**
     * Uses {@link org.bukkit.Particle.DustOptions} as DataType
     */
    REDSTONE("dust",org.bukkit.Particle.DustOptions .class),
    SNOWBALL("item_snowball"),
    SNOW_SHOVEL("item_snowball", false),
    SLIME("item_slime"),
    HEART("heart"),
    /**
     * Uses {@link ItemStack} as DataType
     */
    ITEM_CRACK("item", ItemStack.class),
    /**
     * Uses {@link BlockData} as DataType
     */
    BLOCK_CRACK("block", BlockData.class),
    /**
     * Uses {@link BlockData} as DataType
     */
    BLOCK_DUST("block", BlockData.class, false),
    WATER_DROP("rain"),
    MOB_APPEARANCE("elder_guardian"),
    DRAGON_BREATH("dragon_breath"),
    END_ROD("end_rod"),
    DAMAGE_INDICATOR("damage_indicator"),
    SWEEP_ATTACK("sweep_attack"),
    /**
     * Uses {@link BlockData} as DataType
     */
    FALLING_DUST("falling_dust", BlockData.class),
    TOTEM("totem_of_undying"),
    SPIT("spit"),
    SQUID_INK("squid_ink"),
    BUBBLE_POP("bubble_pop"),
    CURRENT_DOWN("current_down"),
    BUBBLE_COLUMN_UP("bubble_column_up"),
    NAUTILUS("nautilus"),
    DOLPHIN("dolphin"),
    SNEEZE("sneeze"),
    CAMPFIRE_COSY_SMOKE("campfire_cosy_smoke"),
    CAMPFIRE_SIGNAL_SMOKE("campfire_signal_smoke"),
    COMPOSTER("composter"),
    FLASH("flash"),
    FALLING_LAVA("falling_lava"),
    LANDING_LAVA("landing_lava"),
    FALLING_WATER("falling_water"),
    DRIPPING_HONEY("dripping_honey"),
    FALLING_HONEY("falling_honey"),
    LANDING_HONEY("landing_honey"),
    FALLING_NECTAR("falling_nectar"),
    SOUL_FIRE_FLAME("soul_fire_flame"),
    ASH("ash"),
    CRIMSON_SPORE("crimson_spore"),
    WARPED_SPORE("warped_spore"),
    SOUL("soul"),
    DRIPPING_OBSIDIAN_TEAR("dripping_obsidian_tear"),
    FALLING_OBSIDIAN_TEAR("falling_obsidian_tear"),
    LANDING_OBSIDIAN_TEAR("landing_obsidian_tear"),
    REVERSE_PORTAL("reverse_portal"),
    WHITE_ASH("white_ash"),
    /**
     * Uses {@link org.bukkit.Particle.DustTransition} as DataType
     */
    DUST_COLOR_TRANSITION("dust_color_transition",org.bukkit.Particle.DustTransition .class),
    /**
     * Uses {@link org.bukkit.Vibration} as DataType
     */
    VIBRATION("vibration",Vibration .class),
    FALLING_SPORE_BLOSSOM("falling_spore_blossom"),
    SPORE_BLOSSOM_AIR("spore_blossom_air"),
    SMALL_FLAME("small_flame"),
    SNOWFLAKE("snowflake"),
    DRIPPING_DRIPSTONE_LAVA("dripping_dripstone_lava"),
    FALLING_DRIPSTONE_LAVA("falling_dripstone_lava"),
    DRIPPING_DRIPSTONE_WATER("dripping_dripstone_water"),
    FALLING_DRIPSTONE_WATER("falling_dripstone_water"),
    GLOW_SQUID_INK("glow_squid_ink"),
    GLOW("glow"),
    WAX_ON("wax_on"),
    WAX_OFF("wax_off"),
    ELECTRIC_SPARK("electric_spark"),
    SCRAPE("scrape"),
    SONIC_BOOM("sonic_boom"),
    SCULK_SOUL("sculk_soul"),
    /**
     * Use {@link Float} as DataType
     */
    SCULK_CHARGE("sculk_charge", Float.class),
    SCULK_CHARGE_POP("sculk_charge_pop"),
    /**
     * Use {@link Integer} as DataType
     */
    SHRIEK("shriek", Integer.class),
    CHERRY_LEAVES("cherry_leaves"),
    EGG_CRACK("egg_crack"),
    DUST_PLUME("dust_plume"),
    WHITE_SMOKE("white_smoke"),
    @MinecraftExperimental
    GUST("gust"),
    @MinecraftExperimental
    GUST_EMITTER("gust_emitter"),
    @MinecraftExperimental
    GUST_DUST("gust_dust"),
    @MinecraftExperimental
    TRIAL_SPAWNER_DETECTION("trial_spawner_detection"),
    /**
     * Uses {@link BlockData} as DataType
     */
    BLOCK_MARKER("block_marker", BlockData.class),
    // ----- Legacy Separator -----
    /**
     * Uses {@link MaterialData} as DataType
     */
    LEGACY_BLOCK_CRACK(null, MaterialData.class, false),
    /**
     * Uses {@link MaterialData} as DataType
     */
    LEGACY_BLOCK_DUST(null, MaterialData.class, false),
    /**
     * Uses {@link MaterialData} as DataType
     */
    LEGACY_FALLING_DUST(null, MaterialData.class, false);

    private final NamespacedKey key;
    private final Class<?> dataType;
    final boolean register;

    Particle(String key) {
        this(key, Void.class);
    }

    Particle(String key, boolean register) {
        this(key, Void.class, register);
    }

    Particle(String key, @NotNull Class<?> data) {
        this(key, data, true);
    }

    Particle(String key, @NotNull Class<?> data, boolean register) {
        this.key = (key != null) ? NamespacedKey.minecraft(key) : null;
        dataType = data;
        this.register = register;
    }

    @NotNull
    public Class<?> getDataType() {
        return dataType;
    }

    @NotNull
    @Override
    public NamespacedKey getKey() {
        if (key == null) {
            throw new UnsupportedOperationException("Cannot get key from legacy particle");
        }
        return key;
    }

    public static Particle createRedstoneParticle(Color color, float size) {
        return new Particle("dust", DustOptions.class, true);
    }

    public static Particle createBlockDustParticle(BlockData blockData) {
        return new Particle("block", BlockData.class, false);
    }

    // ... (other factory methods)

    public static class DustOptions {
        private final Color color;
        private final float size;

        public DustOptions(@NotNull Color color, float size) {
            Preconditions.checkArgument(color != null, "color");
            this.color = color;
            this.size = size;
        }

        @NotNull
        public Color getColor() {
            return color;
        }

        public float getSize() {
            return size;
        }
    }

    public static class DustTransition extends DustOptions {
        private final Color toColor;

        public DustTransition(@NotNull Color fromColor, @NotNull Color toColor, float size) {
            super(fromColor, size);
            Preconditions.checkArgument(toColor != null, "toColor");
            this.toColor = toColor;
        }

        @NotNull
        public Color getToColor() {
            return toColor;
        }
    }
}

package org.vulcanium;


import java.util.Set;

import org.jetbrains.annotations.NotNull;

/**
 * Represents a tag that may be defined by the server or a resource pack to
 * group like things together.
 *
 * Note that whilst all tags defined within this interface must be present in
 * implementations, their existence is not guaranteed across future versions.
 *
 * @param <T> the type of things grouped by this tag
 */
public interface Tag<T extends Keyed> extends Keyed {

    /**
     * Key for the built in block registry.
     */
    String REGISTRY_BLOCKS = "blocks";
    /**
     * Vanilla block tag representing all colors of wool.
     */
    org.bukkit.Tag<Material> WOOL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wool"), Material.class);
    /**
     * Vanilla block tag representing all plank variants.
     */
    org.bukkit.Tag<Material> PLANKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("planks"), Material.class);
    /**
     * Vanilla block tag representing all regular/mossy/cracked/chiseled stone
     * bricks.
     */
    org.bukkit.Tag<Material> STONE_BRICKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("stone_bricks"), Material.class);
    /**
     * Vanilla block tag representing all wooden buttons.
     */
    org.bukkit.Tag<Material> WOODEN_BUTTONS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_buttons"), Material.class);
    /**
     * Vanilla block tag representing all stone buttons.
     */
    org.bukkit.Tag<Material> STONE_BUTTONS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("stone_buttons"), Material.class);
    /**
     * Vanilla block tag representing all buttons (inherits from
     * {@link #WOODEN_BUTTONS}.
     */
    org.bukkit.Tag<Material> BUTTONS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("buttons"), Material.class);
    /**
     * Vanilla block tag representing all colors of carpet.
     */
    org.bukkit.Tag<Material> WOOL_CARPETS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wool_carpets"), Material.class);
    /**
     * @deprecated {@link #WOOL_CARPETS}.
     */
    @Deprecated
    org.bukkit.Tag<Material> CARPETS = WOOL_CARPETS;
    /**
     * Vanilla block tag representing all wooden doors.
     */
    org.bukkit.Tag<Material> WOODEN_DOORS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_doors"), Material.class);
    /**
     * Vanilla block tag representing all wooden stairs.
     */
    org.bukkit.Tag<Material> WOODEN_STAIRS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_stairs"), Material.class);
    /**
     * Vanilla block tag representing all wooden slabs.
     */
    org.bukkit.Tag<Material> WOODEN_SLABS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_slabs"), Material.class);
    /**
     * Vanilla block tag representing all wooden fences.
     */
    org.bukkit.Tag<Material> WOODEN_FENCES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_fences"), Material.class);
    /**
     * Vanilla block tag representing all pressure plates.
     */
    org.bukkit.Tag<Material> PRESSURE_PLATES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("pressure_plates"), Material.class);
    /**
     * Vanilla block tag representing all wooden pressure plates.
     */
    org.bukkit.Tag<Material> WOODEN_PRESSURE_PLATES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_pressure_plates"), Material.class);
    /**
     * Vanilla block tag representing all stone pressure plates.
     */
    org.bukkit.Tag<Material> STONE_PRESSURE_PLATES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("stone_pressure_plates"), Material.class);
    /**
     * Vanilla block tag representing all wooden trapdoors.
     */
    org.bukkit.Tag<Material> WOODEN_TRAPDOORS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_trapdoors"), Material.class);
    /**
     * Vanilla block tag representing all doors (inherits from
     * {@link #WOODEN_DOORS}.
     */
    org.bukkit.Tag<Material> DOORS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("doors"), Material.class);
    /**
     * Vanilla block tag representing all sapling variants.
     */
    org.bukkit.Tag<Material> SAPLINGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("saplings"), Material.class);
    /**
     * Vanilla block tag representing all log and bark variants that burn.
     */
    org.bukkit.Tag<Material> LOGS_THAT_BURN = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("logs_that_burn"), Material.class);
    /**
     * Vanilla block tag representing all log and bark variants.
     */
    org.bukkit.Tag<Material> LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("logs"), Material.class);
    /**
     * Vanilla block tag representing all dark oak log and bark variants.
     */
    org.bukkit.Tag<Material> DARK_OAK_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dark_oak_logs"), Material.class);
    /**
     * Vanilla block tag representing all oak log and bark variants.
     */
    org.bukkit.Tag<Material> OAK_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("oak_logs"), Material.class);
    /**
     * Vanilla block tag representing all birch log and bark variants.
     */
    org.bukkit.Tag<Material> BIRCH_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("birch_logs"), Material.class);
    /**
     * Vanilla block tag representing all acacia log and bark variants.
     */
    org.bukkit.Tag<Material> ACACIA_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("acacia_logs"), Material.class);
    /**
     * Vanilla block tag representing all cherry log and bark variants.
     */
    org.bukkit.Tag<Material> CHERRY_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("cherry_logs"), Material.class);
    /**
     * Vanilla block tag representing all jungle log and bark variants.
     */
    org.bukkit.Tag<Material> JUNGLE_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("jungle_logs"), Material.class);
    /**
     * Vanilla block tag representing all spruce log and bark variants.
     */
    org.bukkit.Tag<Material> SPRUCE_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("spruce_logs"), Material.class);
    /**
     * Vanilla block tag representing all mangrove log and bark variants.
     */
    org.bukkit.Tag<Material> MANGROVE_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mangrove_logs"), Material.class);
    /**
     * Vanilla block tag representing all crimson stems.
     */
    org.bukkit.Tag<Material> CRIMSON_STEMS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("crimson_stems"), Material.class);
    /**
     * Vanilla block tag representing all warped stems.
     */
    org.bukkit.Tag<Material> WARPED_STEMS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("warped_stems"), Material.class);
    /**
     * Vanilla block tag representing all bamboo blocks.
     */
    org.bukkit.Tag<Material> BAMBOO_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("bamboo_blocks"), Material.class);
    /**
     * Vanilla block tag representing all banner blocks.
     */
    org.bukkit.Tag<Material> BANNERS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("banners"), Material.class);
    /**
     * Vanilla block tag representing all sand blocks.
     */
    org.bukkit.Tag<Material> SAND = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sand"), Material.class);
    /**
     * Vanilla block tag representing all blocks which smelt to glass in a furnace.
     */
    org.bukkit.Tag<Material> SMELTS_TO_GLASS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("smelts_to_glass"), Material.class);
    /**
     * Vanilla block tag representing all stairs.
     */
    org.bukkit.Tag<Material> STAIRS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("stairs"), Material.class);
    /**
     * Vanilla block tag representing all slabs.
     */
    org.bukkit.Tag<Material> SLABS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("slabs"), Material.class);
    /**
     * Vanilla block tag representing all walls.
     */
    org.bukkit.Tag<Material> WALLS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("walls"), Material.class);
    /**
     * Vanilla block tag representing all damaged and undamaged anvils.
     */
    org.bukkit.Tag<Material> ANVIL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("anvil"), Material.class);
    /**
     * Vanilla block tag representing all Minecart rails.
     */
    org.bukkit.Tag<Material> RAILS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("rails"), Material.class);
    /**
     * Vanilla block tag representing all leaves fans.
     */
    org.bukkit.Tag<Material> LEAVES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("leaves"), Material.class);
    /**
     * Vanilla block tag representing all trapdoors (inherits from
     * {@link #WOODEN_TRAPDOORS}.
     */
    org.bukkit.Tag<Material> TRAPDOORS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("trapdoors"), Material.class);
    /**
     * Vanilla block tag representing all empty and filled flower pots.
     */
    org.bukkit.Tag<Material> FLOWER_POTS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("flower_pots"), Material.class);
    /**
     * Vanilla block tag representing all small flowers.
     */
    org.bukkit.Tag<Material> SMALL_FLOWERS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("small_flowers"), Material.class);
    /**
     * Vanilla block tag representing all beds.
     */
    org.bukkit.Tag<Material> BEDS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("beds"), Material.class);
    /**
     * Vanilla block tag representing all fences.
     */
    org.bukkit.Tag<Material> FENCES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("fences"), Material.class);
    /**
     * Vanilla block tag representing all tall flowers.
     */
    org.bukkit.Tag<Material> TALL_FLOWERS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("tall_flowers"), Material.class);
    /**
     * Vanilla block tag representing all flowers.
     */
    org.bukkit.Tag<Material> FLOWERS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("flowers"), Material.class);
    /**
     * Vanilla block tag representing all piglin repellents.
     */
    org.bukkit.Tag<Material> PIGLIN_REPELLENTS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("piglin_repellents"), Material.class);
    /**
     * Vanilla block tag representing all gold ores.
     */
    org.bukkit.Tag<Material> GOLD_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("gold_ores"), Material.class);
    /**
     * Vanilla block tag representing all iron ores.
     */
    org.bukkit.Tag<Material> IRON_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("iron_ores"), Material.class);
    /**
     * Vanilla block tag representing all diamond ores.
     */
    org.bukkit.Tag<Material> DIAMOND_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("diamond_ores"), Material.class);
    /**
     * Vanilla block tag representing all redstone ores.
     */
    org.bukkit.Tag<Material> REDSTONE_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("redstone_ores"), Material.class);
    /**
     * Vanilla block tag representing all lapis ores.
     */
    org.bukkit.Tag<Material> LAPIS_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("lapis_ores"), Material.class);
    /**
     * Vanilla block tag representing all coal ores.
     */
    org.bukkit.Tag<Material> COAL_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("coal_ores"), Material.class);
    /**
     * Vanilla block tag representing all emerald ores.
     */
    org.bukkit.Tag<Material> EMERALD_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("emerald_ores"), Material.class);
    /**
     * Vanilla block tag representing all copper ores.
     */
    org.bukkit.Tag<Material> COPPER_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("copper_ores"), Material.class);
    /**
     * Vanilla block tag representing all candles.
     */
    org.bukkit.Tag<Material> CANDLES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("candles"), Material.class);
    /**
     * Vanilla block tag representing all dirt.
     */
    org.bukkit.Tag<Material> DIRT = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dirt"), Material.class);
    /**
     * Vanilla block tag representing all terracotta.
     */
    org.bukkit.Tag<Material> TERRACOTTA = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("terracotta"), Material.class);
    /**
     * Vanilla block tag representing all concrete powder.
     */
    org.bukkit.Tag<Material> CONCRETE_POWDER = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("concrete_powder"), Material.class);
    /**
     * Vanilla block tag representing all blocks which complete the find tree
     * tutorial.
     */
    org.bukkit.Tag<Material> COMPLETES_FIND_TREE_TUTORIAL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("completes_find_tree_tutorial"), Material.class);
    /**
     * Vanilla block tag denoting blocks that enderman may pick up and hold.
     */
    org.bukkit.Tag<Material> ENDERMAN_HOLDABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("enderman_holdable"), Material.class);
    /**
     * Vanilla block tag denoting ice blocks.
     */
    org.bukkit.Tag<Material> ICE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("ice"), Material.class);
    /**
     * Vanilla block tag denoting all valid mob spawn positions.
     */
    org.bukkit.Tag<Material> VALID_SPAWN = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("valid_spawn"), Material.class);
    /**
     * Vanilla block tag denoting impermeable blocks which do not drip fluids.
     */
    org.bukkit.Tag<Material> IMPERMEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("impermeable"), Material.class);
    /**
     * Vanilla block tag denoting all underwater blocks which may be bonemealed.
     */
    org.bukkit.Tag<Material> UNDERWATER_BONEMEALS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("underwater_bonemeals"), Material.class);
    /**
     * Vanilla block tag representing all coral blocks.
     */
    org.bukkit.Tag<Material> CORAL_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("coral_blocks"), Material.class);
    /**
     * Vanilla block tag representing all wall corals.
     */
    org.bukkit.Tag<Material> WALL_CORALS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wall_corals"), Material.class);
    /**
     * Vanilla block tag representing all coral plants.
     */
    org.bukkit.Tag<Material> CORAL_PLANTS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("coral_plants"), Material.class);
    /**
     * Vanilla block tag representing all coral.
     */
    org.bukkit.Tag<Material> CORALS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("corals"), Material.class);
    /**
     * Vanilla block tag denoting all blocks bamboo may be planted on.
     */
    org.bukkit.Tag<Material> BAMBOO_PLANTABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("bamboo_plantable_on"), Material.class);
    /**
     * Vanilla block tag representing all standing signs.
     */
    org.bukkit.Tag<Material> STANDING_SIGNS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("standing_signs"), Material.class);
    /**
     * Vanilla block tag representing all wall signs.
     */
    org.bukkit.Tag<Material> WALL_SIGNS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wall_signs"), Material.class);
    /**
     * Vanilla block tag representing all regular signs.
     */
    org.bukkit.Tag<Material> SIGNS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("signs"), Material.class);
    /**
     * Vanilla block tag representing all ceiling signs.
     */
    org.bukkit.Tag<Material> CEILING_HANGING_SIGNS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("ceiling_hanging_signs"), Material.class);
    /**
     * Vanilla block tag representing all wall hanging signs.
     */
    org.bukkit.Tag<Material> WALL_HANGING_SIGNS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wall_hanging_signs"), Material.class);
    /**
     * Vanilla block tag representing all hanging signs.
     */
    org.bukkit.Tag<Material> ALL_HANGING_SIGNS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("all_hanging_signs"), Material.class);
    /**
     * Vanilla block tag representing all signs, regardless of type.
     */
    org.bukkit.Tag<Material> ALL_SIGNS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("all_signs"), Material.class);
    /**
     * Vanilla block tag representing all blocks immune to dragons.
     */
    org.bukkit.Tag<Material> DRAGON_IMMUNE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dragon_immune"), Material.class);
    /**
     * Vanilla block tag representing all blocks transparent to the ender
     * dragon.
     */
    org.bukkit.Tag<Material> DRAGON_TRANSPARENT = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dragon_transparent"), Material.class);
    /**
     * Vanilla block tag representing all blocks immune to withers.
     */
    org.bukkit.Tag<Material> WITHER_IMMUNE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wither_immune"), Material.class);
    /**
     * Vanilla block tag representing all base blocks used for wither summoning.
     */
    org.bukkit.Tag<Material> WITHER_SUMMON_BASE_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wither_summon_base_blocks"), Material.class);
    /**
     * Vanilla block tag representing all beehives.
     */
    org.bukkit.Tag<Material> BEEHIVES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("beehives"), Material.class);
    /**
     * Vanilla block tag representing all crops.
     */
    org.bukkit.Tag<Material> CROPS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("crops"), Material.class);
    /**
     * Vanilla block tag representing all bee growables.
     */
    org.bukkit.Tag<Material> BEE_GROWABLES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("bee_growables"), Material.class);
    /**
     * Vanilla block tag representing all portals.
     */
    org.bukkit.Tag<Material> PORTALS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("portals"), Material.class);
    /**
     * Vanilla block tag representing all fire blocks.
     */
    org.bukkit.Tag<Material> FIRE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("fire"), Material.class);
    /**
     * Vanilla block tag representing all nylium blocks.
     */
    org.bukkit.Tag<Material> NYLIUM = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("nylium"), Material.class);
    /**
     * Vanilla block tag representing all wart blocks.
     */
    org.bukkit.Tag<Material> WART_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wart_blocks"), Material.class);
    /**
     * Vanilla block tag representing all beacon base blocks.
     */
    org.bukkit.Tag<Material> BEACON_BASE_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("beacon_base_blocks"), Material.class);
    /**
     * Vanilla block tag representing all blocks affected by the soul speed
     * enchantment.
     */
    org.bukkit.Tag<Material> SOUL_SPEED_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("soul_speed_blocks"), Material.class);
    /**
     * Vanilla block tag representing all wall post overrides.
     */
    org.bukkit.Tag<Material> WALL_POST_OVERRIDE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wall_post_override"), Material.class);
    /**
     * Vanilla block tag representing all climbable blocks.
     */
    org.bukkit.Tag<Material> CLIMBABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("climbable"), Material.class);
    /**
     * Vanilla block tag representing all blocks which reset fall damage.
     */
    org.bukkit.Tag<Material> FALL_DAMAGE_RESETTING = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("fall_damage_resetting"), Material.class);
    /**
     * Vanilla block tag representing all shulker boxes.
     */
    org.bukkit.Tag<Material> SHULKER_BOXES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("shulker_boxes"), Material.class);
    /**
     * Vanilla block tag representing all hoglin repellents.
     */
    org.bukkit.Tag<Material> HOGLIN_REPELLENTS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("hoglin_repellents"), Material.class);
    /**
     * Vanilla block tag representing all soul fire base blocks.
     */
    org.bukkit.Tag<Material> SOUL_FIRE_BASE_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("soul_fire_base_blocks"), Material.class);
    /**
     * Vanilla block tag representing all warm strider blocks.
     */
    org.bukkit.Tag<Material> STRIDER_WARM_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("strider_warm_blocks"), Material.class);
    /**
     * Vanilla block tag representing all campfires.
     */
    org.bukkit.Tag<Material> CAMPFIRES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("campfires"), Material.class);
    /**
     * Vanilla block tag representing all blocks guarded by piglins.
     */
    org.bukkit.Tag<Material> GUARDED_BY_PIGLINS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("guarded_by_piglins"), Material.class);
    /**
     * Vanilla block tag representing all blocks that prevent inside mob
     * spawning.
     */
    org.bukkit.Tag<Material> PREVENT_MOB_SPAWNING_INSIDE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("prevent_mob_spawning_inside"), Material.class);
    /**
     * Vanilla block tag representing all fence gates.
     */
    org.bukkit.Tag<Material> FENCE_GATES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("fence_gates"), Material.class);
    /**
     * Vanilla block tag representing all unstable bottom center blocks.
     */
    org.bukkit.Tag<Material> UNSTABLE_BOTTOM_CENTER = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("unstable_bottom_center"), Material.class);
    org.bukkit.Tag<Material> MUSHROOM_GROW_BLOCK = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mushroom_grow_block"), Material.class);

    /**
     * Vanilla block tag representing all blocks that burn forever in the
     * overworld.
     */
    org.bukkit.Tag<Material> INFINIBURN_OVERWORLD = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("infiniburn_overworld"), Material.class);
    /**
     * Vanilla block tag representing all blocks that burn forever in the
     * nether.
     */
    org.bukkit.Tag<Material> INFINIBURN_NETHER = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("infiniburn_nether"), Material.class);
    /**
     * Vanilla block tag representing all blocks that burn forever in the end.
     */
    org.bukkit.Tag<Material> INFINIBURN_END = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("infiniburn_end"), Material.class);
    /**
     * Vanilla block tag representing the overworld base material.
     */
    org.bukkit.Tag<Material> BASE_STONE_OVERWORLD = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("base_stone_overworld"), Material.class);
    /**
     * Vanilla block tag representing all blocks that may be replaced by ores.
     */
    org.bukkit.Tag<Material> STONE_ORE_REPLACEABLES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("stone_ore_replaceables"), Material.class);
    /**
     * Vanilla block tag representing all blocks that may be replaced by
     * deepslate ores.
     */
    org.bukkit.Tag<Material> DEEPSLATE_ORE_REPLACEABLES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("deepslate_ore_replaceables"), Material.class);
    /**
     * Vanilla block tag representing the nether base material.
     */
    org.bukkit.Tag<Material> BASE_STONE_NETHER = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("base_stone_nether"), Material.class);
    /**
     * Vanilla block tag representing all blocks replaceable by the overworld
     * carver.
     */
    org.bukkit.Tag<Material> OVERWORLD_CARVER_REPLACEABLES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("overworld_carver_replaceables"), Material.class);
    /**
     * Vanilla block tag representing all blocks replaceable by the nether
     * carver.
     */
    org.bukkit.Tag<Material> NETHER_CARVER_REPLACEABLES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("nether_carver_replaceables"), Material.class);
    /**
     * Vanilla block tag representing all candle cakes.
     */
    org.bukkit.Tag<Material> CANDLE_CAKES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("candle_cakes"), Material.class);
    /**
     * Vanilla block tag representing all cauldrons.
     */
    org.bukkit.Tag<Material> CAULDRONS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("cauldrons"), Material.class);
    /**
     * Vanilla block tag representing all blocks that make crystal sounds.
     */
    org.bukkit.Tag<Material> CRYSTAL_SOUND_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("crystal_sound_blocks"), Material.class);
    /**
     * Vanilla block tag representing all blocks that play muffled step sounds.
     */
    org.bukkit.Tag<Material> INSIDE_STEP_SOUND_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("inside_step_sound_blocks"), Material.class);
    /**
     * Vanilla block tag representing all blocks that play combination step sounds.
     */
    org.bukkit.Tag<Material> COMBINATION_STEP_SOUND_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("combination_step_sound_blocks"), Material.class);
    /**
     * Vanilla block tag representing all blocks that play step sounds with camels on sand.
     */
    org.bukkit.Tag<Material> CAMEL_SAND_STEP_SOUND_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("camel_sand_step_sound_blocks"), Material.class);
    /**
     * Vanilla block tag representing all blocks that block vibration signals.
     */
    org.bukkit.Tag<Material> OCCLUDES_VIBRATION_SIGNALS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("occludes_vibration_signals"), Material.class);
    /**
     * Vanilla block tag representing all blocks that dampen the propagation of
     * vibration signals.
     */
    org.bukkit.Tag<Material> DAMPENS_VIBRATIONS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dampens_vibrations"), Material.class);
    /**
     * Vanilla block tag representing all blocks that are replaceable by
     * dripstone.
     */
    org.bukkit.Tag<Material> DRIPSTONE_REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dripstone_replaceable_blocks"), Material.class);
    /**
     * Vanilla block tag representing all cave vines.
     */
    org.bukkit.Tag<Material> CAVE_VINES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("cave_vines"), Material.class);
    /**
     * Vanilla block tag representing all blocks replaceable by moss.
     */
    org.bukkit.Tag<Material> MOSS_REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("moss_replaceable"), Material.class);
    /**
     * Vanilla block tag representing all blocks replaceable by lush ground.
     */
    org.bukkit.Tag<Material> LUSH_GROUND_REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("lush_ground_replaceable"), Material.class);
    /**
     * Vanilla block tag representing all blocks replaceable by azalea root.
     */
    org.bukkit.Tag<Material> AZALEA_ROOT_REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("azalea_root_replaceable"), Material.class);
    /**
     * Vanilla block tag representing all blocks which small dripleaf can be
     * placed on.
     */
    org.bukkit.Tag<Material> SMALL_DRIPLEAF_PLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("small_dripleaf_placeable"), Material.class);
    /**
     * Vanilla block tag representing all blocks which big dripleaf can be
     * placed on.
     */
    org.bukkit.Tag<Material> BIG_DRIPLEAF_PLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("big_dripleaf_placeable"), Material.class);
    /**
     * Vanilla block tag representing all snow blocks.
     */
    org.bukkit.Tag<Material> SNOW = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("snow"), Material.class);
    /**
     * Vanilla block tag representing all blocks mineable with an axe.
     */
    org.bukkit.Tag<Material> MINEABLE_AXE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mineable/axe"), Material.class);
    /**
     * Vanilla block tag representing all blocks mineable with a hoe.
     */
    org.bukkit.Tag<Material> MINEABLE_HOE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mineable/hoe"), Material.class);
    /**
     * Vanilla block tag representing all blocks mineable with a pickaxe.
     */
    org.bukkit.Tag<Material> MINEABLE_PICKAXE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mineable/pickaxe"), Material.class);
    /**
     * Vanilla block tag representing all blocks mineable with a shovel.
     */
    org.bukkit.Tag<Material> MINEABLE_SHOVEL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mineable/shovel"), Material.class);
    /**
     * Vanilla block tag representing all blocks that can be efficiently mined with a sword.
     */
    org.bukkit.Tag<Material> SWORD_EFFICIENT = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sword_efficient"), Material.class);
    /**
     * Vanilla block tag representing all blocks which require a diamond tool.
     */
    org.bukkit.Tag<Material> NEEDS_DIAMOND_TOOL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("needs_diamond_tool"), Material.class);
    /**
     * Vanilla block tag representing all blocks which require an iron tool.
     */
    org.bukkit.Tag<Material> NEEDS_IRON_TOOL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("needs_iron_tool"), Material.class);
    /**
     * Vanilla block tag representing all blocks which require a stone tool.
     */
    org.bukkit.Tag<Material> NEEDS_STONE_TOOL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("needs_stone_tool"), Material.class);
    /**
     * Vanilla block tag representing all blocks which will not be replaced by
     * world generation features.
     */
    org.bukkit.Tag<Material> FEATURES_CANNOT_REPLACE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("features_cannot_replace"), Material.class);
    /**
     * Vanilla block tag representing all blocks which lava pools will not
     * replace.
     */
    org.bukkit.Tag<Material> LAVA_POOL_STONE_CANNOT_REPLACE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("lava_pool_stone_cannot_replace"), Material.class);
    /**
     * Vanilla block tag representing all blocks which geodes will not spawn in.
     */
    org.bukkit.Tag<Material> GEODE_INVALID_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("geode_invalid_blocks"), Material.class);
    /**
     * Vanilla block tag representing all blocks which frogs prefer to jump to.
     */
    org.bukkit.Tag<Material> FROG_PREFER_JUMP_TO = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("frog_prefer_jump_to"), Material.class);
    /**
     * Vanilla block tag representing all blocks which can be replaced by skulk.
     */
    org.bukkit.Tag<Material> SCULK_REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sculk_replaceable"), Material.class);
    /**
     * Vanilla block tag representing all blocks which can be replaced by skulk
     * during world generation.
     */
    org.bukkit.Tag<Material> SCULK_REPLACEABLE_WORLD_GEN = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sculk_replaceable_world_gen"), Material.class);
    /**
     * Vanilla block tag representing all blocks which can be replaced by
     * ancient cities.
     */
    org.bukkit.Tag<Material> ANCIENT_CITY_REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("ancient_city_replaceable"), Material.class);
    /**
     * Vanilla block tag representing all blocks which resonate vibrations.
     */
    org.bukkit.Tag<Material> VIBRATION_RESONATORS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("vibration_resonators"), Material.class);
    /**
     * Vanilla block tag representing all blocks which animals will spawn on.
     */
    org.bukkit.Tag<Material> ANIMALS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("animals_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which axolotls will spawn on.
     */
    org.bukkit.Tag<Material> AXOLOTLS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("axolotls_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which goats will spawn on.
     */
    org.bukkit.Tag<Material> GOATS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("goats_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which mooshrooms will spawn on.
     */
    org.bukkit.Tag<Material> MOOSHROOMS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mooshrooms_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which parrots will spawn on.
     */
    org.bukkit.Tag<Material> PARROTS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("parrots_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which polar bears will spawn
     * on.
     */
    org.bukkit.Tag<Material> POLAR_BEARS_SPAWNABLE_ON_ALTERNATE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("polar_bears_spawnable_on_alternate"), Material.class);
    /**
     * Vanilla block tag representing all blocks which rabbits will spawn on.
     */
    org.bukkit.Tag<Material> RABBITS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("rabbits_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which foxes will spawn on.
     */
    org.bukkit.Tag<Material> FOXES_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("foxes_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which wolves will spawn on.
     */
    org.bukkit.Tag<Material> WOLVES_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wolves_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which frogs will spawn on.
     */
    org.bukkit.Tag<Material> FROGS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("frogs_spawnable_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which azaleas will grow on.
     */
    org.bukkit.Tag<Material> AZALEA_GROWS_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("azalea_grows_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which may be converted to mud.
     */
    org.bukkit.Tag<Material> CONVERTABLE_TO_MUD = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("convertable_to_mud"), Material.class);
    /**
     * Vanilla block tag representing all blocks which mangrove logs can grow
     * through.
     */
    org.bukkit.Tag<Material> MANGROVE_LOGS_CAN_GROW_THROUGH = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mangrove_logs_can_grow_through"), Material.class);
    /**
     * Vanilla block tag representing all blocks which mangrove roots can grow
     * through.
     */
    org.bukkit.Tag<Material> MANGROVE_ROOTS_CAN_GROW_THROUGH = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mangrove_roots_can_grow_through"), Material.class);
    /**
     * Vanilla block tag representing all blocks which dead bushes may be placed
     * on.
     */
    org.bukkit.Tag<Material> DEAD_BUSH_MAY_PLACE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dead_bush_may_place_on"), Material.class);
    /**
     * Vanilla block tag representing all blocks which snap dropped goat horns.
     */
    org.bukkit.Tag<Material> SNAPS_GOAT_HORN = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("snaps_goat_horn"), Material.class);
    /**
     * Vanilla block tag representing all blocks replaceable by growing trees.
     */
    org.bukkit.Tag<Material> REPLACEABLE_BY_TREES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("replaceable_by_trees"), Material.class);
    /**
     * Vanilla block tag representing blocks which snow cannot survive on.
     */
    org.bukkit.Tag<Material> SNOW_LAYER_CANNOT_SURVIVE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("snow_layer_cannot_survive_on"), Material.class);
    /**
     * Vanilla block tag representing blocks which snow can survive on.
     */
    org.bukkit.Tag<Material> SNOW_LAYER_CAN_SURVIVE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("snow_layer_can_survive_on"), Material.class);
    /**
     * Vanilla block tag representing blocks which cannot be dismounted into.
     */
    org.bukkit.Tag<Material> INVALID_SPAWN_INSIDE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("invalid_spawn_inside"), Material.class);
    /**
     * Vanilla block tag representing blocks which can be dug by sniffers.
     */
    org.bukkit.Tag<Material> SNIFFER_DIGGABLE_BLOCK = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sniffer_diggable_block"), Material.class);
    /**
     * Vanilla block tag representing all blocks which booster sniffer egg hatching.
     */
    org.bukkit.Tag<Material> SNIFFER_EGG_HATCH_BOOST = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sniffer_egg_hatch_boost"), Material.class);
    /**
     * Vanilla block tag representing all blocks which can be replaced by trail ruins.
     */
    org.bukkit.Tag<Material> TRAIL_RUINS_REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("trail_ruins_replaceable"), Material.class);
    /**
     * Vanilla block tag representing all blocks which are replaceable.
     */
    org.bukkit.Tag<Material> REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("replaceable"), Material.class);
    /**
     * Vanilla block tag representing all blocks which provide enchantment power.
     */
    org.bukkit.Tag<Material> ENCHANTMENT_POWER_PROVIDER = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("enchantment_power_provider"), Material.class);
    /**
     * Vanilla block tag representing all blocks which transmit enchantment power.
     */
    org.bukkit.Tag<Material> ENCHANTMENT_POWER_TRANSMITTER = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("enchantment_power_transmitter"), Material.class);
    /**
     * Vanilla block tag representing all blocks which do not destroy farmland when placed.
     */
    org.bukkit.Tag<Material> MAINTAINS_FARMLAND = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("maintains_farmland"), Material.class);
    /**
     * Key for the built in item registry.
     */
    String REGISTRY_ITEMS = "items";
    /**
     * Vanilla item tag representing all items loved by piglins.
     */
    org.bukkit.Tag<Material> ITEMS_PIGLIN_LOVED = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("piglin_loved"), Material.class);
    /**
     * Vanilla item tag representing all items ignored by piglin babies.
     */
    org.bukkit.Tag<Material> IGNORED_BY_PIGLIN_BABIES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("ignored_by_piglin_babies"), Material.class);
    /**
     * Vanilla item tag representing all piglin food.
     */
    org.bukkit.Tag<Material> PIGLIN_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("piglin_food"), Material.class);
    /**
     * Vanilla item tag representing all fox food.
     */
    org.bukkit.Tag<Material> FOX_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("fox_food"), Material.class);
    /**
     * Vanilla item tag representing all banner items.
     */
    org.bukkit.Tag<Material> ITEMS_BANNERS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("banners"), Material.class);
    /**
     * Vanilla item tag representing all boat items.
     */
    org.bukkit.Tag<Material> ITEMS_BOATS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("boats"), Material.class);
    /**
     * Vanilla item tag representing all chest boat items.
     */
    org.bukkit.Tag<Material> ITEMS_CHEST_BOATS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("chest_boats"), Material.class);
    /**
     * Vanilla item tag representing all fish items.
     */
    org.bukkit.Tag<Material> ITEMS_FISHES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("fishes"), Material.class);
    /**
     * Vanilla item tag representing all music disc items.
     */
    org.bukkit.Tag<Material> ITEMS_MUSIC_DISCS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("music_discs"), Material.class);
    /**
     * Vanilla item tag representing all music disc items dropped by creepers.
     */
    org.bukkit.Tag<Material> ITEMS_CREEPER_DROP_MUSIC_DISCS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("creeper_drop_music_discs"), Material.class);
    /**
     * Vanilla item tag representing all coal items.
     */
    org.bukkit.Tag<Material> ITEMS_COALS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("coals"), Material.class);
    /**
     * Vanilla item tag representing all arrow items.
     */
    org.bukkit.Tag<Material> ITEMS_ARROWS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("arrows"), Material.class);
    /**
     * Vanilla item tag representing all books that may be placed on lecterns.
     */
    org.bukkit.Tag<Material> ITEMS_LECTERN_BOOKS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("lectern_books"), Material.class);
    /**
     * Vanilla item tag representing all books that may be placed on bookshelves.
     */
    org.bukkit.Tag<Material> ITEMS_BOOKSHELF_BOOKS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("bookshelf_books"), Material.class);
    /**
     * Vanilla item tag representing all items that may be placed in beacons.
     */
    org.bukkit.Tag<Material> ITEMS_BEACON_PAYMENT_ITEMS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("beacon_payment_items"), Material.class);
    /**
     * Vanilla item tag representing all stone tool materials.
     */
    org.bukkit.Tag<Material> ITEMS_STONE_TOOL_MATERIALS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("stone_tool_materials"), Material.class);
    /**
     * Vanilla item tag representing all furnace materials.
     */
    org.bukkit.Tag<Material> ITEMS_FURNACE_MATERIALS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("furnace_materials"), Material.class);
    /**
     * Vanilla item tag representing all compasses.
     */
    org.bukkit.Tag<Material> ITEMS_COMPASSES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("compasses"), Material.class);
    /**
     * Vanilla item tag representing all hanging signs.
     */
    org.bukkit.Tag<Material> ITEMS_HANGING_SIGNS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("hanging_signs"), Material.class);
    /**
     * Vanilla item tag representing all items which will ignite creepers when
     * interacted with.
     */
    org.bukkit.Tag<Material> ITEMS_CREEPER_IGNITERS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("creeper_igniters"), Material.class);
    /**
     * Vanilla item tag representing all items which modify note block sounds when placed on top.
     */
    org.bukkit.Tag<Material> ITEMS_NOTE_BLOCK_TOP_INSTRUMENTS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("noteblock_top_instruments"), Material.class);
    /**
     * Vanilla item tag representing all trimmable armor items.
     */
    org.bukkit.Tag<Material> ITEMS_TRIMMABLE_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("trimmable_armor"), Material.class);
    /**
     * Vanilla item tag representing all materials which can be used for trimming armor.
     */
    org.bukkit.Tag<Material> ITEMS_TRIM_MATERIALS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("trim_materials"), Material.class);
    /**
     * Vanilla item tag representing all trimming templates.
     */
    org.bukkit.Tag<Material> ITEMS_TRIM_TEMPLATES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("trim_templates"), Material.class);
    /**
     * Vanilla item tag representing all food for sniffers.
     */
    org.bukkit.Tag<Material> ITEMS_SNIFFER_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("sniffer_food"), Material.class);
    /**
     * Vanilla item tag representing all decorated pot sherds.
     */
    org.bukkit.Tag<Material> ITEMS_DECORATED_POT_SHERDS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("decorated_pot_sherds"), Material.class);
    /**
     * Vanilla item tag representing all decorated pot ingredients.
     */
    org.bukkit.Tag<Material> ITEMS_DECORATED_POT_INGREDIENTS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("decorated_pot_ingredients"), Material.class);
    /**
     * Vanilla item tag representing all swords.
     */
    org.bukkit.Tag<Material> ITEMS_SWORDS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("swords"), Material.class);
    /**
     * Vanilla item tag representing all axes.
     */
    org.bukkit.Tag<Material> ITEMS_AXES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("axes"), Material.class);
    /**
     * Vanilla item tag representing all hoes.
     */
    org.bukkit.Tag<Material> ITEMS_HOES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("hoes"), Material.class);
    /**
     * Vanilla item tag representing all pickaxes.
     */
    org.bukkit.Tag<Material> ITEMS_PICKAXES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("pickaxes"), Material.class);
    /**
     * Vanilla item tag representing all shovels.
     */
    org.bukkit.Tag<Material> ITEMS_SHOVELS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("shovels"), Material.class);
    /**
     * Vanilla item tag representing all tools.
     */
    org.bukkit.Tag<Material> ITEMS_TOOLS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("tools"), Material.class);
    /**
     * Vanilla item tag representing all items which break decorated pots.
     */
    org.bukkit.Tag<Material> ITEMS_BREAKS_DECORATED_POTS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("breaks_decorated_pots"), Material.class);
    /**
     * Vanilla item tag representing all seeds planteable by villagers.
     */
    org.bukkit.Tag<Material> ITEMS_VILLAGER_PLANTABLE_SEEDS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("villager_plantable_seeds"), Material.class);
    /**
     * Vanilla item tag representing all items that confer freeze immunity on
     * the wearer.
     */
    org.bukkit.Tag<Material> FREEZE_IMMUNE_WEARABLES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("freeze_immune_wearables"), Material.class);
    /**
     * Vanilla item tag representing all items which tempt axolotls.
     */
    org.bukkit.Tag<Material> AXOLOTL_TEMPT_ITEMS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("axolotl_tempt_items"), Material.class);
    /**
     * Vanilla item tag representing all items which are preferred for
     * harvesting clusters (unused).
     */
    org.bukkit.Tag<Material> CLUSTER_MAX_HARVESTABLES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("cluster_max_harvestables"), Material.class);
    /**
     * Key for the built in fluid registry.
     */
    String REGISTRY_FLUIDS = "fluids";
    /**
     * Vanilla fluid tag representing lava and flowing lava.
     */
    Tag<Fluid> FLUIDS_LAVA = Bukkit.getTag(REGISTRY_FLUIDS, NamespacedKey.minecraft("lava"), Fluid.class);
    /**
     * Vanilla fluid tag representing water and flowing water.
     */
    Tag<Fluid> FLUIDS_WATER = Bukkit.getTag(REGISTRY_FLUIDS, NamespacedKey.minecraft("water"), Fluid.class);
    /**
     * Key for the built in entity registry.
     */
    String REGISTRY_ENTITY_TYPES = "entity_types";
    /**
     * Vanilla tag representing skeletons.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_SKELETONS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("skeletons"), EntityType.class);
    /**
     * Vanilla tag representing raiders.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_RAIDERS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("raiders"), EntityType.class);
    /**
     * Vanilla tag representing entities which can live in beehives.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_BEEHIVE_INHABITORS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("beehive_inhabitors"), EntityType.class);
    /**
     * Vanilla tag representing arrows.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_ARROWS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("arrows"), EntityType.class);
    /**
     * Vanilla tag representing projectiles.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_IMPACT_PROJECTILES = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("impact_projectiles"), EntityType.class);
    /**
     * Vanilla tag representing mobs which can walk on powder snow.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_POWDER_SNOW_WALKABLE_MOBS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("powder_snow_walkable_mobs"), EntityType.class);
    /**
     * Vanilla tag representing which entities axolotls are always hostile to.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_AXOLOTL_ALWAYS_HOSTILES = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("axolotl_always_hostiles"), EntityType.class);
    /**
     * Vanilla tag representing axolotl targets.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_AXOLOTL_HUNT_TARGETS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("axolotl_hunt_targets"), EntityType.class);
    /**
     * Vanilla tag representing entities immune from freezing.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_FREEZE_IMMUNE_ENTITY_TYPES = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("freeze_immune_entity_types"), EntityType.class);
    /**
     * Vanilla tag representing entities extra susceptible to freezing.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_FREEZE_HURTS_EXTRA_TYPES = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("freeze_hurts_extra_types"), EntityType.class);
    /**
     * Vanilla tag representing entities which can be eaten by frogs.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_FROG_FOOD = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("frog_food"), EntityType.class);
    /**
     * Vanilla tag representing entities which are immune from fall damage.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_FALL_DAMAGE_IMMUNE = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("fall_damage_immune"), EntityType.class);
    /**
     * Vanilla tag representing entities which are dismounted when underwater.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_DISMOUNTS_UNDERWATER = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("dismounts_underwater"), EntityType.class);
    /**
     * Vanilla tag representing entities which are not controlled by their mount.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_NON_CONTROLLING_RIDER = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("non_controlling_rider"), EntityType.class);
    /**
     * Vanilla tag representing entities which deflect arrows.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_DEFLECTS_ARROWS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("deflects_arrows"), EntityType.class);
    /**
     * Vanilla tag representing entities which deflect tridents.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_DEFLECTS_TRIDENTS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("deflects_tridents"), EntityType.class);
    /**
     * Vanilla tag representing entities which can turn in boats.
     */
    org.bukkit.Tag<EntityType> ENTITY_TYPES_CAN_TURN_IN_BOATS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("can_turn_in_boats"), EntityType.class);

    /**
     * Returns whether or not this tag has an entry for the specified item.
     *
     * @param item to check
     * @return if it is tagged
     */
    boolean isTagged(@NotNull T item);

    /**
     * Gets an immutable set of all tagged items.
     *
     * @return set of tagged items
     */
    @NotNull
    Set<T> getValues();

}

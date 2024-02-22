package dev.vulcanium.tag;

import dev.vulcanium.namespaced.NamespacedKey;
import dev.vulcanium.entity.EntityType;

public class EntityTags {
    public static final EntitySetTag UNDEADS;
    public static final EntitySetTag HORSES;
    public static final EntitySetTag MINECARTS;
    public static final EntitySetTag SPLITTING_MOBS;
    public static final EntitySetTag WATER_BASED;

    public EntityTags() {
    }

    private static NamespacedKey keyFor(String key) {
        return new NamespacedKey("paper", key + "_settag");
    }

    static {
        UNDEADS = (EntitySetTag)((EntitySetTag)((EntitySetTag)(new EntitySetTag(keyFor("undeads"), new EntityType[0])).add(new EntityType[]{EntityType.DROWNED, EntityType.HUSK, EntityType.PHANTOM, EntityType.SKELETON, EntityType.SKELETON_HORSE, EntityType.STRAY, EntityType.WITHER, EntityType.WITHER_SKELETON, EntityType.ZOGLIN, EntityType.ZOMBIE, EntityType.ZOMBIE_HORSE, EntityType.ZOMBIE_VILLAGER, EntityType.ZOMBIFIED_PIGLIN})).ensureSize("UNDEADS", 13)).lock();
        HORSES = (EntitySetTag)((EntitySetTag)((EntitySetTag)(new EntitySetTag(keyFor("horses"), new EntityType[0])).contains("HORSE")).ensureSize("HORSES", 3)).lock();
        MINECARTS = (EntitySetTag)((EntitySetTag)((EntitySetTag)(new EntitySetTag(keyFor("minecarts"), new EntityType[0])).contains("MINECART")).ensureSize("MINECARTS", 7)).lock();
        SPLITTING_MOBS = (EntitySetTag)((EntitySetTag)((EntitySetTag)(new EntitySetTag(keyFor("splitting_mobs"), new EntityType[0])).add(new EntityType[]{EntityType.SLIME, EntityType.MAGMA_CUBE})).ensureSize("SLIMES", 2)).lock();
        WATER_BASED = (EntitySetTag)((EntitySetTag)((EntitySetTag)(new EntitySetTag(keyFor("water_based"), new EntityType[0])).add(new EntityType[]{EntityType.AXOLOTL, EntityType.DOLPHIN, EntityType.SQUID, EntityType.GLOW_SQUID, EntityType.GUARDIAN, EntityType.ELDER_GUARDIAN, EntityType.TURTLE, EntityType.COD, EntityType.SALMON, EntityType.PUFFERFISH, EntityType.TROPICAL_FISH})).ensureSize("WATER_BASED", 11)).lock();
    }
}

package dev.vulcanium.world.structure;

import dev.vulcanium.generator.structure.Structure;
import dev.vulcanium.generator.structure.StructureType;
import dev.vulcanium.namespaced.Keyed;
import dev.vulcanium.namespaced.NamespacedKey;
import dev.vulcanium.registry.Reference;
import dev.vulcanium.registry.Registry;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/** @deprecated */
@Deprecated
public final class ConfiguredStructure implements Keyed {
    public static final Reference<ConfiguredStructure> PILLAGER_OUTPOST = create("pillager_outpost");
    public static final Reference<ConfiguredStructure> MINESHAFT = create("mineshaft");
    public static final Reference<ConfiguredStructure> MINESHAFT_MESA = create("mineshaft_mesa");
    public static final Reference<ConfiguredStructure> WOODLAND_MANSION = create("mansion");
    public static final Reference<ConfiguredStructure> JUNGLE_TEMPLE = create("jungle_pyramid");
    public static final Reference<ConfiguredStructure> DESERT_PYRAMID = create("desert_pyramid");
    public static final Reference<ConfiguredStructure> IGLOO = create("igloo");
    public static final Reference<ConfiguredStructure> SHIPWRECK = create("shipwreck");
    public static final Reference<ConfiguredStructure> SHIPWRECK_BEACHED = create("shipwreck_beached");
    public static final Reference<ConfiguredStructure> SWAMP_HUT = create("swamp_hut");
    public static final Reference<ConfiguredStructure> STRONGHOLD = create("stronghold");
    public static final Reference<ConfiguredStructure> OCEAN_MONUMENT = create("monument");
    public static final Reference<ConfiguredStructure> OCEAN_RUIN_COLD = create("ocean_ruin_cold");
    public static final Reference<ConfiguredStructure> OCEAN_RUIN_WARM = create("ocean_ruin_warm");
    public static final Reference<ConfiguredStructure> FORTRESS = create("fortress");
    public static final Reference<ConfiguredStructure> NETHER_FOSSIL = create("nether_fossil");
    public static final Reference<ConfiguredStructure> END_CITY = create("end_city");
    public static final Reference<ConfiguredStructure> BURIED_TREASURE = create("buried_treasure");
    public static final Reference<ConfiguredStructure> BASTION_REMNANT = create("bastion_remnant");
    public static final Reference<ConfiguredStructure> VILLAGE_PLAINS = create("village_plains");
    public static final Reference<ConfiguredStructure> VILLAGE_DESERT = create("village_desert");
    public static final Reference<ConfiguredStructure> VILLAGE_SAVANNA = create("village_savanna");
    public static final Reference<ConfiguredStructure> VILLAGE_SNOWY = create("village_snowy");
    public static final Reference<ConfiguredStructure> VILLAGE_TAIGA = create("village_taiga");
    public static final Reference<ConfiguredStructure> RUINED_PORTAL_STANDARD = create("ruined_portal");
    public static final Reference<ConfiguredStructure> RUINED_PORTAL_DESERT = create("ruined_portal_desert");
    public static final Reference<ConfiguredStructure> RUINED_PORTAL_JUNGLE = create("ruined_portal_jungle");
    public static final Reference<ConfiguredStructure> RUINED_PORTAL_SWAMP = create("ruined_portal_swamp");
    public static final Reference<ConfiguredStructure> RUINED_PORTAL_MOUNTAIN = create("ruined_portal_mountain");
    public static final Reference<ConfiguredStructure> RUINED_PORTAL_OCEAN = create("ruined_portal_ocean");
    public static final Reference<ConfiguredStructure> RUINED_PORTAL_NETHER = create("ruined_portal_nether");
    private final NamespacedKey key;
    private final StructureType structureType;

    public ConfiguredStructure(@NotNull NamespacedKey key, @NotNull StructureType structureType) {
        this.key = key;
        this.structureType = structureType;
    }

    public @NotNull NamespacedKey getKey() {
        return this.key;
    }

    public @NotNull StructureType getStructureType() {
        return this.structureType;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ConfiguredStructure structure = (ConfiguredStructure)o;
            return this.key.equals(structure.key) && this.structureType.equals(structure.structureType);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.structureType});
    }

    public String toString() {
        return "ConfiguredStructure{key=" + this.key + ", structureType=" + this.structureType + "}";
    }

    private static @NotNull Reference<ConfiguredStructure> create(@NotNull String name) {
        return Reference.create(Registry.CONFIGURED_STRUCTURE, NamespacedKey.minecraft(name));
    }

    @Internal
    public @NotNull Structure toModern() {
        return (Structure)Objects.requireNonNull((Structure)Registry.STRUCTURE.get(this.key));
    }
    @Internal
    public static @Nullable ConfiguredStructure fromModern(@NotNull Structure structure) {
        return (ConfiguredStructure)Registry.CONFIGURED_STRUCTURE.get(structure.getKey());
    }
}

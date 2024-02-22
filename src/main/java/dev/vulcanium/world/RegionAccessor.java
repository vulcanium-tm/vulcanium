/*
 Copyright © 2023

 Owner: Vulcanium

 Contributor: Shadowflare
 ────────────────────────────────────────────────────────────────────
 Permission is hereby granted to use and modify the Vulcanium plugin freely:

 1. Include copyright and permission notice in all copies of the Software.
 2. Users can depend on Vulcanium, create, and distribute plugins that rely on it.
 3. Republishing Vulcanium elsewhere is prohibited.
 4. Source code distribution is not allowed.
 5. Publishing a derivative version of the plugin is prohibited.
 ────────────────────────────────────────────────────────────────────
 SOFTWARE PROVIDED "AS IT IS," NO WARRANTY. AUTHORS NOT LIABLE FOR DAMAGES.
 */
package dev.vulcanium.world;

import dev.vulcanium.Location;
import dev.vulcanium.Material;
import dev.vulcanium.TreeType;
import dev.vulcanium.block.BlockState;
import dev.vulcanium.block.data.BlockData;
import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.EntityType;
import dev.vulcanium.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * A RegionAccessor gives access to getting, modifying, and spawning {@link Biome}, {@link BlockState}, and {@link Entity},
 * as well as generating basic structures.
 */
public interface RegionAccessor {

    @NotNull
    Biome getBiome(@NotNull Location location);

    @NotNull
    Biome getBiome(int x, int y, int z);

    void setBiome(@NotNull Location location, @NotNull Biome biome);

    void setBiome(int x, int y, int z, @NotNull Biome biome);

    @NotNull
    BlockState getBlockState(@NotNull Location location);

    @NotNull
    BlockState getBlockState(int x, int y, int z);

    @NotNull
    BlockData getBlockData(@NotNull Location location);

    @NotNull
    BlockData getBlockData(int x, int y, int z);

    @NotNull
    Material getType(@NotNull Location location);

    @NotNull
    Material getType(int x, int y, int z);

    void setBlockData(@NotNull Location location, @NotNull BlockData blockData);

    void setBlockData(int x, int y, int z, @NotNull BlockData blockData);

    void setType(@NotNull Location location, @NotNull Material material);

    void setType(int x, int y, int z, @NotNull Material material);

    boolean generateTree(@NotNull Location location, @NotNull Random random, @NotNull TreeType type);

    boolean generateTree(@NotNull Location location, @NotNull Random random, @NotNull TreeType type, @Nullable Consumer<? super BlockState> stateConsumer);

    boolean generateTree(@NotNull Location location, @NotNull Random random, @NotNull TreeType type, @Nullable Predicate<? super BlockState> statePredicate);

    @NotNull
    Entity spawnEntity(@NotNull Location location, @NotNull EntityType type);

    @NotNull
    Entity spawnEntity(@NotNull Location loc, @NotNull EntityType type, boolean randomizeData);

    @NotNull
    List<Entity> getEntities();

    @NotNull
    List<LivingEntity> getLivingEntities();

    @NotNull
    <T extends Entity> Collection<T> getEntitiesByClass(@NotNull Class<T> cls);

    @NotNull
    Collection<Entity> getEntitiesByClasses(@NotNull Class<?>... classes);

    @NotNull
    <T extends Entity> T createEntity(@NotNull Location location, @NotNull Class<T> clazz);

    @NotNull
    <T extends Entity> T spawn(@NotNull Location location, @NotNull Class<T> clazz) throws IllegalArgumentException;

    @NotNull
    <T extends Entity> T spawn(@NotNull Location location, @NotNull Class<T> clazz, @Nullable Consumer<? super T> function) throws IllegalArgumentException;

    @NotNull
    <T extends Entity> T spawn(@NotNull Location location, @NotNull Class<T> clazz, boolean randomizeData, @Nullable Consumer<? super T> function) throws IllegalArgumentException;

    int getHighestBlockYAt(int x, int z);

    int getHighestBlockYAt(@NotNull Location location);

    int getHighestBlockYAt(int x, int z, @NotNull HeightMap heightMap);

    int getHighestBlockYAt(@NotNull Location location, @NotNull HeightMap heightMap);

    @NotNull
    <T extends Entity> T addEntity(@NotNull T entity);
}

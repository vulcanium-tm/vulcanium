package org.vulcanium;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface World {

    // General Information

    @NotNull
    String getName();

    @NotNull
    UUID getUID();

    @NotNull
    Location getSpawnLocation();

    void setSpawnLocation(int x, int y, int z);

    @NotNull
    World.Environment getEnvironment();

    @NotNull
    WorldType getWorldType();

    // Time and Weather

    long getTime();

    void setTime(long time);

    boolean hasStorm();

    void setStorm(boolean hasStorm);

    int getWeatherDuration();

    void setWeatherDuration(int duration);

    boolean isThundering();

    void setThundering(boolean thundering);

    int getThunderDuration();

    void setThunderDuration(int duration);

    // Difficulty and Spawn Settings

    void setDifficulty(@NotNull Difficulty difficulty);

    @NotNull
    Difficulty getDifficulty();

    boolean isDifficultyLocked();

    void setDifficultyLocked(boolean locked);

    int getMaxHeight();

    int getSeaLevel();

    boolean getKeepSpawnInMemory();

    void setKeepSpawnInMemory(boolean keepLoaded);

    // Entities and Chunk Management

    boolean isChunkLoaded(int x, int z);

    boolean isChunkLoaded(int x, int z, boolean allowLoad);

    void loadChunk(int x, int z);

    boolean unloadChunk(int x, int z);

    boolean unloadChunk(int x, int z, boolean save);

    boolean unloadChunkRequest(int x, int z);

    boolean unloadChunkRequest(int x, int z, boolean save);

    boolean regenerateChunk(int x, int z);

    boolean refreshChunk(int x, int z);

    // Explosion and Generation

    boolean createExplosion(double x, double y, double z, float power, boolean setFire, boolean breakBlocks);

    // Miscellaneous

    @NotNull
    Location getZeroLocation();

    @Nullable
    MapView getMap(int id);

    @Nullable
    MapView createMap(@NotNull World world);

    @Nullable
    ItemStack getItemInHand();

    void setItemInHand(@Nullable ItemStack item);

    @Nullable
    ItemStack getItemOnCursor();

    void setItemOnCursor(@Nullable ItemStack item);

    @Nullable
    InventoryView getOpenInventory();

    @NotNull
    InventoryView openInventory(@NotNull Inventory inventory);
}

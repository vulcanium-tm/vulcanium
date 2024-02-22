package dev.vulcanium;

import dev.vulcanium.ban.BanEntry;
import dev.vulcanium.configuration.serialization.ConfigurationSerializable;
import dev.vulcanium.entity.AnimalTamer;
import dev.vulcanium.entity.EntityType;
import dev.vulcanium.entity.Player;
import dev.vulcanium.permissions.ServerOperator;
import dev.vulcanium.profile.PlayerProfile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.UUID;

public interface OfflinePlayer extends ServerOperator, AnimalTamer, ConfigurationSerializable {

    boolean isOnline();

    @Nullable
    String getName();

    @NotNull
    UUID getUniqueId();

    @NotNull
    PlayerProfile getPlayerProfile();

    boolean isBanned();

    @Nullable
    BanEntry<PlayerProfile> ban(@Nullable String reason, @Nullable Instant expires, @Nullable String source);

    boolean isWhitelisted();

    void setWhitelisted(boolean value);

    @Nullable
    Player getPlayer();

    long getFirstPlayed();

    long getLastPlayed();

    boolean hasPlayedBefore();

    @Nullable
    Location getBedSpawnLocation();

    @Nullable
    Location getRespawnLocation();

    void incrementStatistic(@NotNull Statistic statistic) throws IllegalArgumentException;

    void decrementStatistic(@NotNull Statistic statistic) throws IllegalArgumentException;

    void setStatistic(@NotNull Statistic statistic, int newValue) throws IllegalArgumentException;

    int getStatistic(@NotNull Statistic statistic) throws IllegalArgumentException;

    void incrementStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException;

    void decrementStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException;

    int getStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException;

    void incrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException;

    void decrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException;

    int getStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException;

    void incrementStatistic(@NotNull Statistic statistic, @NotNull Material material, int amount) throws IllegalArgumentException;

    void decrementStatistic(@NotNull Statistic statistic, @NotNull Material material, int amount);

    void setStatistic(@NotNull Statistic statistic, @NotNull Material material, int newValue);

    void incrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int amount) throws IllegalArgumentException;

    void decrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int amount);

    void setStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int newValue);

    @Nullable
    Location getLastDeathLocation();

    @Nullable
    Location getLocation();
}

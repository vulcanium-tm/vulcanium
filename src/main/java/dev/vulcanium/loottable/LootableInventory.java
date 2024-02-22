package dev.vulcanium.loottable;

import java.util.UUID;
import dev.vulcanium.entity.Player;
import dev.vulcanium.loot.Lootable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface LootableInventory extends Lootable {
    boolean isRefillEnabled();

    boolean hasBeenFilled();

    default boolean hasPlayerLooted(@NotNull Player player) {
        return this.hasPlayerLooted(player.getUniqueId());
    }

    boolean canPlayerLoot(@NotNull UUID var1);

    boolean hasPlayerLooted(@NotNull UUID var1);

    default @Nullable Long getLastLooted(@NotNull Player player) {
        return this.getLastLooted(player.getUniqueId());
    }

    @Nullable Long getLastLooted(@NotNull UUID var1);

    default boolean setHasPlayerLooted(@NotNull Player player, boolean looted) {
        return this.setHasPlayerLooted(player.getUniqueId(), looted);
    }

    boolean setHasPlayerLooted(@NotNull UUID var1, boolean var2);

    boolean hasPendingRefill();

    long getLastFilled();

    long getNextRefill();

    long setNextRefill(long var1);
}

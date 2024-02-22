package dev.vulcanium.entity.villager;

import com.google.common.base.Preconditions;
import java.util.EnumMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public final class Reputation {
    private final @NotNull Map<ReputationType, Integer> reputation;

    public Reputation() {
        this(new EnumMap(ReputationType.class));
    }

    public Reputation(@NotNull Map<ReputationType, Integer> reputation) {
        Preconditions.checkNotNull(reputation, "reputation cannot be null");
        this.reputation = reputation;
    }

    public int getReputation(@NotNull ReputationType type) {
        Preconditions.checkNotNull(type, "the reputation type cannot be null");
        return (Integer)this.reputation.getOrDefault(type, 0);
    }

    public void setReputation(@NotNull ReputationType type, int value) {
        Preconditions.checkNotNull(type, "the reputation type cannot be null");
        this.reputation.put(type, value);
    }

    public boolean hasReputationSet(@NotNull ReputationType type) {
        return this.reputation.containsKey(type);
    }
}

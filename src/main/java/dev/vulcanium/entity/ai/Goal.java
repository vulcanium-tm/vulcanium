package dev.vulcanium.entity.ai;

import dev.vulcanium.entity.Mob;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

public interface Goal<T extends Mob> {
    boolean shouldActivate();

    default boolean shouldStayActive() {
        return this.shouldActivate();
    }

    default void start() {
    }

    default void stop() {
    }

    default void tick() {
    }

    @NotNull GoalKey<T> getKey();

    @NotNull EnumSet<GoalType> getTypes();
}

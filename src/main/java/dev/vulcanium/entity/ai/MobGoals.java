package dev.vulcanium.entity.ai;

import dev.vulcanium.entity.Mob;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface MobGoals {
    <T extends Mob> void addGoal(@NotNull T var1, int var2, @NotNull Goal<T> var3);

    <T extends Mob> void removeGoal(@NotNull T var1, @NotNull Goal<T> var2);

    <T extends Mob> void removeAllGoals(@NotNull T var1);

    <T extends Mob> void removeAllGoals(@NotNull T var1, @NotNull GoalType var2);

    <T extends Mob> void removeGoal(@NotNull T var1, @NotNull GoalKey<T> var2);

    <T extends Mob> boolean hasGoal(@NotNull T var1, @NotNull GoalKey<T> var2);

    <T extends Mob> @Nullable Goal<T> getGoal(@NotNull T var1, @NotNull GoalKey<T> var2);

    <T extends Mob> @NotNull Collection<Goal<T>> getGoals(@NotNull T var1, @NotNull GoalKey<T> var2);

    <T extends Mob> @NotNull Collection<Goal<T>> getAllGoals(@NotNull T var1);

    <T extends Mob> @NotNull Collection<Goal<T>> getAllGoals(@NotNull T var1, @NotNull GoalType var2);

    <T extends Mob> @NotNull Collection<Goal<T>> getAllGoalsWithout(@NotNull T var1, @NotNull GoalType var2);

    <T extends Mob> @NotNull Collection<Goal<T>> getRunningGoals(@NotNull T var1);

    <T extends Mob> @NotNull Collection<Goal<T>> getRunningGoals(@NotNull T var1, @NotNull GoalType var2);

    <T extends Mob> @NotNull Collection<Goal<T>> getRunningGoalsWithout(@NotNull T var1, @NotNull GoalType var2);
}

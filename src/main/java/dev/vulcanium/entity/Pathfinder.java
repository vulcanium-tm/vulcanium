package dev.vulcanium.entity;

import dev.vulcanium.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface Pathfinder {
    @NotNull Mob getEntity();

    void stopPathfinding();

    boolean hasPath();

    @Nullable PathResult getCurrentPath();

    @Nullable PathResult findPath(@NotNull Location var1);

    @Nullable PathResult findPath(@NotNull LivingEntity var1);

    default boolean moveTo(@NotNull Location loc) {
        return this.moveTo(loc, 1.0);
    }

    default boolean moveTo(@NotNull Location loc, double speed) {
        PathResult path = this.findPath(loc);
        return path != null && this.moveTo(path, speed);
    }

    default boolean moveTo(@NotNull LivingEntity target) {
        return this.moveTo(target, 1.0);
    }

    default boolean moveTo(@NotNull LivingEntity target, double speed) {
        PathResult path = this.findPath(target);
        return path != null && this.moveTo(path, speed);
    }

    default boolean moveTo( @NotNull PathResult path) {
        return this.moveTo(path, 1.0);
    }

    boolean moveTo( @NotNull PathResult var1, double var2);

    boolean canOpenDoors();

    void setCanOpenDoors(boolean var1);

    boolean canPassDoors();

    void setCanPassDoors(boolean var1);

    boolean canFloat();

    void setCanFloat(boolean var1);

    public interface PathResult {
        @NotNull List<Location> getPoints();

        int getNextPointIndex();

        @Nullable Location getNextPoint();

        @Nullable Location getFinalPoint();
    }
}

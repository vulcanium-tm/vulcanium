package dev.vulcanium.math;

import dev.vulcanium.Location;
import dev.vulcanium.world.World;
import dev.vulcanium.util.Vector;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;

@Experimental
public interface Position {
    FinePosition FINE_ZERO = new FinePositionImpl(0.0, 0.0, 0.0);
    BlockPosition BLOCK_ZERO = new BlockPositionImpl(0, 0, 0);

    int blockX();

    int blockY();

    int blockZ();

    double x();

    double y();

    double z();

    boolean isBlock();

    boolean isFine();

    default boolean isFinite() {
        return Double.isFinite(this.x()) && Double.isFinite(this.y()) && Double.isFinite(this.z());
    }

    @NotNull Position offset(int var1, int var2, int var3);

    @NotNull FinePosition offset(double var1, double var3, double var5);

    @Contract(
            value = "-> new",
            pure = true
    )
    default @NotNull FinePosition toCenter() {
        return new FinePositionImpl((double)this.blockX() + 0.5, (double)this.blockY() + 0.5, (double)this.blockZ() + 0.5);
    }

    @Contract(
            pure = true
    )
    @NotNull BlockPosition toBlock();

    @Contract(
            value = "-> new",
            pure = true
    )
    default @NotNull Vector toVector() {
        return new Vector(this.x(), this.y(), this.z());
    }

    @Contract(
            value = "_ -> new",
            pure = true
    )
    default @NotNull Location toLocation(@NotNull World world) {
        return new Location(world, this.x(), this.y(), this.z());
    }

    @Contract(
            value = "_, _, _ -> new",
            pure = true
    )
    static @NotNull BlockPosition block(int x, int y, int z) {
        return new BlockPositionImpl(x, y, z);
    }

    @Contract(
            value = "_ -> new",
            pure = true
    )
    static @NotNull BlockPosition block(@NotNull Location location) {
        return new BlockPositionImpl(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    @Contract(
            value = "_, _, _ -> new",
            pure = true
    )
    static @NotNull FinePosition fine(double x, double y, double z) {
        return new FinePositionImpl(x, y, z);
    }

    @Contract(
            value = "_ -> new",
            pure = true
    )
    static @NotNull FinePosition fine(@NotNull Location location) {
        return new FinePositionImpl(location.getX(), location.getY(), location.getZ());
    }
}

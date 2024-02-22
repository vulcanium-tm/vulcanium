package dev.vulcanium.math;


import dev.vulcanium.util.NumberConversions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;

@Experimental
public interface FinePosition extends Position {
    default int blockX() {
        return NumberConversions.floor(this.x());
    }

    default int blockY() {
        return NumberConversions.floor(this.y());
    }

    default int blockZ() {
        return NumberConversions.floor(this.z());
    }

    default boolean isBlock() {
        return false;
    }

    default boolean isFine() {
        return true;
    }

    default @NotNull BlockPosition toBlock() {
        return new BlockPositionImpl(this.blockX(), this.blockY(), this.blockZ());
    }

    default @NotNull FinePosition offset(int x, int y, int z) {
        return this.offset((double)x, (double)y, (double)z);
    }

    default @NotNull FinePosition offset(double x, double y, double z) {
        return (FinePosition)(x == 0.0 && y == 0.0 && z == 0.0 ? this : new FinePositionImpl(this.x() + x, this.y() + y, this.z() + z));
    }
}

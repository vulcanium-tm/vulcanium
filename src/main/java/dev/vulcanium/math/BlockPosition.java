package dev.vulcanium.math;

import dev.vulcanium.Axis;
import dev.vulcanium.block.BlockFace;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;

@Experimental
public interface BlockPosition extends Position {
    default double x() {
        return (double)this.blockX();
    }

    default double y() {
        return (double)this.blockY();
    }

    default double z() {
        return (double)this.blockZ();
    }

    default boolean isBlock() {
        return true;
    }

    default boolean isFine() {
        return false;
    }

    default @NotNull BlockPosition toBlock() {
        return this;
    }

    default @NotNull BlockPosition offset(int x, int y, int z) {
        return (BlockPosition)(x == 0 && y == 0 && z == 0 ? this : new BlockPositionImpl(this.blockX() + x, this.blockY() + y, this.blockZ() + z));
    }

    default @NotNull FinePosition offset(double x, double y, double z) {
        return new FinePositionImpl((double)this.blockX() + x, (double)this.blockY() + y, (double)this.blockZ() + z);
    }

    @Contract(
            value = "_ -> new",
            pure = true
    )
    default @NotNull BlockPosition offset(@NotNull BlockFace blockFace) {
        return this.offset((BlockFace)blockFace, 1);
    }

    @Contract(
            pure = true
    )
    default @NotNull BlockPosition offset(@NotNull BlockFace blockFace, int amount) {
        return (BlockPosition)(amount == 0 ? this : new BlockPositionImpl(this.blockX() + blockFace.getModX() * amount, this.blockY() + blockFace.getModY() * amount, this.blockZ() + blockFace.getModZ() * amount));
    }

    @Contract(
            pure = true
    )
    default @NotNull BlockPosition offset(@NotNull Axis axis, int amount) {
        Object var10000;
        if (amount == 0) {
            var10000 = this;
        } else {
            switch (axis) {
                case X:
                    var10000 = new BlockPositionImpl(this.blockX() + amount, this.blockY(), this.blockZ());
                    break;
                case Y:
                    var10000 = new BlockPositionImpl(this.blockX(), this.blockY() + amount, this.blockZ());
                    break;
                case Z:
                    var10000 = new BlockPositionImpl(this.blockX(), this.blockY(), this.blockZ() + amount);
                    break;
                default:
                    throw new IncompatibleClassChangeError();
            }
        }

        return (BlockPosition)var10000;
    }
}

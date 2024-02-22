package dev.vulcanium.block;

import dev.vulcanium.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

public interface MovingPiston extends TileState {
    @NotNull BlockData getMovingBlock();

    @NotNull BlockFace getDirection();

    boolean isExtending();

    boolean isPistonHead();
}

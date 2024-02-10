package org.vulcanium.event.block;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.vulcanium.block.Block;
import org.vulcanium.block.BlockState;
import org.vulcanium.entity.Player;
import org.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Fired when a single block placement action of a player triggers the
 * creation of multiple blocks(e.g. placing a bed block). The block returned
 * by {@link #getBlockPlaced()} and its related methods is the block where
 * the placed block would exist if the placement only affected a single
 * block.
 */
public class BlockMultiPlaceEvent extends BlockPlaceEvent {
    private final List<BlockState> states;

    public BlockMultiPlaceEvent(@NotNull List<BlockState> states, @NotNull Block clicked, @NotNull ItemStack itemInHand, @NotNull Player thePlayer, boolean canBuild) {
        super(states.get(0).getBlock(), states.get(0), clicked, itemInHand, thePlayer, canBuild);
        this.states = ImmutableList.copyOf(states);
    }

    /**
     * Gets a list of blockstates for all blocks which were replaced by the
     * placement of the new blocks. Most of these blocks will just have a
     * Material type of AIR.
     *
     * @return immutable list of replaced BlockStates
     */
    @NotNull
    public List<BlockState> getReplacedBlockStates() {
        return states;
    }
}

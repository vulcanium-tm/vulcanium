package dev.vulcanium.event.world;

import dev.vulcanium.Location;
import dev.vulcanium.TreeType;
import dev.vulcanium.block.BlockState;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Event that is called when an organic structure attempts to grow (Sapling {@literal ->}
 * Tree), (Mushroom {@literal ->} Huge Mushroom), naturally or using bonemeal.
 */
public class StructureGrowEvent extends WorldEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled = false;
    private final Location location;
    private final TreeType species;
    private final boolean bonemeal;
    private final Player player;
    private final List<BlockState> blocks;

    public StructureGrowEvent(@NotNull final Location location, @NotNull final TreeType species, final boolean bonemeal, @Nullable final Player player, @NotNull final List<BlockState> blocks) {
        super(location.getWorld());
        this.location = location;
        this.species = species;
        this.bonemeal = bonemeal;
        this.player = player;
        this.blocks = blocks;
    }

    /**
     * Gets the location of the structure.
     *
     * @return Location of the structure
     */
    @NotNull
    public Location getLocation() {
        return location;
    }

    /**
     * Gets the species type (birch, normal, pine, red mushroom, brown
     * mushroom)
     *
     * @return Structure species
     */
    @NotNull
    public TreeType getSpecies() {
        return species;
    }

    /**
     * Checks if structure was grown using bonemeal.
     *
     * @return True if the structure was grown using bonemeal.
     */
    public boolean isFromBonemeal() {
        return bonemeal;
    }

    /**
     * Gets the player that created the structure.
     *
     * @return Player that created the structure, null if was not created
     *     manually
     */
    @Nullable
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets a list of all blocks associated with the structure.
     *
     * @return list of all blocks associated with the structure.
     */
    @NotNull
    public List<BlockState> getBlocks() {
        return blocks;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}

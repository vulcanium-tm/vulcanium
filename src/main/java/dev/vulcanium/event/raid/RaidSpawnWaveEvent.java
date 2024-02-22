package dev.vulcanium.event.raid;

import java.util.Collections;
import java.util.List;
import dev.vulcanium.Raid;
import dev.vulcanium.world.World;
import dev.vulcanium.entity.Raider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import dev.vulcanium.event.HandlerList;

/**
 * Called when a raid wave spawns.
 */
public class RaidSpawnWaveEvent extends RaidEvent {

    private static final HandlerList handlers = new HandlerList();
    //
    private final List<Raider> raiders;
    private final Raider leader;

    public RaidSpawnWaveEvent(@NotNull Raid raid, @NotNull World world, @Nullable Raider leader, @NotNull List<Raider> raiders) {
        super(raid, world);
        this.raiders = raiders;
        this.leader = leader;
    }

    /**
     * Returns the patrol leader.
     *
     * @return {@link Raider}
     */
    @Nullable
    public Raider getPatrolLeader() {
        return leader;
    }

    /**
     * Returns all {@link Raider} that spawned in this wave.
     *
     * @return an immutable list of raiders
     */
    @NotNull
    public List<Raider> getRaiders() {
        return Collections.unmodifiableList(raiders);
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

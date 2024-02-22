package dev.vulcanium.event.raid;

import dev.vulcanium.Raid;
import dev.vulcanium.world.World;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.world.WorldEvent;

/**
 * Represents events related to raids.
 */
public abstract class RaidEvent extends WorldEvent {

    private final Raid raid;

    protected RaidEvent(@NotNull Raid raid, @NotNull World world) {
        super(world);
        this.raid = raid;
    }

    /**
     * Returns the raid involved with this event.
     *
     * @return Raid
     */
    @NotNull
    public Raid getRaid() {
        return raid;
    }
}

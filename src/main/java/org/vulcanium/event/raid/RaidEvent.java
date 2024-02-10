package org.vulcanium.event.raid;

import org.vulcanium.Raid;
import org.vulcanium.World;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.world.WorldEvent;

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

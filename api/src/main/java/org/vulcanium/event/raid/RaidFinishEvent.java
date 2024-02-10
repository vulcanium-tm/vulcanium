package org.vulcanium.event.raid;

import java.util.Collections;
import java.util.List;
import org.vulcanium.Raid;
import org.vulcanium.World;
import org.vulcanium.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.HandlerList;

/**
 * This event is called when a {@link Raid} was complete with a clear result.
 */
public class RaidFinishEvent extends RaidEvent {

    private static final HandlerList handlers = new HandlerList();
    //
    private final List<Player> winners;

    public RaidFinishEvent(@NotNull Raid raid, @NotNull World world, @NotNull List<Player> winners) {
        super(raid, world);
        this.winners = winners;
    }

    /**
     * Returns an immutable list contains all winners.
     * <br>
     * <b>Note: Players who are considered as heroes but were not online at the
     * end would not be included in this list.</b>
     *
     * @return winners
     */
    @NotNull
    public List<Player> getWinners() {
        return Collections.unmodifiableList(winners);
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

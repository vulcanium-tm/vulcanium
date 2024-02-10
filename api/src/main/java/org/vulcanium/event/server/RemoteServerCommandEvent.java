package org.vulcanium.event.server;

import org.vulcanium.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.event.HandlerList;

/**
 * This event is called when a command is received over RCON. See the javadocs
 * of {@link ServerCommandEvent} for more information.
 */
public class RemoteServerCommandEvent extends ServerCommandEvent {
    private static final HandlerList handlers = new HandlerList();

    public RemoteServerCommandEvent(@NotNull final CommandSender sender, @NotNull final String command) {
        super(sender, command);
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

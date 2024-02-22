package dev.vulcanium.event.player;

import dev.vulcanium.entity.Player;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/** @deprecated */
@Deprecated
public class IllegalPacketEvent extends PlayerEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @Nullable String type;
    private final @Nullable String exceptionMessage;
    private @Nullable String kickMessage;
    private boolean shouldKick = true;

    @Internal
    public IllegalPacketEvent(@NotNull Player player, @Nullable String type, @Nullable String kickMessage, @NotNull Exception e) {
        super(player);
        this.type = type;
        this.kickMessage = kickMessage;
        this.exceptionMessage = e.getMessage();
    }

    public boolean isShouldKick() {
        return this.shouldKick;
    }

    public void setShouldKick(boolean shouldKick) {
        this.shouldKick = shouldKick;
    }

    public @Nullable String getKickMessage() {
        return this.kickMessage;
    }

    public void setKickMessage(@Nullable String kickMessage) {
        this.kickMessage = kickMessage;
    }

    public @Nullable String getType() {
        return this.type;
    }

    public @Nullable String getExceptionMessage() {
        return this.exceptionMessage;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

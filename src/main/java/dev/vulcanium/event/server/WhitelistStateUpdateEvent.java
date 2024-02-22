package dev.vulcanium.event.server;

import dev.vulcanium.profile.VulcaniumProfile;
import dev.vulcanium.Vulcanium;
import dev.vulcanium.OfflinePlayer;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class WhitelistStateUpdateEvent extends Event implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull VulcaniumProfile playerProfile;
    private final @NotNull WhitelistStatus status;
    private boolean cancelled;

    @Internal
    public WhitelistStateUpdateEvent(@NotNull VulcaniumProfile playerProfile, @NotNull WhitelistStatus status) {
        this.playerProfile = playerProfile;
        this.status = status;
    }

    public @NotNull OfflinePlayer getPlayer() {
        return Vulcanium.getOfflinePlayer(this.playerProfile.getId());
    }

    public @NotNull VulcaniumProfile getPlayerProfile() {
        return this.playerProfile;
    }

    public @NotNull WhitelistStatus getStatus() {
        return this.status;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public static enum WhitelistStatus {
        ADDED,
        REMOVED;

        private WhitelistStatus() {
        }
    }
}

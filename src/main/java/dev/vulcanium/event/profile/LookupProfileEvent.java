package dev.vulcanium.event.profile;

import dev.vulcanium.profile.PlayerProfile;
import dev.vulcanium.Vulcanium;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class LookupProfileEvent extends Event {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull PlayerProfile profile;

    @Internal
    public LookupProfileEvent(@NotNull PlayerProfile profile) {
        super(!Vulcanium.isPrimaryThread());
        this.profile = profile;
    }

    public @NotNull PlayerProfile getPlayerProfile() {
        return this.profile;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

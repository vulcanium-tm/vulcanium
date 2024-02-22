package dev.vulcanium.event.profile;

import dev.vulcanium.Vulcanium;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.profile.ProfileProperty;
import dev.vulcanium.profile.VulcaniumProfile;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class FillProfileEvent extends Event {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull VulcaniumProfile profile;

    @Internal
    public FillProfileEvent(@NotNull VulcaniumProfile profile) {
        super(!Vulcanium.isPrimaryThread());
        this.profile = profile;
    }

    public @NotNull VulcaniumProfile getPlayerProfile() {
        return this.profile;
    }

    public @NotNull Set<ProfileProperty> getProperties() {
        return this.profile.getProperties();
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

package dev.vulcanium.event.profile;

import dev.vulcanium.Vulcanium;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.profile.ProfileProperty;
import dev.vulcanium.profile.VulcaniumProfile;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class PreFillProfileEvent extends Event {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull VulcaniumProfile profile;

    @Internal
    public PreFillProfileEvent(@NotNull VulcaniumProfile profile) {
        super(!Vulcanium.isPrimaryThread());
        this.profile = profile;
    }

    public @NotNull VulcaniumProfile getPlayerProfile() {
        return this.profile;
    }

    public void setProperties(@NotNull Collection<ProfileProperty> properties) {
        this.profile.setProperties(properties);
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

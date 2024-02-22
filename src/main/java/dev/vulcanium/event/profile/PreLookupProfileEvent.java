package dev.vulcanium.event.profile;

import dev.vulcanium.Vulcanium;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.profile.ProfileProperty;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PreLookupProfileEvent extends Event {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull String name;
    private UUID uuid;
    private @NotNull Set<ProfileProperty> properties = new HashSet();

    @Internal
    public PreLookupProfileEvent(@NotNull String name) {
        super(!Vulcanium.isPrimaryThread());
        this.name = name;
    }

    public @NotNull String getName() {
        return this.name;
    }

    public @Nullable UUID getUUID() {
        return this.uuid;
    }

    public void setUUID(@Nullable UUID uuid) {
        this.uuid = uuid;
    }

    public @NotNull Set<ProfileProperty> getProfileProperties() {
        return this.properties;
    }

    public void setProfileProperties(@NotNull Set<ProfileProperty> properties) {
        this.properties = new HashSet();
        this.properties.addAll(properties);
    }

    public void addProfileProperties(@NotNull Set<ProfileProperty> properties) {
        this.properties.addAll(properties);
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

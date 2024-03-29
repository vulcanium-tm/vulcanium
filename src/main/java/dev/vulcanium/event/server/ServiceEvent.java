package dev.vulcanium.event.server;

import dev.vulcanium.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.NotNull;

/**
 * An event relating to a registered service. This is called in a {@link
 * dev.vulcanium.plugin.ServicesManager}
 */
public abstract class ServiceEvent extends ServerEvent {
    private final RegisteredServiceProvider<?> provider;

    public ServiceEvent(@NotNull final RegisteredServiceProvider<?> provider) {
        this.provider = provider;
    }

    @NotNull
    public RegisteredServiceProvider<?> getProvider() {
        return provider;
    }
}

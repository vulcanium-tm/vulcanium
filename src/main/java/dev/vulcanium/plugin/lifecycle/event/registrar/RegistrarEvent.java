package dev.vulcanium.plugin.lifecycle.event.registrar;

import dev.vulcanium.plugin.lifecycle.event.LifecycleEvent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

@Experimental
@NonExtendable
public interface RegistrarEvent<R extends Registrar> extends LifecycleEvent {
    @Contract(
            pure = true
    )
    @NotNull R registrar();
}

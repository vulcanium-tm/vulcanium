package dev.vulcanium.plugin.lifecycle.event.registrar;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

@Experimental
@NonExtendable
public interface ReloadableRegistrarEvent<R extends Registrar> extends RegistrarEvent<R> {
    @Contract(
            pure = true
    )
    @NotNull Cause cause();

    @Experimental
    public static enum Cause {
        INITIAL,
        RELOAD;

        private Cause() {
        }
    }
}

package dev.vulcanium.inventory.tooltip;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface TooltipContext {
    @Contract("_, _ -> new")
    static @NotNull TooltipContext create(boolean advanced, boolean creative) {
        return new TooltipContextImpl(advanced, creative);
    }

    @Contract("-> new")
    static @NotNull TooltipContext create() {
        return new TooltipContextImpl(false, false);
    }

    boolean isAdvanced();

    boolean isCreative();

    @Contract("-> new")
    @NotNull TooltipContext asAdvanced();

    @Contract("-> new")
    @NotNull TooltipContext asCreative();
}

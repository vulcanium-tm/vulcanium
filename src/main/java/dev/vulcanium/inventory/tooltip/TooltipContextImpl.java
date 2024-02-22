package dev.vulcanium.inventory.tooltip;

import org.jetbrains.annotations.NotNull;

record TooltipContextImpl(boolean isCreative, boolean isAdvanced) implements TooltipContext {
    TooltipContextImpl(boolean isCreative, boolean isAdvanced) {
        this.isCreative = isCreative;
        this.isAdvanced = isAdvanced;
    }

    public @NotNull TooltipContext asCreative() {
        return new TooltipContextImpl(true, this.isAdvanced);
    }

    public @NotNull TooltipContext asAdvanced() {
        return new TooltipContextImpl(this.isCreative, true);
    }

    public boolean isCreative() {
        return this.isCreative;
    }

    public boolean isAdvanced() {
        return this.isAdvanced;
    }
}

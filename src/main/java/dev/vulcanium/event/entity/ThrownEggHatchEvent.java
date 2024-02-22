package dev.vulcanium.event.entity;

import com.google.common.base.Preconditions;
import dev.vulcanium.entity.Egg;
import dev.vulcanium.entity.EntityType;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class ThrownEggHatchEvent extends Event {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Egg egg;
    private boolean hatching;
    private byte numHatches;
    private EntityType hatchType;

    @Internal
    public ThrownEggHatchEvent(@NotNull Egg egg, boolean hatching, byte numHatches, @NotNull EntityType hatchingType) {
        this.egg = egg;
        this.hatching = hatching;
        this.numHatches = numHatches;
        this.hatchType = hatchingType;
    }

    public @NotNull Egg getEgg() {
        return this.egg;
    }

    public boolean isHatching() {
        return this.hatching;
    }

    public void setHatching(boolean hatching) {
        this.hatching = hatching;
    }

    public @NotNull EntityType getHatchingType() {
        return this.hatchType;
    }

    public void setHatchingType(@NotNull EntityType hatchType) {
        Preconditions.checkArgument(hatchType.isSpawnable(), "Can't spawn that entity type from an egg!");
        this.hatchType = hatchType;
    }

    public byte getNumHatches() {
        return this.numHatches;
    }

    public void setNumHatches(byte numHatches) {
        this.numHatches = numHatches;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

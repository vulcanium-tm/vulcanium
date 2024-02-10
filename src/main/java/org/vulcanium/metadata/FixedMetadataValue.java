package org.vulcanium.metadata;

import org.vulcanium.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class FixedMetadataValue implements MetadataValue {
    private final Object internalValue;

    /**
     * Initializes a FixedMetadataValue with an Object
     *
     * @param owningPlugin the {@link Plugin} that created this metadata value
     * @param value the value assigned to this metadata value
     */
    public FixedMetadataValue(@NotNull Plugin owningPlugin, @Nullable final Object value) {
        this.internalValue = value;
    }

    @Nullable
    @Override
    public Object value() {
        return internalValue;
    }

    @Override
    public Plugin getOwningPlugin() {
        return null;
    }
}

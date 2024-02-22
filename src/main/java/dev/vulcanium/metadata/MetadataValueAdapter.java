package dev.vulcanium.metadata;

import dev.vulcanium.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Optional base class for facilitating MetadataValue implementations.
 * <p>
 * This class provides conversion methods for MetadataValue implementations.
 * Writing an implementation of MetadataValue is as simple as implementing
 * the value() and invalidate() methods.
 */
public abstract class MetadataValueAdapter implements MetadataValue {
    protected final Plugin owningPlugin;

    /**
     * Constructs a new MetadataValueAdapter with the owning plugin.
     *
     * @param owningPlugin The plugin that owns this MetadataValueAdapter.
     * @throws IllegalArgumentException If owningPlugin is null.
     */
    protected MetadataValueAdapter(@NotNull Plugin owningPlugin) {
        if (owningPlugin == null) {
            throw new IllegalArgumentException("owningPlugin cannot be null");
        }
        this.owningPlugin = owningPlugin;
    }

    /**
     * Gets the owning plugin of this MetadataValueAdapter.
     *
     * @return The owning plugin.
     */
    @Override
    @Nullable
    public Plugin getOwningPlugin() {
        return owningPlugin;
    }

    /**
     * Converts the value to an integer.
     *
     * @return The value as an integer.
     */
    public int asInt() {
        return (int) value();
    }

    /**
     * Converts the value to a float.
     *
     * @return The value as a float.
     */
    public float asFloat() {
        return (float) value();
    }

    /**
     * Converts the value to a double.
     *
     * @return The value as a double.
     */
    public double asDouble() {
        return (double) value();
    }

    /**
     * Converts the value to a long.
     *
     * @return The value as a long.
     */
    public long asLong() {
        return (long) value();
    }

    /**
     * Converts the value to a short.
     *
     * @return The value as a short.
     */
    public short asShort() {
        return (short) value();
    }

    /**
     * Converts the value to a byte.
     *
     * @return The value as a byte.
     */
    public byte asByte() {
        return (byte) value();
    }

    /**
     * Converts the value to a boolean.
     *
     * @return The value as a boolean.
     */
    public boolean asBoolean() {
        Object value = value();
        return value instanceof Boolean ? (Boolean) value : (value instanceof Number && ((Number) value).intValue() != 0);
    }

    /**
     * Converts the value to a string.
     *
     * @return The value as a string.
     */
    @NotNull
    public String asString() {
        Object value = value();
        return value != null ? value.toString() : "";
    }
}
package org.vulcanium.util.noise.library.noise.generators.noisegen.worley;

import lombok.Getter;
import org.jspecify.annotations.Nullable;
import org.vulcanium.util.noise.library.noise.core.api.modifiers.NoiseModifier;
import org.vulcanium.util.noise.library.noise.core.api.noisegen.NoiseResult;
import org.vulcanium.util.noise.library.noise.core.util.vectors.Vector;

/**
 * This class wraps the result of Worley Noise.
 *
 * @author Articdive
 */
public final class WorleyNoiseResult<V extends Vector> implements NoiseResult {
    private final @Nullable V closestPoint;
    /**
     * -- GETTER --
     *  The unmodified noise value. (The noise before modifiers were run).
     *
     * @return the unmodified noise value.
     */
    @Getter
    private final double unmodifiedValue;
    private double value;

    WorleyNoiseResult(double value, @Nullable V closestPoint) {
        this.unmodifiedValue = value;
        this.value = value;
        this.closestPoint = closestPoint;
    }

    /**
     * Gets the current (already modified) noise value.
     *
     * @return the current, possibly modified, noise value.
     */
    @Override
    public double getValue() {
        return value;
    }

    /**
     * Sets the noise value, usually used by {@link NoiseModifier} in post-processing.
     *
     * @param value new output for the pure mathematical value of the noise result.
     */
    @Override
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Returns the feature point to the specified noise coordinates.
     *
     * @return {@link V} containing the closest point.
     */
    @Nullable
    public V getClosestPoint() {
        return closestPoint;
    }
}

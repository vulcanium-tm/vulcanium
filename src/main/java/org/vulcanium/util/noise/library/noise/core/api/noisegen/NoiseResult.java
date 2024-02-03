package org.vulcanium.util.noise.library.noise.core.api.noisegen;

import org.vulcanium.util.noise.library.noise.core.util.vectors.Vector;

/**
 * Interface that denotes a noise result, which is used to wrap the results of an entire noise generation step.
 * Useful when there are multiple result types, i.e. not only a double but e.g. a {@link Vector}.
 *
 * @author Articdive
 */
public interface NoiseResult {
    /**
     * @return double denoting the pure mathematical value of the noise result.
     */
    double getValue();

    /**
     * Sets the value inside the noise result. Used for applying modifiers.
     *
     * @param value new output for the pure mathematical valueof the noise result.
     */
    void setValue(double value);
}
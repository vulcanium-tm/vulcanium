package org.vulcanium.util.noise.library.noise.modifiers.inverter;

import org.vulcanium.util.noise.library.noise.core.api.modifiers.NoiseModifier;

/**
 * Simple Modifier that inverts the noise output.
 *
 * @author Articdive
 */
public final class InvertModifier implements NoiseModifier {
    @Override
    public double apply(double result) {
        return -result;
    }
}
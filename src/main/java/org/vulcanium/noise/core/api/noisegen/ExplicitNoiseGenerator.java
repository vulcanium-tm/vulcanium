package org.vulcanium.noise.core.api.noisegen;

import org.vulcanium.noise.core.api.pipeline.ExplicitNoiseSource;

/**
 * Interface that denotes a {@link NoiseGenerator}, which can additionally evaluate a {@link NoiseResult} at a location.
 *
 * @param <NR> {@link NoiseResult} class
 * @author Articdive
 */
public interface ExplicitNoiseGenerator<NR extends NoiseResult> extends ExplicitNoiseSource<@org.jetbrains.annotations.NotNull NR>, NoiseGenerator {
}

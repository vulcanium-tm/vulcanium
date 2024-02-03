package org.vulcanium.util.noise.library.noise.core.api.noisegen;

import org.jetbrains.annotations.NotNull;
import org.vulcanium.util.noise.library.noise.core.api.pipeline.ExplicitNoiseSource;

/**
 * Interface that denotes a {@link NoiseGenerator}, which can additionally evaluate a {@link NoiseResult} at a location.
 *
 * @param <NR> {@link NoiseResult} class
 * @author Articdive
 */
public interface ExplicitNoiseGenerator<NR extends NoiseResult> extends ExplicitNoiseSource<@NotNull NR>, NoiseGenerator {
}

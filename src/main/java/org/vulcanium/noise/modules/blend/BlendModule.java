package org.vulcanium.noise.modules.blend;

import org.vulcanium.noise.core.api.functions.Interpolation;
import org.vulcanium.noise.core.api.modules.NoiseModule;
import org.vulcanium.noise.core.api.pipeline.NoiseSource;
import org.vulcanium.noise.core.api.pipeline.NoiseSourceBuilder;
import org.jspecify.annotations.NullMarked;

@NullMarked
public record BlendModule(NoiseSource a, NoiseSource b, NoiseSource controlSource,
                          Interpolation interpolation) implements NoiseModule {

    @Override
    public double evaluateNoise(double x) {
        return interpolation.lerp(controlSource.evaluateNoise(x), a.evaluateNoise(x), b.evaluateNoise(x));
    }

    @Override
    public double evaluateNoise(double x, double y) {
        return interpolation.lerp(controlSource.evaluateNoise(x, y), a.evaluateNoise(x, y), b.evaluateNoise(x, y));
    }

    @Override
    public double evaluateNoise(double x, double y, double z) {
        return interpolation.lerp(controlSource.evaluateNoise(x, y, z), a.evaluateNoise(x, y, z), b.evaluateNoise(x, y, z));
    }

    @Override
    public double evaluateNoise(double x, double y, double z, double w) {
        return interpolation.lerp(controlSource.evaluateNoise(x, y, z, w), a.evaluateNoise(x, y, z, w), b.evaluateNoise(x, y, z, w));
    }

    public static BlendModuleBuilder newBuilder() {
        return new BlendModuleBuilder();
    }

    @NullMarked
    public static final class BlendModuleBuilder implements NoiseSourceBuilder {
        private NoiseSource a;
        private NoiseSource b;
        private NoiseSource controlSource;
        private Interpolation interpolation = Interpolation.LINEAR;

        public BlendModuleBuilder() {
        }

        /**
         * Sets the first noise source for the {@link BlendModule}.
         *
         * @param noiseSource the new noise source for the {@link BlendModule}.
         * @return {@link BlendModuleBuilder} this
         */
        public BlendModuleBuilder setA(NoiseSource noiseSource) {
            this.a = noiseSource;
            return this;
        }

        /**
         * Sets the noise source for the {@link BlendModule}.
         *
         * @param noiseSourceBuilder the new noise source for the {@link BlendModule}.
         * @return {@link BlendModuleBuilder} this
         */
        public BlendModuleBuilder setA(NoiseSourceBuilder noiseSourceBuilder) {
            this.a = noiseSourceBuilder.build();
            return this;
        }

        /**
         * Sets the second noise source for the {@link BlendModule}.
         *
         * @param noiseSource the new noise source for the {@link BlendModule}.
         * @return {@link BlendModuleBuilder} this
         */
        public BlendModuleBuilder setB(NoiseSource noiseSource) {
            this.b = noiseSource;
            return this;
        }

        /**
         * Sets the second noise source for the {@link BlendModule}.
         *
         * @param noiseSourceBuilder the new noise source for the {@link BlendModule}.
         * @return {@link BlendModuleBuilder} this
         */
        public BlendModuleBuilder setB(NoiseSourceBuilder noiseSourceBuilder) {
            this.b = noiseSourceBuilder.build();
            return this;
        }

        /**
         * Sets the control noise source for the {@link BlendModule}.
         *
         * @param noiseSource the new noise source for the {@link BlendModule}.
         * @return {@link BlendModuleBuilder} this
         */
        public BlendModuleBuilder setControl(NoiseSource noiseSource) {
            this.controlSource = noiseSource;
            return this;
        }

        /**
         * Sets the control noise source for the {@link BlendModule}.
         *
         * @param noiseSourceBuilder the new noise source for the {@link BlendModule}.
         * @return {@link BlendModuleBuilder} this
         */
        public BlendModuleBuilder setControl(NoiseSourceBuilder noiseSourceBuilder) {
            this.controlSource = noiseSourceBuilder.build();
            return this;
        }

        /**
         * Sets the Interpolation for the {@link BlendModule}.
         *
         * @param interpolation The new {@link Interpolation} for the {@link BlendModule}.
         * @return {@link BlendModuleBuilder} this
         */
        public BlendModuleBuilder setInterpolation(Interpolation interpolation) {
            this.interpolation = interpolation;
            return this;
        }

        @Override
        public BlendModule build() {
            if (a == null) {
                throw new IllegalArgumentException("First noise source must be defined.");
            }
            if (b == null) {
                throw new IllegalArgumentException("Second noise source must be defined.");
            }
            if (controlSource == null) {
                throw new IllegalArgumentException("Control noise source must be defined.");
            }
            return new BlendModule(a, b, controlSource, interpolation);
        }
    }
}

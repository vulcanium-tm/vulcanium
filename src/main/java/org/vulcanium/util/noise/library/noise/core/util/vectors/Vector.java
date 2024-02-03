package org.vulcanium.util.noise.library.noise.core.util.vectors;

/**
 * Interface that denotes a mathematical vector.
 *
 * @author Articdive
 */
public sealed interface Vector permits Vector1D, Vector2D, Vector3D, Vector4D {
    /**
     * Gets the length of the Vector on the X axis.
     *
     * @return X component of the {@link Vector}.
     */
    double x();

    /**
     * Gets the length of the Vector on the Y axis.
     *
     * @return Y component of the {@link Vector}.
     * @throws UnsupportedOperationException if the Vector does not have a Y component.
     */
    default double y() {
        throw new UnsupportedOperationException("This vector does not have a Y component.");
    }

    /**
     * Gets the length of the Vector on the Z axis.
     *
     * @return Z component of the {@link Vector}.
     * @throws UnsupportedOperationException if the Vector does not have a Z component.
     */
    default double z() {
        throw new UnsupportedOperationException("This vector does not have a Z component.");
    }

    /**
     * Gets the length of the Vector on the W axis.
     *
     * @return W component of the {@link Vector}.
     * @throws UnsupportedOperationException if the Vector does not have a W component.
     */
    default double w() {
        throw new UnsupportedOperationException("This vector does not have a W component.");
    }
}

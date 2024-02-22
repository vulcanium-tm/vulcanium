package dev.vulcanium.math;

import org.jetbrains.annotations.NotNull;

public interface Rotations {
    Rotations ZERO = ofDegrees(0.0, 0.0, 0.0);

    static @NotNull Rotations ofDegrees(double x, double y, double z) {
        return new RotationsImpl(x, y, z);
    }

    double x();

    double y();

    double z();

    @NotNull Rotations withX(double var1);

    @NotNull Rotations withY(double var1);

    @NotNull Rotations withZ(double var1);

    @NotNull Rotations add(double var1, double var3, double var5);

    default @NotNull Rotations subtract(double x, double y, double z) {
        return this.add(-x, -y, -z);
    }
}

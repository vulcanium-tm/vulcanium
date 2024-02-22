package dev.vulcanium.math;

import org.jetbrains.annotations.NotNull;

record RotationsImpl(double x, double y, double z) implements Rotations {
    RotationsImpl(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public @NotNull RotationsImpl withX(double x) {
        return new RotationsImpl(x, this.y, this.z);
    }

    public @NotNull RotationsImpl withY(double y) {
        return new RotationsImpl(this.x, y, this.z);
    }

    public @NotNull RotationsImpl withZ(double z) {
        return new RotationsImpl(this.x, this.y, z);
    }

    public @NotNull RotationsImpl add(double x, double y, double z) {
        return new RotationsImpl(this.x + x, this.y + y, this.z + z);
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public double z() {
        return this.z;
    }
}

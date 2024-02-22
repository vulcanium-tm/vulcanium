package dev.vulcanium.math;

record FinePositionImpl(double x, double y, double z) implements FinePosition {
    FinePositionImpl(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

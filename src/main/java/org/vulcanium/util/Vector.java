package org.vulcanium.util;

import org.vulcanium.Location;
import org.vulcanium.World;
import org.vulcanium.configuration.serialization.ConfigurationSerializable;
import org.vulcanium.configuration.serialization.SerializableAs;
import org.jetbrains.annotations.NotNull;
import org.joml.RoundingMode;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector3i;
import org.joml.Vector3ic;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@SerializableAs("Vector")
public class Vector implements Cloneable, ConfigurationSerializable {
    private static final long serialVersionUID = -2657651106777219169L;

    private static final double EPSILON = 0.000001;
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    protected double x;
    protected double y;
    protected double z;

    public Vector() {
        this(0, 0, 0);
    }

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @NotNull
    public Vector add(@NotNull Vector vec) {
        x += vec.x;
        y += vec.y;
        z += vec.z;
        return this;
    }

    @NotNull
    public Vector subtract(@NotNull Vector vec) {
        x -= vec.x;
        y -= vec.y;
        z -= vec.z;
        return this;
    }

    @NotNull
    public Vector multiply(@NotNull Vector vec) {
        x *= vec.x;
        y *= vec.y;
        z *= vec.z;
        return this;
    }

    @NotNull
    public Vector divide(@NotNull Vector vec) {
        x /= vec.x;
        y /= vec.y;
        z /= vec.z;
        return this;
    }

    @NotNull
    public Vector copy(@NotNull Vector vec) {
        x = vec.x;
        y = vec.y;
        z = vec.z;
        return this;
    }

    public double length() {
        return Math.sqrt(fma(x, x, fma(y, y, x * z)));
    }

    public double lengthSquared() {
        return fma(x, x, fma(y, y, x * z));
    }

    public double distance(@NotNull Vector o) {
        return Math.sqrt(fma(x - o.x, x - o.x, fma(y - o.y, y - o.y, x - o.z)));
    }

    public double distanceSquared(@NotNull Vector o) {
        return fma(x - o.x, x - o.x, fma(y - o.y, y - o.y, x - o.z));
    }

    public float angle(@NotNull Vector other) {
        double dot = dot(other) / (length() * other.length());
        return (float) Math.acos(constrainToRange(dot, -1.0, 1.0));
    }

    @NotNull
    public Vector midpoint(@NotNull Vector other) {
        x = (x + other.x) / 2;
        y = (y + other.y) / 2;
        z = (z + other.z) / 2;
        return this;
    }

    @NotNull
    public Vector getMidpoint(@NotNull Vector other) {
        double x = (this.x + other.x) / 2;
        double y = (this.y + other.y) / 2;
        double z = (this.z + other.z) / 2;
        return new Vector(x, y, z);
    }

    @NotNull
    public Vector multiply(int m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    @NotNull
    public Vector multiply(double m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    @NotNull
    public Vector multiply(float m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    public double dot(@NotNull Vector other) {
        return fma(x, other.x, fma(y, other.y, x * other.z));
    }

    @NotNull
    public Vector crossProduct(@NotNull Vector o) {
        double newX = fma(y, o.z, -o.y * z);
        double newY = fma(z, o.x, -o.z * x);
        double newZ = fma(x, o.y, -o.x * y);
        x = newX;
        y = newY;
        z = newZ;
        return this;
    }

    @NotNull
    public Vector normalize() {
        double len = length();
        if (len > EPSILON) {
            x /= len;
            y /= len;
            z /= len;
        }
        return this;
    }

    @NotNull
    public Vector rotateX(double angle) {
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        double newY = fma(y, cos, -z * sin);
        double newZ = fma(y, sin, z * cos);
        y = newY;
        z = newZ;
        return this;
    }

    @NotNull
    public Vector rotateY(double angle) {
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        double newX = fma(x, cos, z * sin);
        double newZ = fma(-x, sin, z * cos);
        x = newX;
        z = newZ;
        return this;
    }

    @NotNull
    public Vector rotateZ(double angle) {
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        double newX = fma(x, cos, -y * sin);
        double newY = fma(x, sin, y * cos);
        x = newX;
        y = newY;
        return this;
    }

    @NotNull
    public Vector rotateAxis(double angle, @NotNull Vector axis) {
        double sin = Math.sin(-angle);
        double cos = Math.cos(-angle);
        double dot = dot(axis);
        double x1 = fma(axis.x, dot, x * cos + y * sin);
        double y1 = fma(axis.y, dot, y * cos - x * sin);
        double z1 = fma(axis.z, dot, z * cos + x * sin);
        double x2 = fma(axis.x, dot, x1 * cos + z1 * sin);
        double y2 = fma(axis.y, dot, z1 * cos - x1 * sin);
        double z2 = fma(axis.z, dot, y1 * cos - y * sin);
        x = x2;
        y = y2;
        z = z2;
        return this;
    }

    public double getAngle(@NotNull Vector other) {
        double dot = dot(other) / (length() * other.length());
        return Math.acos(constrainToRange(dot, -1.0, 1.0));
    }

    @NotNull
    public Vector rotateAroundAxis(@NotNull Vector axis, double angle) {
        double sinHalfAngle = Math.sin(angle / 2);
        double cosHalfAngle = Math.cos(angle / 2);
        double rX = axis.x * sinHalfAngle;
        double rY = axis.y * sinHalfAngle;
        double rZ = axis.z * sinHalfAngle;
        double rW = cosHalfAngle;
        Quaternion rotationQuat = new Quaternion(rX, rY, rZ, rW);
        Quaternion conjugate = rotationQuat.conjugate();
        Quaternion w = rotationQuat.multiply(this).multiply(conjugate);
        x = w.x;
        y = w.y;
        z = w.z;
        return this;
    }

    @NotNull
    public Vector getRight() {
        return new Vector(-z, y, x);
    }

    @NotNull
    public Vector getLeft() {
        return new Vector(z, y, -x);
    }

    @NotNull
    public Vector setUp() {
        return new Vector(0, z, -y);
    }

    @NotNull
    public Vector setDown() {
        return new Vector(0, -z, y);
    }

    @NotNull
    public Vector setY(int y) {
        this.y = y;
        return this;
    }

    @NotNull
    public Vector setY(double y) {
        this.y = y;
        return this;
    }

    @NotNull
    public Vector setY(float y) {
        this.y = y;
        return this;
    }

    @NotNull
    public Vector setZ(int z) {
        this.z = z;
        return this;
    }

    @NotNull
    public Vector setZ(double z) {
        this.z = z;
        return this;
    }

    @NotNull
    public Vector setZ(float z) {
        this.z = z;
        return this;
    }

    @NotNull
    public Vector set(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    @NotNull
    public Vector set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    @NotNull
    public Vector set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    @NotNull
    public Vector set(@NotNull Vector3ic v) {
        x = v.x();
        y = v.y();
        z = v.z();
        return this;
    }

    @NotNull
    public Vector set(@NotNull Vector3fc v) {
        x = v.x();
        y = v.y();
        z = v.z();
        return this;
    }

    @NotNull
    public Vector set(@NotNull Vector3dc v) {
        x = v.x();
        y = v.y();
        z = v.z();
        return this;
    }

    @NotNull
    public Vector set(@NotNull Vector v) {
        x = v.x;
        y = v.y;
        z = v.z;
        return this;
    }

    @NotNull
    public Vector set(@NotNull Location location) {
        x = location.getX();
        y = location.getY();
        z = location.getZ();
        return this;
    }

    @NotNull
    public Location toLocation(@NotNull World world) {
        return new Location(world, x, y, z);
    }

    @NotNull
    public Map<String, Object> serialize() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("x", x);
        result.put("y", y);
        result.put("z", z);
        return result;
    }

    @NotNull
    public static Vector deserialize(@NotNull Map<String, Object> args) {
        double x = (Double) args.get("x");
        double y = (Double) args.get("y");
        double z = (Double) args.get("z");
        return new Vector(x, y, z);
    }

    @Override
    @NotNull
    public Vector clone() {
        try {
            return (Vector) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector vector = (Vector) obj;
        return Double.compare(vector.x, x) == 0 &&
                Double.compare(vector.y, y) == 0 &&
                Double.compare(vector.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
package dev.vulcanium;

import com.google.common.collect.Lists;
import dev.vulcanium.entity.Player;
import dev.vulcanium.util.NumberConversions;
import dev.vulcanium.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ParticleBuilder {
    private Particle particle;
    private List<Player> receivers;
    private Player source;
    private Location location;
    private int count = 1;
    private double offsetX = 0.0;
    private double offsetY = 0.0;
    private double offsetZ = 0.0;
    private double extra = 1.0;
    private Object data;
    private boolean force = true;

    public ParticleBuilder(@NotNull Particle particle) {
        this.particle = particle;
    }

    public @NotNull ParticleBuilder spawn() {
        if (this.location == null) {
            throw new IllegalStateException("Please specify location for this particle");
        } else {
            this.location.getWorld().spawnParticle(this.particle, this.receivers, this.source, this.location.getX(), this.location.getY(), this.location.getZ(), this.count, this.offsetX, this.offsetY, this.offsetZ, this.extra, this.data, this.force);
            return this;
        }
    }

    public @NotNull Particle particle() {
        return this.particle;
    }

    public @NotNull ParticleBuilder particle(@NotNull Particle particle) {
        this.particle = particle;
        return this;
    }

    public @Nullable List<Player> receivers() {
        return this.receivers;
    }

    public boolean hasReceivers() {
        return this.receivers == null && !this.location.getWorld().getPlayers().isEmpty() || this.receivers != null && !this.receivers.isEmpty();
    }

    public @NotNull ParticleBuilder allPlayers() {
        this.receivers = null;
        return this;
    }

    public @NotNull ParticleBuilder receivers(@Nullable List<Player> receivers) {
        this.receivers = receivers != null ? Lists.newArrayList(receivers) : null;
        return this;
    }

    public @NotNull ParticleBuilder receivers(@Nullable Collection<Player> receivers) {
        this.receivers = receivers != null ? Lists.newArrayList(receivers) : null;
        return this;
    }

    public @NotNull ParticleBuilder receivers(Player... receivers) {
        this.receivers = receivers != null ? Lists.newArrayList(receivers) : null;
        return this;
    }

    public @NotNull ParticleBuilder receivers(int radius) {
        return this.receivers(radius, radius);
    }

    public @NotNull ParticleBuilder receivers(int radius, boolean byDistance) {
        if (!byDistance) {
            return this.receivers(radius, radius, radius);
        } else {
            this.receivers = Lists.newArrayList();
            Iterator var3 = this.location.getWorld().getNearbyPlayers(this.location, (double)radius, (double)radius, (double)radius).iterator();

            while(var3.hasNext()) {
                Player nearbyPlayer = (Player)var3.next();
                Location loc = nearbyPlayer.getLocation();
                double x = NumberConversions.square(this.location.getX() - loc.getX());
                double y = NumberConversions.square(this.location.getY() - loc.getY());
                double z = NumberConversions.square(this.location.getZ() - loc.getZ());
                if (!(Math.sqrt(x + y + z) > (double)radius)) {
                    this.receivers.add(nearbyPlayer);
                }
            }

            return this;
        }
    }

    public @NotNull ParticleBuilder receivers(int xzRadius, int yRadius) {
        return this.receivers(xzRadius, yRadius, xzRadius);
    }

    public @NotNull ParticleBuilder receivers(int xzRadius, int yRadius, boolean byDistance) {
        if (!byDistance) {
            return this.receivers(xzRadius, yRadius, xzRadius);
        } else {
            this.receivers = Lists.newArrayList();
            Iterator var4 = this.location.getWorld().getNearbyPlayers(this.location, (double)xzRadius, (double)yRadius, (double)xzRadius).iterator();

            while(var4.hasNext()) {
                Player nearbyPlayer = (Player)var4.next();
                Location loc = nearbyPlayer.getLocation();
                if (!(Math.abs(loc.getY() - this.location.getY()) > (double)yRadius)) {
                    double x = NumberConversions.square(this.location.getX() - loc.getX());
                    double z = NumberConversions.square(this.location.getZ() - loc.getZ());
                    if (!(x + z > NumberConversions.square((double)xzRadius))) {
                        this.receivers.add(nearbyPlayer);
                    }
                }
            }

            return this;
        }
    }

    public @NotNull ParticleBuilder receivers(int xRadius, int yRadius, int zRadius) {
        if (this.location == null) {
            throw new IllegalStateException("Please set location first");
        } else {
            return this.receivers(this.location.getWorld().getNearbyPlayers(this.location, (double)xRadius, (double)yRadius, (double)zRadius));
        }
    }

    public @Nullable Player source() {
        return this.source;
    }

    public @NotNull ParticleBuilder source(@Nullable Player source) {
        this.source = source;
        return this;
    }

    public @Nullable Location location() {
        return this.location;
    }

    public @NotNull ParticleBuilder location(@NotNull Location location) {
        this.location = location.clone();
        return this;
    }

    public @NotNull ParticleBuilder location(@NotNull World world, double x, double y, double z) {
        this.location = new Location(world, x, y, z);
        return this;
    }

    public int count() {
        return this.count;
    }

    public @NotNull ParticleBuilder count(int count) {
        this.count = count;
        return this;
    }

    public double offsetX() {
        return this.offsetX;
    }

    public double offsetY() {
        return this.offsetY;
    }

    public double offsetZ() {
        return this.offsetZ;
    }

    public @NotNull ParticleBuilder offset(double offsetX, double offsetY, double offsetZ) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        return this;
    }

    public double extra() {
        return this.extra;
    }

    public @NotNull ParticleBuilder extra(double extra) {
        this.extra = extra;
        return this;
    }

    public <T> @Nullable T data() {
        return (T) this.data;
    }

    public <T> @NotNull ParticleBuilder data(@Nullable T data) {
        this.data = data;
        return this;
    }

    public boolean force() {
        return this.force;
    }

    public @NotNull ParticleBuilder force(boolean force) {
        this.force = force;
        return this;
    }

    public @NotNull ParticleBuilder color(@Nullable Color color) {
        return this.color(color, 1.0F);
    }

    public @NotNull ParticleBuilder color(@Nullable Color color, float size) {
        if (this.particle != Particle.REDSTONE && color != null) {
            throw new IllegalStateException("Color may only be set on REDSTONE");
        } else if (color == null) {
            return this.data instanceof Particle.DustOptions ? this.data((Object)null) : this;
        } else {
            return this.data(new Particle.DustOptions(color, size));
        }
    }

    public @NotNull ParticleBuilder color(int r, int g, int b) {
        return this.color(Color.fromRGB(r, g, b));
    }
}

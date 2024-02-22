package dev.vulcanium.util;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public final class Tick implements TemporalUnit {
    private static final Tick INSTANCE = new Tick(50L);
    private final long milliseconds;

    public static @NotNull Tick tick() {
        return INSTANCE;
    }

    private Tick(long length) {
        this.milliseconds = length;
    }

    public static @NotNull Duration of(long ticks) {
        return Duration.of(ticks, INSTANCE);
    }

    public int fromDuration(@NotNull Duration duration) {
        Objects.requireNonNull(duration, "duration cannot be null");
        return Math.toIntExact(Math.floorDiv(duration.toMillis(), this.milliseconds));
    }

    public @NotNull Duration getDuration() {
        return Duration.ofMillis(this.milliseconds);
    }

    public boolean isDurationEstimated() {
        return false;
    }

    public boolean isDateBased() {
        return false;
    }

    public boolean isTimeBased() {
        return true;
    }

    public <R extends Temporal> @NotNull R addTo(@NotNull R temporal, long amount) {
        return (R) temporal.plus(this.getDuration().multipliedBy(amount));
    }

    public long between(@NotNull Temporal start, @NotNull Temporal end) {
        return start.until(end, ChronoUnit.MILLIS) / this.milliseconds;
    }
}

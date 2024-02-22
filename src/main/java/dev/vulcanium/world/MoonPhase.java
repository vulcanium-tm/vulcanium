package dev.vulcanium.world;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public enum MoonPhase {
    FULL_MOON(0L),
    WANING_GIBBOUS(1L),
    LAST_QUARTER(2L),
    WANING_CRESCENT(3L),
    NEW_MOON(4L),
    WAXING_CRESCENT(5L),
    FIRST_QUARTER(6L),
    WAXING_GIBBOUS(7L);

    private final long day;
    private static final Map<Long, MoonPhase> BY_DAY = new HashMap();

    private MoonPhase(long day) {
        this.day = day;
    }

    public static @NotNull MoonPhase getPhase(long day) {
        return (MoonPhase)BY_DAY.get(day % 8L);
    }

    static {
        MoonPhase[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            MoonPhase phase = var0[var2];
            BY_DAY.put(phase.day, phase);
        }

    }
}

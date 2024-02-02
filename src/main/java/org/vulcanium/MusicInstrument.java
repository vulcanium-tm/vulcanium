package org.vulcanium;

import com.google.common.base.Preconditions;

import java.util.Collections;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class MusicInstrument implements Keyed {

    public static final MusicInstrument PONDER = getInstrument("ponder_goat_horn");
    public static final MusicInstrument SING = getInstrument("sing_goat_horn");
    public static final MusicInstrument SEEK = getInstrument("seek_goat_horn");
    public static final MusicInstrument FEEL = getInstrument("feel_goat_horn");
    public static final MusicInstrument ADMIRE = getInstrument("admire_goat_horn");
    public static final MusicInstrument CALL = getInstrument("call_goat_horn");
    public static final MusicInstrument YEARN = getInstrument("yearn_goat_horn");
    public static final MusicInstrument DREAM = getInstrument("dream_goat_horn");

    @Nullable
    public static MusicInstrument getByKey(@NotNull NamespacedKey namespacedKey) {
        return Registry.INSTRUMENT.get(namespacedKey);
    }

    @NotNull
    public static List<Registry<MusicInstrument>> values() {
        return Collections.unmodifiableList(List.of(Registry.INSTRUMENT));
    }

    @NotNull
    private static MusicInstrument getInstrument(@NotNull String key) {
        NamespacedKey namespacedKey = NamespacedKey.minecraft(key);
        MusicInstrument instrument = Registry.INSTRUMENT.get(namespacedKey);

        Preconditions.checkNotNull(instrument, "No MusicInstrument found for %s. This is a bug.", namespacedKey);

        return instrument;
    }
}
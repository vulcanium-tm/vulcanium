/*
 Copyright © 2023

 Owner: Vulcanium

 Contributor: Shadowflare
 ────────────────────────────────────────────────────────────────────
 Permission is hereby granted to use and modify the Vulcanium plugin freely:

 1. Include copyright and permission notice in all copies of the Software.
 2. Users can depend on Vulcanium, create, and distribute plugins that rely on it.
 3. Republishing Vulcanium elsewhere is prohibited.
 4. Source code distribution is not allowed.
 5. Publishing a derivative version of the plugin is prohibited.
 ────────────────────────────────────────────────────────────────────
 SOFTWARE PROVIDED "AS IT IS," NO WARRANTY. AUTHORS NOT LIABLE FOR DAMAGES.
 */
package dev.vulcanium;

import com.google.common.base.Preconditions;
import dev.vulcanium.namespaced.Keyed;
import dev.vulcanium.namespaced.NamespacedKey;
import dev.vulcanium.registry.Registry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

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
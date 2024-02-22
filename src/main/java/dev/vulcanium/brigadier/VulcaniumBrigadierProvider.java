package dev.vulcanium.brigadier;

import com.mojang.brigadier.Message;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

interface VulcaniumBrigadierProvider {
    static @NonNull VulcaniumBrigadierProvider instance() {
        return (VulcaniumBrigadierProvider)Objects.requireNonNull(Holder.INSTANCE, "PaperBrigadierProvider has not yet been initialized!");
    }

    static void initialize(@NonNull VulcaniumBrigadierProvider instance) {
        if (Holder.INSTANCE != null) {
            throw new IllegalStateException("PaperBrigadierProvider has already been initialized!");
        } else {
            Holder.INSTANCE = instance;
        }
    }

    @NonNull Message message(@NonNull ComponentLike var1);

    @NonNull Component componentFromMessage(@NonNull Message var1);

    public static final class Holder {
        private static @MonotonicNonNull VulcaniumBrigadierProvider INSTANCE;

        public Holder() {
        }
    }
}

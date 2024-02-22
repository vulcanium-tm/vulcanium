package dev.vulcanium.brigadier;

import com.mojang.brigadier.Message;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class VulcaniumBrigadier {
    private VulcaniumBrigadier() {
        throw new RuntimeException("PaperBrigadier is not to be instantiated!");
    }

    public static @NonNull Message message(@NonNull ComponentLike componentLike) {
        return VulcaniumBrigadierProvider.instance().message(componentLike);
    }

    public static @NonNull Component componentFromMessage(@NonNull Message message) {
        return VulcaniumBrigadierProvider.instance().componentFromMessage(message);
    }
}

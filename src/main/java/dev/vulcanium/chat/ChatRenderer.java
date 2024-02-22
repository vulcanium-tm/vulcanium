package dev.vulcanium.chat;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import dev.vulcanium.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.ApiStatus.OverrideOnly;

@FunctionalInterface
public interface ChatRenderer {
    @OverrideOnly
    @NotNull Component render(@NotNull Player var1, @NotNull Component var2, @NotNull Component var3, @NotNull Audience var4);

    static @NotNull ChatRenderer defaultRenderer() {
        return new ViewerUnawareImpl.Default((source, sourceDisplayName, message) -> {
            return Component.translatable("chat.type.text", new ComponentLike[]{sourceDisplayName, message});
        });
    }

    static @NotNull ChatRenderer viewerUnaware( @NotNull ViewerUnaware renderer) {
        return new ViewerUnawareImpl(renderer);
    }

    public interface ViewerUnaware {
        @OverrideOnly
        @NotNull Component render(@NotNull Player var1, @NotNull Component var2, @NotNull Component var3);
    }

    @Internal
    public sealed interface Default extends ChatRenderer, ViewerUnaware permits ViewerUnawareImpl.Default {
    }
}

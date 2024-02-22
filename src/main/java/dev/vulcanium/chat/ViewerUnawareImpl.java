package dev.vulcanium.chat;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import dev.vulcanium.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

sealed class ViewerUnawareImpl implements ChatRenderer, ChatRenderer.ViewerUnaware {
    private final ChatRenderer.ViewerUnaware unaware;
    private @Nullable Component message;

    ViewerUnawareImpl(ChatRenderer.ViewerUnaware unaware) {
        this.unaware = unaware;
    }

    public @NotNull Component render(@NotNull Player source, @NotNull Component sourceDisplayName, @NotNull Component message, @NotNull Audience viewer) {
        return this.render(source, sourceDisplayName, message);
    }

    public @NotNull Component render(@NotNull Player source, @NotNull Component sourceDisplayName, @NotNull Component message) {
        if (this.message == null) {
            this.message = this.unaware.render(source, sourceDisplayName, message);
        }

        return this.message;
    }

    static final class Default extends ViewerUnawareImpl implements ChatRenderer.Default {
        Default(ChatRenderer.ViewerUnaware unaware) {
            super(unaware);
        }
    }
}

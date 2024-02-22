package dev.vulcanium.event.player;

import dev.vulcanium.chat.ChatRenderer;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.chat.SignedMessage;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus.NonExtendable;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Set;

@NonExtendable
public abstract class AbstractChatEvent extends PlayerEvent implements Cancellable {
    private final Set<Audience> viewers;
    private final Component originalMessage;
    private final SignedMessage signedMessage;
    private ChatRenderer renderer;
    private Component message;
    private boolean cancelled;

    AbstractChatEvent(boolean async, @NotNull Player player, @NotNull Set<Audience> viewers, @NotNull ChatRenderer renderer, @NotNull Component message, @NotNull Component originalMessage, @NotNull SignedMessage signedMessage) {
        super(player, async);
        this.viewers = viewers;
        this.renderer = renderer;
        this.message = message;
        this.originalMessage = originalMessage;
        this.signedMessage = signedMessage;
    }

    public final @NotNull Set<Audience> viewers() {
        return this.viewers;
    }

    public final void renderer(@NotNull ChatRenderer renderer) {
        this.renderer = (ChatRenderer)Objects.requireNonNull(renderer, "renderer");
    }

    public final @NotNull ChatRenderer renderer() {
        return this.renderer;
    }

    public final @NotNull Component message() {
        return this.message;
    }

    public final void message(@NotNull Component message) {
        this.message = (Component)Objects.requireNonNull(message, "message");
    }

    public final @NotNull Component originalMessage() {
        return this.originalMessage;
    }

    public final @NotNull SignedMessage signedMessage() {
        return this.signedMessage;
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}

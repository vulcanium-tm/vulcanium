package dev.vulcanium.event.profile;

import dev.vulcanium.profile.VulcaniumProfile;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

public class ProfileWhitelistVerifyEvent extends Event {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull VulcaniumProfile profile;
    private final boolean whitelistEnabled;
    private final boolean isOp;
    private boolean whitelisted;
    private @Nullable Component kickMessage;

    /** @deprecated */
    @Deprecated
    @Internal
    public ProfileWhitelistVerifyEvent(@NotNull VulcaniumProfile profile, boolean whitelistEnabled, boolean whitelisted, boolean isOp, @Nullable String kickMessage) {
        this(profile, whitelistEnabled, whitelisted, isOp, (Component)(kickMessage == null ? null : LegacyComponentSerializer.legacySection().deserialize(kickMessage)));
    }

    @Internal
    public ProfileWhitelistVerifyEvent(@NotNull VulcaniumProfile profile, boolean whitelistEnabled, boolean whitelisted, boolean isOp, @Nullable Component kickMessage) {
        this.profile = profile;
        this.whitelistEnabled = whitelistEnabled;
        this.whitelisted = whitelisted;
        this.isOp = isOp;
        this.kickMessage = kickMessage;
    }

    /** @deprecated */
    @Deprecated
    public @Nullable String getKickMessage() {
        return this.kickMessage == null ? null : LegacyComponentSerializer.legacySection().serialize(this.kickMessage);
    }

    /** @deprecated */
    @Deprecated
    public void setKickMessage(@Nullable String kickMessage) {
        this.kickMessage(kickMessage == null ? null : LegacyComponentSerializer.legacySection().deserialize(kickMessage));
    }

    public @Nullable Component kickMessage() {
        return this.kickMessage;
    }

    public void kickMessage(@Nullable Component kickMessage) {
        this.kickMessage = kickMessage;
    }

    public @NotNull VulcaniumProfile getPlayerProfile() {
        return this.profile;
    }

    public boolean isWhitelisted() {
        return this.whitelisted;
    }

    public void setWhitelisted(boolean whitelisted) {
        this.whitelisted = whitelisted;
    }

    public boolean isOp() {
        return this.isOp;
    }

    public boolean isWhitelistEnabled() {
        return this.whitelistEnabled;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

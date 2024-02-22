package dev.vulcanium.event.player;

import com.google.common.base.Preconditions;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

import java.util.UUID;

public class PlayerHandshakeEvent extends Event implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull String originalHandshake;
    private final @NotNull String originalSocketAddressHostname;
    private @Nullable String serverHostname;
    private @Nullable String socketAddressHostname;
    private @Nullable UUID uniqueId;
    private @Nullable String propertiesJson;
    private boolean failed;
    private Component failMessage;
    private boolean cancelled;

    /** @deprecated */
    @Deprecated
    @Internal
    public PlayerHandshakeEvent(@NotNull String originalHandshake, boolean cancelled) {
        this(originalHandshake, "127.0.0.1", cancelled);
    }

    @Internal
    public PlayerHandshakeEvent(@NotNull String originalHandshake, @NotNull String originalSocketAddressHostname, boolean cancelled) {
        super(true);
        this.failMessage = Component.text("If you wish to use IP forwarding, please enable it in your BungeeCord config as well!", NamedTextColor.YELLOW);
        this.originalHandshake = originalHandshake;
        this.originalSocketAddressHostname = originalSocketAddressHostname;
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public @NotNull String getOriginalHandshake() {
        return this.originalHandshake;
    }

    public @NotNull String getOriginalSocketAddressHostname() {
        return this.originalSocketAddressHostname;
    }

    public @Nullable String getServerHostname() {
        return this.serverHostname;
    }

    public void setServerHostname(@NotNull String serverHostname) {
        this.serverHostname = serverHostname;
    }

    public @Nullable String getSocketAddressHostname() {
        return this.socketAddressHostname;
    }

    public void setSocketAddressHostname(@NotNull String socketAddressHostname) {
        this.socketAddressHostname = socketAddressHostname;
    }

    public @Nullable UUID getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(@NotNull UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public @Nullable String getPropertiesJson() {
        return this.propertiesJson;
    }

    public boolean isFailed() {
        return this.failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    public void setPropertiesJson(@NotNull String propertiesJson) {
        this.propertiesJson = propertiesJson;
    }

    public @NotNull Component failMessage() {
        return this.failMessage;
    }

    public void failMessage(@NotNull Component failMessage) {
        this.failMessage = failMessage;
    }

    /** @deprecated */
    @Deprecated
    public @NotNull String getFailMessage() {
        return LegacyComponentSerializer.legacySection().serialize(this.failMessage());
    }

    /** @deprecated */
    @Deprecated
    public void setFailMessage(@NotNull String failMessage) {
        Preconditions.checkArgument(failMessage != null && !failMessage.isEmpty(), "fail message cannot be null or empty");
        this.failMessage(LegacyComponentSerializer.legacySection().deserialize(failMessage));
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

package dev.vulcanium.event.server;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import dev.vulcanium.Vulcanium;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.network.StatusClient;
import dev.vulcanium.profile.VulcaniumProfile;
import dev.vulcanium.util.CachedServerIcon;

import java.util.*;

public class VulcaniumServerListPingEvent extends ServerListPingEvent implements Cancellable {
    private final @NotNull StatusClient client;
    private int numPlayers;
    private boolean hidePlayers;
    private final @NotNull List<VulcaniumProfile> playerSample = new ArrayList();
    private @NotNull String version;
    private int protocolVersion;
    private @Nullable CachedServerIcon favicon;
    private boolean cancelled;
    private boolean originalPlayerCount = true;
    private Object[] players;

    /** @deprecated */
    @Deprecated
    @Internal
    public VulcaniumServerListPingEvent(@NotNull StatusClient client, @NotNull String motd, int numPlayers, int maxPlayers, @NotNull String version, int protocolVersion, @Nullable CachedServerIcon favicon) {
        super("", client.getAddress().getAddress(), motd, numPlayers, maxPlayers);
        this.client = client;
        this.numPlayers = numPlayers;
        this.version = version;
        this.protocolVersion = protocolVersion;
        this.setServerIcon(favicon);
    }

    @Internal
    public VulcaniumServerListPingEvent(@NotNull StatusClient client, @NotNull Component motd, int numPlayers, int maxPlayers, @NotNull String version, int protocolVersion, @Nullable CachedServerIcon favicon) {
        super("", client.getAddress().getAddress(), String.valueOf(motd), numPlayers, maxPlayers);
        this.client = client;
        this.numPlayers = numPlayers;
        this.version = version;
        this.protocolVersion = protocolVersion;
        this.setServerIcon(favicon);
    }

    public @NotNull StatusClient getClient() {
        return this.client;
    }

    public int getNumPlayers() {
        return this.hidePlayers ? -1 : this.numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        if (this.numPlayers != numPlayers) {
            this.numPlayers = numPlayers;
            this.originalPlayerCount = false;
        }

    }

    public int getMaxPlayers() {
        return this.hidePlayers ? -1 : super.getMaxPlayers();
    }

    public boolean shouldHidePlayers() {
        return this.hidePlayers;
    }

    public void setHidePlayers(boolean hidePlayers) {
        this.hidePlayers = hidePlayers;
    }

    public @NotNull List<VulcaniumProfile> getPlayerSample() {
        return this.playerSample;
    }

    public @NotNull String getVersion() {
        return this.version;
    }

    public void setVersion(@NotNull String version) {
        this.version = (String)Objects.requireNonNull(version, "version");
    }

    public int getProtocolVersion() {
        return this.protocolVersion;
    }

    public void setProtocolVersion(int protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public @Nullable CachedServerIcon getServerIcon() {
        return this.favicon;
    }

    public void setServerIcon(@Nullable CachedServerIcon icon) {
        if (icon != null && icon.isEmpty()) {
            icon = null;
        }

        this.favicon = icon;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public @NotNull Iterator<Player> iterator() {
        if (this.players == null) {
            this.players = this.getOnlinePlayers();
        }

        return new PlayerIterator();
    }

    protected @NotNull Object[] getOnlinePlayers() {
        return Vulcanium.getOnlinePlayers().toArray();
    }

    protected @NotNull Player getBukkitPlayer(@NotNull Object player) {
        return (Player)player;
    }

    @Internal
    private final class PlayerIterator implements Iterator<Player> {
        private int next;
        private int current;
        private @Nullable Player player;

        private PlayerIterator() {
        }

        public boolean hasNext() {
            while(this.next < VulcaniumServerListPingEvent.this.players.length) {
                if (VulcaniumServerListPingEvent.this.players[this.next] != null) {
                    return true;
                }

                ++this.next;
            }

            return false;
        }

        public @NotNull Player next() {
            if (!this.hasNext()) {
                this.player = null;
                throw new NoSuchElementException();
            } else {
                this.current = this.next++;
                return this.player = VulcaniumServerListPingEvent.this.getBukkitPlayer(VulcaniumServerListPingEvent.this.players[this.current]);
            }
        }

        public void remove() {
            if (this.player == null) {
                throw new IllegalStateException();
            } else {
                UUID uniqueId = this.player.getUniqueId();
                this.player = null;
                VulcaniumServerListPingEvent.this.players[this.current] = null;
                VulcaniumServerListPingEvent.this.getPlayerSample().removeIf((p) -> {
                    return uniqueId.equals(p.getId());
                });
                if (VulcaniumServerListPingEvent.this.originalPlayerCount) {
                    --VulcaniumServerListPingEvent.this.numPlayers;
                }

            }
        }
    }
}
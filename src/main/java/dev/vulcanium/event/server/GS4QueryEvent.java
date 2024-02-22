package dev.vulcanium.event.server;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class GS4QueryEvent extends Event {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final QueryType queryType;
    private final InetAddress querierAddress;
    private QueryResponse response;

    @Internal
    public GS4QueryEvent(@NotNull QueryType queryType, @NotNull InetAddress querierAddress, @NotNull QueryResponse response) {
        super(true);
        this.queryType = queryType;
        this.querierAddress = querierAddress;
        this.response = response;
    }


    public @NotNull QueryType getQueryType() {
        return this.queryType;
    }

    public @NotNull InetAddress getQuerierAddress() {
        return this.querierAddress;
    }

    public @NotNull QueryResponse getResponse() {
        return this.response;
    }

    public void setResponse( @NotNull QueryResponse response) {
        this.response = (QueryResponse)Preconditions.checkNotNull(response, "response");
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public static enum QueryType {
        BASIC,
        FULL;

        private QueryType() {
        }
    }

    public static final class QueryResponse {
        private final String motd;
        private final String gameVersion;
        private final String map;
        private final int currentPlayers;
        private final int maxPlayers;
        private final String hostname;
        private final int port;
        private final Collection<String> players;
        private final String serverVersion;
        private final Collection<PluginInformation> plugins;

        private QueryResponse(String motd, String gameVersion, String map, int currentPlayers, int maxPlayers, String hostname, int port, Collection<String> players, String serverVersion, Collection<PluginInformation> plugins) {
            this.motd = motd;
            this.gameVersion = gameVersion;
            this.map = map;
            this.currentPlayers = currentPlayers;
            this.maxPlayers = maxPlayers;
            this.hostname = hostname;
            this.port = port;
            this.players = players;
            this.serverVersion = serverVersion;
            this.plugins = plugins;
        }

        public @NotNull String getMotd() {
            return this.motd;
        }

        public @NotNull String getGameVersion() {
            return this.gameVersion;
        }

        public @NotNull String getMap() {
            return this.map;
        }

        public int getCurrentPlayers() {
            return this.currentPlayers;
        }

        public int getMaxPlayers() {
            return this.maxPlayers;
        }

        public @NotNull String getHostname() {
            return this.hostname;
        }

        public int getPort() {
            return this.port;
        }

        public @NotNull Collection<String> getPlayers() {
            return this.players;
        }

        public @NotNull String getServerVersion() {
            return this.serverVersion;
        }

        public @NotNull Collection<PluginInformation> getPlugins() {
            return this.plugins;
        }

        public @NotNull Builder toBuilder() {
            return builder().motd(this.getMotd()).gameVersion(this.getGameVersion()).map(this.getMap()).currentPlayers(this.getCurrentPlayers()).maxPlayers(this.getMaxPlayers()).hostname(this.getHostname()).port(this.getPort()).players(this.getPlayers()).serverVersion(this.getServerVersion()).plugins(this.getPlugins());
        }


        public static @NotNull Builder builder() {
            return new Builder();
        }

        public static final class Builder {
            private String motd;
            private String gameVersion;
            private String map;
            private String hostname;
            private String serverVersion;
            private int currentPlayers;
            private int maxPlayers;
            private int port;
            private final List<String> players = new ArrayList();
            private final List<PluginInformation> plugins = new ArrayList();

            private Builder() {
            }


            public @NotNull Builder motd(@NotNull String motd) {
                this.motd = (String)Preconditions.checkNotNull(motd, "motd");
                return this;
            }


            public @NotNull Builder gameVersion(@NotNull String gameVersion) {
                this.gameVersion = (String)Preconditions.checkNotNull(gameVersion, "gameVersion");
                return this;
            }


            public @NotNull Builder map(@NotNull String map) {
                this.map = (String)Preconditions.checkNotNull(map, "map");
                return this;
            }


            public @NotNull Builder currentPlayers(int currentPlayers) {
                Preconditions.checkArgument(currentPlayers >= 0, "currentPlayers cannot be negative");
                this.currentPlayers = currentPlayers;
                return this;
            }


            public @NotNull Builder maxPlayers(int maxPlayers) {
                Preconditions.checkArgument(maxPlayers >= 0, "maxPlayers cannot be negative");
                this.maxPlayers = maxPlayers;
                return this;
            }


            public @NotNull Builder hostname(@NotNull String hostname) {
                this.hostname = (String)Preconditions.checkNotNull(hostname, "hostname");
                return this;
            }


            public @NotNull Builder port(int port) {
                Preconditions.checkArgument(port >= 1 && port <= 65535, "port must be between 1-65535");
                this.port = port;
                return this;
            }


            public @NotNull Builder players(@NotNull Collection<String> players) {
                this.players.addAll((Collection)Preconditions.checkNotNull(players, "players"));
                return this;
            }


            public @NotNull Builder players(String... players) {
                this.players.addAll(Arrays.asList((String[])Preconditions.checkNotNull(players, "players")));
                return this;
            }


            public @NotNull Builder clearPlayers() {
                this.players.clear();
                return this;
            }


            public @NotNull Builder serverVersion(@NotNull String serverVersion) {
                this.serverVersion = (String)Preconditions.checkNotNull(serverVersion, "serverVersion");
                return this;
            }


            public @NotNull Builder plugins(@NotNull Collection<PluginInformation> plugins) {
                this.plugins.addAll((Collection)Preconditions.checkNotNull(plugins, "plugins"));
                return this;
            }

            public @NotNull Builder plugins(PluginInformation... plugins) {
                this.plugins.addAll(Arrays.asList((PluginInformation[])Preconditions.checkNotNull(plugins, "plugins")));
                return this;
            }

            public @NotNull Builder clearPlugins() {
                this.plugins.clear();
                return this;
            }

            public @NotNull QueryResponse build() {
                return new QueryResponse((String)Preconditions.checkNotNull(this.motd, "motd"), (String)Preconditions.checkNotNull(this.gameVersion, "gameVersion"), (String)Preconditions.checkNotNull(this.map, "map"), this.currentPlayers, this.maxPlayers, (String)Preconditions.checkNotNull(this.hostname, "hostname"), this.port, ImmutableList.copyOf(this.players), (String)Preconditions.checkNotNull(this.serverVersion, "serverVersion"), ImmutableList.copyOf(this.plugins));
            }
        }

        public static class PluginInformation {
            private String name;
            private String version;

            public PluginInformation(@NotNull String name, @NotNull String version) {
                this.name = (String)Preconditions.checkNotNull(name, "name");
                this.version = (String)Preconditions.checkNotNull(version, "version");
            }

            public @NotNull String getName() {
                return this.name;
            }

            public void setName(@NotNull String name) {
                this.name = name;
            }

            public void setVersion(@NotNull String version) {
                this.version = version;
            }

            public @NotNull String getVersion() {
                return this.version;
            }

            public static @NotNull PluginInformation of(@NotNull String name, @NotNull String version) {
                return new PluginInformation(name, version);
            }
        }
    }
}

package dev.vulcanium.network;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.InetSocketAddress;

public interface NetworkClient {
    @NotNull InetSocketAddress getAddress();

    int getProtocolVersion();

    @Nullable InetSocketAddress getVirtualHost();
}

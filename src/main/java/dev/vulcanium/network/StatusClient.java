package dev.vulcanium.network;

public interface StatusClient extends NetworkClient {
    default boolean isLegacy() {
        return false;
    }
}
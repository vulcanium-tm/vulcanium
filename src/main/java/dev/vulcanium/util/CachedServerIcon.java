package dev.vulcanium.util;


import org.jetbrains.annotations.Nullable;
import dev.vulcanium.Server;
import dev.vulcanium.event.server.ServerListPingEvent;

/**
 * This is a cached version of a server-icon. It's internal representation
 * and implementation is undefined.
 *
 * @see Server#getServerIcon()
 * @see Server#loadServerIcon(java.awt.image.BufferedImage)
 * @see Server#loadServerIcon(java.io.File)
 * @see ServerListPingEvent#setServerIcon(CachedServerIcon)
 */
public interface CachedServerIcon{
    @Nullable
    String getData();
    default boolean isEmpty() {
    return this.getData() == null;
}
}

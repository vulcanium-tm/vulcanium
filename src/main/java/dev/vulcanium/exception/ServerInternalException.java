package dev.vulcanium.exception;

import dev.vulcanium.Vulcanium;
import dev.vulcanium.event.server.ServerExceptionEvent;
import java.util.logging.Level;

public class ServerInternalException extends ServerException {
    public ServerInternalException(String message) {
        super(message);
    }

    public ServerInternalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerInternalException(Throwable cause) {
        super(cause);
    }

    protected ServerInternalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static void reportInternalException(Throwable cause) {
        try {
            Vulcanium.getPluginManager().callEvent(new ServerExceptionEvent(new ServerInternalException(cause)));
        } catch (Throwable var2) {
            Vulcanium.getLogger().log(Level.WARNING, "Exception posting ServerExceptionEvent", var2);
        }

    }
}


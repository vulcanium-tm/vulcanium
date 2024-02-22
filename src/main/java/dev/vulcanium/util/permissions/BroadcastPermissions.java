package dev.vulcanium.util.permissions;

import dev.vulcanium.permissions.Permission;
import dev.vulcanium.permissions.PermissionDefault;
import dev.vulcanium.util.permissions.DefaultPermissions;
import org.jetbrains.annotations.NotNull;

public final class BroadcastPermissions {
    private static final String ROOT = "vulcanium.broadcast";
    private static final String PREFIX = ROOT + ".";

    private BroadcastPermissions() {}

    @NotNull
    public static Permission registerPermissions(@NotNull Permission parent) {
        Permission broadcasts = DefaultPermissions.registerPermission(ROOT, "Allows the user to receive all broadcast messages", parent);

        DefaultPermissions.registerPermission(PREFIX + "admin", "Allows the user to receive administrative broadcasts", PermissionDefault.OP, broadcasts);
        DefaultPermissions.registerPermission(PREFIX + "user", "Allows the user to receive user broadcasts", PermissionDefault.TRUE, broadcasts);

        broadcasts.recalculatePermissibles();

        return broadcasts;
    }
}
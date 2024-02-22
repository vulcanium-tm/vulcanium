package dev.vulcanium.util.permissions;

import dev.vulcanium.permissions.Permission;
import dev.vulcanium.permissions.PermissionDefault;
import org.jetbrains.annotations.NotNull;

public final class CommandPermissions {
    private static final String ROOT = "vulcanium.command";
    private static final String PREFIX = ROOT + ".";

    private CommandPermissions() {}

    @NotNull
    public static Permission registerPermissions(@NotNull Permission parent) {
        Permission commands = DefaultPermissions.registerPermission(ROOT, "Gives the user the ability to use all CraftBukkit commands", parent);

        registerPermission(PREFIX + "help", "Allows the user to view the vanilla help menu", PermissionDefault.TRUE, commands);
        registerPermission(PREFIX + "plugins", "Allows the user to view the list of plugins running on this server", PermissionDefault.TRUE, commands);
        registerPermission(PREFIX + "reload", "Allows the user to reload the server settings", PermissionDefault.OP, commands);
        registerPermission(PREFIX + "version", "Allows the user to view the version of the server", PermissionDefault.TRUE, commands);

        commands.recalculatePermissibles();
        return commands;
    }

    private static Permission registerPermission(String name, String desc, PermissionDefault def, Permission parent) {
        Permission perm = DefaultPermissions.registerPermission(name, desc, def, parent);
        parent.getChildren().put(perm.getName(), true);
        return perm;
    }
}
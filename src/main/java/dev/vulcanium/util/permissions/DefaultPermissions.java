package dev.vulcanium.util.permissions;

import dev.vulcanium.Vulcanium;
import dev.vulcanium.permissions.Permission;
import dev.vulcanium.permissions.PermissionDefault;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public final class DefaultPermissions {
    private static final String ROOT = "craftbukkit";
    private static final String LEGACY_PREFIX = "craft";

    private DefaultPermissions() {}

    @NotNull
    public static Permission registerPermission(@NotNull Permission perm) {
        return registerPermission(perm, true);
    }

    @NotNull
    public static Permission registerPermission(@NotNull Permission perm, boolean withLegacy) {
        Permission result = perm;

        try {
            Vulcanium.getPluginManager().addPermission(perm);
        } catch (IllegalArgumentException ex) {
            result = Vulcanium.getPluginManager().getPermission(perm.getName());
            assert result != null;
        }

        if (withLegacy) {
            Permission legacy = new Permission(LEGACY_PREFIX + result.getName(), result.getDescription(), PermissionDefault.FALSE);
            legacy.getChildren().put(result.getName(), true);
            registerPermission(legacy, false);
        }

        return result;
    }

    @NotNull
    public static Permission registerPermission(@NotNull Permission perm, @NotNull Permission parent) {
        parent.getChildren().put(perm.getName(), true);
        return registerPermission(perm);
    }

    @NotNull
    public static Permission registerPermission(@NotNull String name, @Nullable String desc) {
        Permission perm = registerPermission(new Permission(name, desc));
        return perm;
    }

    @NotNull
    public static Permission registerPermission(@NotNull String name, @Nullable String desc, @NotNull Permission parent) {
        Permission perm = registerPermission(name, desc);
        parent.getChildren().put(perm.getName(), true);
        return perm;
    }

    @NotNull
    public static Permission registerPermission(@NotNull String name, @Nullable String desc, @Nullable PermissionDefault def) {
        Permission perm = registerPermission(new Permission(name, desc, def));
        return perm;
    }

    @NotNull
    public static Permission registerPermission(@NotNull String name, @Nullable String desc, @Nullable PermissionDefault def, @NotNull Permission parent) {
        Permission perm = registerPermission(name, desc, def);
        parent.getChildren().put(perm.getName(), true);
        return perm;
    }

    @NotNull
    public static Permission registerPermission(@NotNull String name, @Nullable String desc, @Nullable PermissionDefault def, @Nullable Map<String, Boolean> children) {
        Permission perm = registerPermission(new Permission(name, desc, def, children));
        return perm;
    }

    @NotNull
    public static Permission registerPermission(@NotNull String name, @Nullable String desc, @Nullable PermissionDefault def, @Nullable Map<String, Boolean> children, @NotNull Permission parent) {
        Permission perm = registerPermission(name, desc, def, children);
        parent.getChildren().put(perm.getName(), true);
        return perm;
    }

    public static void registerCorePermissions() {
        Permission parent = registerPermission(ROOT, "Gives the user the ability to use all CraftBukkit utilities and commands");

        CommandPermissions.registerPermissions(parent);
        BroadcastPermissions.registerPermissions(parent);

        parent.recalculatePermissibles();
    }
}
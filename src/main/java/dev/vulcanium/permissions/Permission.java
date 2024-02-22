package dev.vulcanium.permissions;

import dev.vulcanium.Vulcanium;
import dev.vulcanium.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static dev.vulcanium.Vulcanium.getLogger;

/**
 * Represents a unique permission that may be attached to a {@link Permissible}
 */
public class Permission {
    public static final PermissionDefault DEFAULT_PERMISSION = PermissionDefault.OP;

    private final String name;
    private final Map<String, Boolean> children;
    private PermissionDefault defaultValue = DEFAULT_PERMISSION;
    private String description;

    public Permission(@NotNull String name) {
        this(name, "", null, null);
    }

    public Permission(@NotNull String name, @Nullable String description) {
        this(name, description, null, null);
    }

    public Permission(@NotNull String name, @Nullable PermissionDefault defaultValue) {
        this(name, "", defaultValue, null);
    }

    public Permission(@NotNull String name, @Nullable String description, @Nullable PermissionDefault defaultValue) {
        this(name, description, defaultValue, null);
    }

    public Permission(@NotNull String name, @Nullable Map<String, Boolean> children) {
        this(name, "", null, children);
    }

    public Permission(@NotNull String name, @Nullable String description, @Nullable Map<String, Boolean> children) {
        this(name, description, null, children);
    }

    public Permission(@NotNull String name, @Nullable PermissionDefault defaultValue, @Nullable Map<String, Boolean> children) {
        this(name, "", defaultValue, children);
    }

    public Permission(@NotNull String name, @Nullable String description, @Nullable PermissionDefault defaultValue, @Nullable Map<String, Boolean> children) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.description = (description == null) ? "" : description;
        this.children = (children == null) ? new HashMap<>() : new LinkedHashMap<>(children);
        if (defaultValue != null) {
            this.defaultValue = defaultValue;
        }
    }

    /**
     * Returns the unique fully qualified name of this Permission
     *
     * @return Fully qualified name
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * Gets the children of this permission.
     *
     * @return Permission children
     */
    @NotNull
    public Map<String, Boolean> getChildren() {
        return children;
    }

    /**
     * Gets the default value of this permission.
     *
     * @return Default value of this permission.
     */
    @NotNull
    public PermissionDefault getDefault() {
        return defaultValue;
    }

    /**
     * Sets the default value of this permission.
     *
     * @param value The new default to set
     */
    public void setDefault(@NotNull PermissionDefault value) {
        this.defaultValue = Objects.requireNonNull(value, "Default value cannot be null");
        recalculatePermissibles();
    }

    /**
     * Gets a brief description of this permission, may be empty
     *
     * @return Brief description of this permission
     */
    @NotNull
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of this permission.
     *
     * @param value The new description to set
     */
    public void setDescription(@Nullable String value) {
        this.description = (value == null) ? "" : value;
    }

    /**
     * Gets a set containing every {@link Permissible} that has this
     * permission.
     *
     * @return Set containing permissibles with this permission
     */
    @NotNull
    public Set<Permissible> getPermissibles() {
        return Vulcanium.getServer().getPluginManager().getPermissionSubscriptions(name);
    }

    /**
     * Recalculates all {@link Permissible}s that contain this permission.
     */
    public void recalculatePermissibles() {
        Set<Permissible> perms = getPermissibles();
        PluginManager pm = Vulcanium.getServer().getPluginManager();
        pm.recalculatePermissionDefaults(this);
        perms.forEach(Permissible::recalculatePermissions);
    }

    /**
     * Adds this permission to the specified parent permission.
     *
     * @param perm  Parent permission to register with
     * @param value The value to set this permission to
     */
    public void addParent(@NotNull Permission perm, boolean value) {
        perm.getChildren().put(name, value);
        perm.recalculatePermissibles();
    }

    /**
     * Loads a list of Permissions from a map of data.
     *
     * @param data  Map of permissions
     * @param error An error message to show if a permission is invalid
     * @param def   Default permission value to use if missing
     * @return List of Permission objects
     */
    @NotNull
    public static List<Permission> loadPermissions(@NotNull Map<?, ?> data, @NotNull String error, @Nullable PermissionDefault def) {
        List<Permission> result = new ArrayList<>();
        for (Map.Entry<?, ?> entry : data.entrySet()) {
            try {
                String name = entry.getKey().toString();
                Map<?, ?> permData = (Map<?, ?>) entry.getValue();
                Permission permission = loadPermission(name, (Map<Object, String>) permData, def, result);
                result.add(permission);
            } catch (Exception ex) {
                getLogger().severe(String.format(error, entry.getKey()));
            }
        }
        return result;
    }

    /**
     * Loads a Permission from a map of data.
     *
     * @param name Name of the permission
     * @param data Map of keys
     * @param def  Default permission value to use if not set
     * @param output A list to append any created child-Permissions to
     * @return Permission object
     */
    @NotNull
    public static Permission loadPermission(@NotNull String name, @NotNull Map<Object, String> data, @Nullable PermissionDefault def, @Nullable List<Permission> output) {
        String desc = data.getOrDefault("description", "").toString();
        PermissionDefault defaultValue = def;
        if (data.containsKey("default")) {
            defaultValue = PermissionDefault.getByName(data.get("default").toString());
            if (defaultValue == null) {
                defaultValue = def;
            }
        }
        Map<String, Boolean> children = new LinkedHashMap<>();
        Object childrenNode = data.getOrDefault("children", Collections.emptyMap().toString());
        if (childrenNode instanceof Map) {
            ((Map<?, ?>) childrenNode).forEach((key, value) -> {
                if (value instanceof Boolean) {
                    children.put(key.toString(), (Boolean) value);
                } else if (value instanceof Map) {
                    try {
                        Permission perm = loadPermission(key.toString(), (Map<Object, String>) value, def, output);
                        children.put(perm.getName(), Boolean.TRUE);
                        if (output != null) {
                            output.add(perm);
                        }
                    } catch (Exception ex) {
                        getLogger().severe("Permission node '" + key + "' in child of " + name + " is invalid");
                    }
                } else {
                    Vulcanium.getLogger().severe("Child '" + key + "' contains invalid value");
                }
            });
        }
        return new Permission(name, desc, defaultValue, children);
    }
}

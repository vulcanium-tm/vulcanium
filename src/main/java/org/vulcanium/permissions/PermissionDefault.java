package org.vulcanium.permissions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Represents the possible default values for permissions
 */
public enum PermissionDefault {
    TRUE("true"),
    FALSE("false"),
    OP("op", "isop", "operator", "isoperator", "admin", "isadmin"),
    NOT_OP("!op", "notop", "!operator", "notoperator", "!admin", "notadmin");

    private final String[] names;
    private static final Map<String, PermissionDefault> lookup = new EnumMap<>(PermissionDefault.class);
    private static final Pattern NAME_PATTERN = Pattern.compile("[^a-z!]");

    PermissionDefault(String... names) {
        this.names = names;
    }

    /**
     * Calculates the value of this PermissionDefault for the given operator value
     *
     * @param op If the target is op
     * @return True if the default should be true, or false
     */
    public boolean getValue(boolean op) {
        switch (this) {
            case TRUE:
                return true;
            case FALSE:
                return false;
            case OP:
                return op;
            case NOT_OP:
                return !op;
            default:
                return false;
        }
    }

    /**
     * Looks up a PermissionDefault by name
     *
     * @param name Name of the default
     * @return Specified value, or null if not found
     */
    @Nullable
    public static PermissionDefault getByName(@NotNull String name) {
        return lookup.get(NAME_PATTERN.matcher(name.toLowerCase(java.util.Locale.ENGLISH)).replaceAll(""));
    }

    static {
        for (PermissionDefault value : values()) {
            for (String name : value.names) {
                lookup.put(name, value);
            }
        }
    }
}
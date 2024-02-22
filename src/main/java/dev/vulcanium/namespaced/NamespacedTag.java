package dev.vulcanium.namespaced;

import com.google.common.base.Preconditions;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

import dev.vulcanium.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public final class NamespacedTag implements Namespaced {
    public static final String MINECRAFT = "minecraft";
    public static final String Vulcanium = "vulcanium";
    private static final Pattern VALID_NAMESPACE = Pattern.compile("[a-z0-9._-]+");
    private static final Pattern VALID_KEY = Pattern.compile("[a-z0-9/._-]+");
    private final String namespace;
    private final String key;

    /** @deprecated */
    @Deprecated
    public NamespacedTag(@NotNull String namespace, @NotNull String key) {
        Preconditions.checkArgument(namespace != null && VALID_NAMESPACE.matcher(namespace).matches(), "Invalid namespace. Must be [a-z0-9._-]: %s", namespace);
        Preconditions.checkArgument(key != null && VALID_KEY.matcher(key).matches(), "Invalid key. Must be [a-z0-9/._-]: %s", key);
        this.namespace = namespace;
        this.key = key;
        String string = this.toString();
        Preconditions.checkArgument(string.length() < 256, "NamespacedTag must be less than 256 characters", string);
    }

    public NamespacedTag(@NotNull Plugin plugin, @NotNull String key) {
        Preconditions.checkArgument(plugin != null, "Plugin cannot be null");
        Preconditions.checkArgument(key != null, "Key cannot be null");
        this.namespace = plugin.getName().toLowerCase(Locale.ROOT);
        this.key = key.toLowerCase().toLowerCase(Locale.ROOT);
        Preconditions.checkArgument(VALID_NAMESPACE.matcher(this.namespace).matches(), "Invalid namespace. Must be [a-z0-9._-]: %s", this.namespace);
        Preconditions.checkArgument(VALID_KEY.matcher(this.key).matches(), "Invalid key. Must be [a-z0-9/._-]: %s", this.key);
        String string = this.toString();
        Preconditions.checkArgument(string.length() < 256, "NamespacedTag must be less than 256 characters (%s)", string);
    }

    public @NotNull String getNamespace() {
        return this.namespace;
    }

    public @NotNull String getKey() {
        return this.key;
    }

    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.namespace.hashCode();
        hash = 47 * hash + this.key.hashCode();
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            NamespacedTag other = (NamespacedTag)obj;
            return this.namespace.equals(other.namespace) && this.key.equals(other.key);
        }
    }

    public String toString() {
        return "#" + this.namespace + ":" + this.key;
    }

    /** @deprecated */
    @Deprecated
    public static NamespacedTag randomKey() {
        return new NamespacedTag("bukkit", UUID.randomUUID().toString());
    }

    public static @NotNull NamespacedTag minecraft(@NotNull String key) {
        return new NamespacedTag("minecraft", key);
    }
}

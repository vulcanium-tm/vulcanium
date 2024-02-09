package org.vulcanium.metadata;

import org.vulcanium.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class MetadataStoreBase<T> {
    private Map<String, Map<Plugin, MetadataValue>> metadataMap = new ConcurrentHashMap<>();

    /**
     * Adds a metadata value to an object.
     */
    public void setMetadata(@NotNull T subject, @NotNull String metadataKey, @NotNull MetadataValue newMetadataValue) {
        Objects.requireNonNull(newMetadataValue, "Value cannot be null");
        Plugin owningPlugin = newMetadataValue.getOwningPlugin();
        Objects.requireNonNull(owningPlugin, "Plugin cannot be null");
        String key = disambiguate(subject, metadataKey);
        Map<Plugin, MetadataValue> entry = metadataMap.computeIfAbsent(key, k -> new ConcurrentHashMap<>(1));
        entry.put(owningPlugin, newMetadataValue);
    }

    /**
     * Returns all metadata values attached to an object.
     */
    @NotNull
    public List<MetadataValue> getMetadata(@NotNull T subject, @NotNull String metadataKey) {
        String key = disambiguate(subject, metadataKey);
        return metadataMap.containsKey(key) ?
                Collections.unmodifiableList(new ArrayList<>(metadataMap.get(key).values())) :
                Collections.emptyList();
    }

    /**
     * Tests to see if a metadata attribute has been set on an object.
     */
    public boolean hasMetadata(@NotNull T subject, @NotNull String metadataKey) {
        String key = disambiguate(subject, metadataKey);
        return metadataMap.containsKey(key);
    }

    /**
     * Removes a metadata item owned by a plugin from a subject.
     */
    public void removeMetadata(@NotNull T subject, @NotNull String metadataKey, @NotNull Plugin owningPlugin) {
        Objects.requireNonNull(owningPlugin, "Plugin cannot be null");
        String key = disambiguate(subject, metadataKey);
        Map<Plugin, MetadataValue> entry = metadataMap.get(key);
        if (entry != null) {
            entry.remove(owningPlugin);
            if (entry.isEmpty()) {
                metadataMap.remove(key);
            }
        }
    }

    /**
     * Invalidates all metadata in the metadata store that originates from the given plugin.
     */
    public void invalidateAll(@NotNull Plugin owningPlugin) {
        Objects.requireNonNull(owningPlugin, "Plugin cannot be null");
        metadataMap.values().forEach(values -> {
            values.entrySet().removeIf(entry -> entry.getKey() == owningPlugin);
            values.values().forEach(MetadataValue::invalidate);
        });
    }

    /**
     * Creates a unique name for the object receiving metadata.
     */
    @NotNull
    protected abstract String disambiguate(@NotNull T subject, @NotNull String metadataKey);
}

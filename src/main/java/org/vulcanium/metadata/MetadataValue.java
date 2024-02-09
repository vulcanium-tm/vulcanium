package org.vulcanium.metadata;

import org.vulcanium.plugin.Plugin;

public interface MetadataValue {

    /**
     * Fetches the value of this metadata item.
     *
     * @return the metadata value.
     */
    public Object value();

    /**
     * Returns the {@link Plugin} that created this metadata item.
     *
     * @return the plugin that owns this metadata value. Could be null if the plugin was already unloaded.
     */
    public Plugin getOwningPlugin();
}

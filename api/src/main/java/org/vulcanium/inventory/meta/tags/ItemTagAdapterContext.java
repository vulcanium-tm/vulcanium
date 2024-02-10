package org.vulcanium.inventory.meta.tags;

import org.vulcanium.persistence.PersistentDataAdapterContext;
import org.vulcanium.persistence.PersistentDataHolder;
import org.jetbrains.annotations.NotNull;

/**
 * This interface represents the context in which the {@link ItemTagType} can
 * serialize and deserialize the passed values.
 *
 * @deprecated this API part has been replaced by {@link PersistentDataHolder}.
 * Please use {@link PersistentDataAdapterContext} instead of this.
 */
@Deprecated
public interface ItemTagAdapterContext {

    /**
     * Creates a new and empty tag container instance.
     *
     * @return the fresh container instance
     */
    @NotNull
    CustomItemTagContainer newTagContainer();
}

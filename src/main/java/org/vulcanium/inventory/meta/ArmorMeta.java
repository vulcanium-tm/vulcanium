package org.vulcanium.inventory.meta;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.vulcanium.inventory.meta.trim.ArmorTrim;

/**
 * Represents armor that an entity can equip.
 * <p>
 * <strong>Note: Armor trims are part of an experimental feature of Minecraft
 * and hence subject to change.</strong>
 */
public interface ArmorMeta extends ItemMeta {

    /**
     * Check whether or not this item has an armor trim.
     *
     * @return true if has a trim, false otherwise
     */
    boolean hasTrim();

    /**
     * Set the {@link ArmorTrim}.
     *
     * @param trim the trim to set, or null to remove it
     */
    void setTrim(@Nullable ArmorTrim trim);

    /**
     * Get the {@link ArmorTrim}.
     *
     * @return the armor trim, or null if none
     */
    @Nullable
    ArmorTrim getTrim();

    @Override
    @NotNull
    ArmorMeta clone();
}

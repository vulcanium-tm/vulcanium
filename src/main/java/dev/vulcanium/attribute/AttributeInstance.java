/*
 Copyright © 2023

 Owner: Vulcanium

 Contributor: Shadowflare
 ────────────────────────────────────────────────────────────────────
 Permission is hereby granted to use and modify the Vulcanium plugin freely:

 1. Include copyright and permission notice in all copies of the Software.
 2. Users can depend on Vulcanium, create, and distribute plugins that rely on it.
 3. Republishing Vulcanium elsewhere is prohibited.
 4. Source code distribution is not allowed.
 5. Publishing a derivative version of the plugin is prohibited.
 ────────────────────────────────────────────────────────────────────
 SOFTWARE PROVIDED "AS IT IS," NO WARRANTY. AUTHORS NOT LIABLE FOR DAMAGES.
 */
package dev.vulcanium.attribute;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Represents a mutable instance of an attribute and its associated modifiers
 * and values.
 */
public interface AttributeInstance {

    /**
     * The attribute pertaining to this instance.
     *
     * @return the attribute
     */
    @NotNull
    Attribute getAttribute();

    /**
     * Base value of this instance before modifiers are applied.
     *
     * @return base value
     */
    double getBaseValue();

    /**
     * Set the base value of this instance.
     *
     * @param value new base value
     */
    void setBaseValue(double value);

    /**
     * Get all modifiers present on this instance.
     *
     * @return a copied collection of all modifiers
     */
    @NotNull
    Collection<AttributeModifier> getModifiers();

    /**
     * Add a modifier to this instance.
     *
     * @param modifier to add
     */
    void addModifier(@NotNull AttributeModifier modifier);

    /**
     * Remove a modifier from this instance.
     *
     * @param modifier to remove
     */
    void removeModifier(@NotNull AttributeModifier modifier);

    /**
     * Get the value of this instance after all associated modifiers have been
     * applied.
     *
     * @return the total attribute value
     */
    double getValue();

    /**
     * Gets the default value of the Attribute attached to this instance.
     *
     * @return server default value
     */
    double getDefaultValue();
}

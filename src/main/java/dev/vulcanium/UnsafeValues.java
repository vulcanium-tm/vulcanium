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
package dev.vulcanium;

import com.google.common.collect.Multimap;
import dev.vulcanium.namespaced.NamespacedKey;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.flattener.ComponentFlattener;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import dev.vulcanium.advancement.Advancement;
import dev.vulcanium.attribute.Attribute;
import dev.vulcanium.attribute.AttributeModifier;
import dev.vulcanium.block.data.BlockData;
import dev.vulcanium.command.CommandSender;
import dev.vulcanium.damage.DamageEffect;
import dev.vulcanium.damage.DamageSource;
import dev.vulcanium.damage.DamageType;
import dev.vulcanium.entity.Entity;
import dev.vulcanium.entity.EntityType;
import dev.vulcanium.inventory.CreativeCategory;
import dev.vulcanium.inventory.EquipmentSlot;
import dev.vulcanium.inventory.ItemStack;
import dev.vulcanium.material.MaterialData;
import dev.vulcanium.plugin.InvalidPluginException;
import dev.vulcanium.plugin.PluginDescriptionFile;
import dev.vulcanium.potion.PotionType;

import java.io.IOException;

/**
 * This interface provides value conversions that may be specific to a
 * runtime, or have arbitrary meaning (read: magic values).
 * <p>
 * Their existence and behavior is not guaranteed across future versions. They
 * may be poorly named, throw exceptions, have misleading parameters, or any
 * other bad programming practice.
 */
@Deprecated
public interface UnsafeValues {
    ComponentFlattener componentFlattener();
    Material toLegacy(Material material);

    Material fromLegacy(Material material);

    Material fromLegacy(MaterialData material);

    Material fromLegacy(MaterialData material, boolean itemPriority);

    BlockData fromLegacy(Material material, byte data);

    Material getMaterial(String material, int version);

    int getDataVersion();

    ItemStack modifyItemStack(ItemStack stack, String arguments);

    void checkSupported(PluginDescriptionFile pdf) throws InvalidPluginException;

    byte[] processClass(PluginDescriptionFile pdf, String path, byte[] clazz);

    /**
     * Load an advancement represented by the specified string into the server.
     * The advancement format is governed by Minecraft and has no specified
     * layout.
     * <br>
     * It is currently a JSON object, as described by the <a href="https://minecraft.wiki/w/Advancements">Minecraft wiki</a>.
     * <br>
     * Loaded advancements will be stored and persisted across server restarts
     * and reloads.
     * <br>
     * Callers should be prepared for {@link Exception} to be thrown.
     *
     * @param key the unique advancement key
     * @param advancement representation of the advancement
     * @return the loaded advancement or null if an error occurred
     */
    Advancement loadAdvancement(NamespacedKey key, String advancement);

    /**
     * Delete an advancement which was loaded and saved by
     * {@link #loadAdvancement(NamespacedKey, java.lang.String)}.
     * <br>
     * This method will only remove advancement from persistent storage. It
     * should be accompanied by a call to {@link Server#reloadData()} in order
     * to fully remove it from the running instance.
     *
     * @param key the unique advancement key
     * @return true if a file matching this key was found and deleted
     */
    boolean removeAdvancement(NamespacedKey key);

    Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(Material material, EquipmentSlot slot);

    @ApiStatus.Internal
    @Nullable
    DamageEffect getDamageEffect(@NotNull String var1);

    @ApiStatus.Internal
    @NotNull
    DamageSource.Builder createDamageSourceBuilder(@NotNull DamageType var1);

    Component resolveWithContext(Component var1, CommandSender var2, Entity var3, boolean var4) throws IOException;

    CreativeCategory getCreativeCategory(Material material);

    String getBlockTranslationKey(Material material);

    String getItemTranslationKey(Material material);

    String getTranslationKey(EntityType entityType);

    String getTranslationKey(ItemStack itemStack);

    @Nullable
    FeatureFlag getFeatureFlag(@NotNull NamespacedKey key);

    /**
     * Do not use, method will get removed, and the plugin won't run
     *
     * @param key of the potion type
     * @return an internal potion data
     */
    PotionType.InternalPotionData getInternalPotionData(NamespacedKey key);
}
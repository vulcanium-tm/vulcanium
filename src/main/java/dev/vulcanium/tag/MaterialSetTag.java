package dev.vulcanium.tag;

import com.google.common.collect.Lists;
import dev.vulcanium.Material;
import dev.vulcanium.block.Block;
import dev.vulcanium.block.BlockState;
import dev.vulcanium.block.data.BlockData;
import dev.vulcanium.inventory.ItemStack;
import dev.vulcanium.namespaced.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaterialSetTag extends BaseTag<Material, MaterialSetTag> {
    /** @deprecated */
    @Deprecated
    public MaterialSetTag(@NotNull Predicate<Material> filter) {
        this((NamespacedKey)null, (Collection)((Collection)Stream.of(Material.values()).filter(filter).collect(Collectors.toList())));
    }

    /** @deprecated */
    @Deprecated
    public MaterialSetTag(@NotNull Collection<Material> materials) {
        this((NamespacedKey)null, (Collection)materials);
    }

    /** @deprecated */
    @Deprecated
    public MaterialSetTag(Material... materials) {
        this((NamespacedKey)null, (Material[])materials);
    }

    public MaterialSetTag(@Nullable NamespacedKey key, @NotNull Predicate<Material> filter) {
        this(key, (Collection)Stream.of(Material.values()).filter(filter).collect(Collectors.toList()));
    }

    public MaterialSetTag(@Nullable NamespacedKey key, Material... materials) {
        this(key, (Collection)Lists.newArrayList(materials));
    }
    public MaterialSetTag(@Nullable NamespacedKey key, @NotNull Collection<Material> materials, Predicate<Material>... globalPredicates) {
        super(Material.class, key != null ? key : NamespacedKey.randomKey(), materials, globalPredicates);
    }

    protected @NotNull Set<Material> getAllPossibleValues() {
        return (Set)Stream.of(Material.values()).collect(Collectors.toSet());
    }

    protected @NotNull String getName(@NotNull Material value) {
        return value.name();
    }

    public boolean isTagged(@NotNull BlockData block) {
        return this.isTagged(block.getMaterial());
    }

    public boolean isTagged(@NotNull BlockState block) {
        return this.isTagged(block.getType());
    }

    public boolean isTagged(@NotNull Block block) {
        return this.isTagged(block.getType());
    }

    public boolean isTagged(@NotNull ItemStack item) {
        return this.isTagged(item.getType());
    }

    public boolean isTagged(@NotNull Material material) {
        return this.tagged.contains(material);
    }
}

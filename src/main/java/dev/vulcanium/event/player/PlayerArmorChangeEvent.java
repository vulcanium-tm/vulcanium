package dev.vulcanium.event.player;

import dev.vulcanium.Material;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class PlayerArmorChangeEvent extends PlayerEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull SlotType slotType;
    private final @NotNull ItemStack oldItem;
    private final @NotNull ItemStack newItem;

    @Internal
    public PlayerArmorChangeEvent(@NotNull Player player, @NotNull SlotType slotType, @NotNull ItemStack oldItem, @NotNull ItemStack newItem) {
        super(player);
        this.slotType = slotType;
        this.oldItem = oldItem;
        this.newItem = newItem;
    }

    public @NotNull SlotType getSlotType() {
        return this.slotType;
    }

    public @NotNull ItemStack getOldItem() {
        return this.oldItem;
    }

    public @NotNull ItemStack getNewItem() {
        return this.newItem;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public static enum SlotType {
        HEAD(new Material[]{Material.NETHERITE_HELMET, Material.DIAMOND_HELMET, Material.GOLDEN_HELMET, Material.IRON_HELMET, Material.CHAINMAIL_HELMET, Material.LEATHER_HELMET, Material.CARVED_PUMPKIN, Material.PLAYER_HEAD, Material.SKELETON_SKULL, Material.ZOMBIE_HEAD, Material.CREEPER_HEAD, Material.WITHER_SKELETON_SKULL, Material.TURTLE_HELMET, Material.DRAGON_HEAD, Material.PIGLIN_HEAD}),
        CHEST(new Material[]{Material.NETHERITE_CHESTPLATE, Material.DIAMOND_CHESTPLATE, Material.GOLDEN_CHESTPLATE, Material.IRON_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.LEATHER_CHESTPLATE, Material.ELYTRA}),
        LEGS(new Material[]{Material.NETHERITE_LEGGINGS, Material.DIAMOND_LEGGINGS, Material.GOLDEN_LEGGINGS, Material.IRON_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.LEATHER_LEGGINGS}),
        FEET(new Material[]{Material.NETHERITE_BOOTS, Material.DIAMOND_BOOTS, Material.GOLDEN_BOOTS, Material.IRON_BOOTS, Material.CHAINMAIL_BOOTS, Material.LEATHER_BOOTS});

        private final Set<Material> types;

        private SlotType(Material... types) {
            this.types = Set.of(types);
        }

        public @NotNull Set<Material> getTypes() {
            return this.types;
        }

        public static @Nullable SlotType getByMaterial(@NotNull Material material) {
            SlotType[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                SlotType slotType = var1[var3];
                if (slotType.getTypes().contains(material)) {
                    return slotType;
                }
            }

            return null;
        }

        public static boolean isEquipable(@NotNull Material material) {
            return getByMaterial(material) != null;
        }
    }
}

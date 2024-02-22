package dev.vulcanium.event.block;

import dev.vulcanium.Material;
import dev.vulcanium.block.data.BlockData;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.event.inventory.InventoryEvent;
import dev.vulcanium.inventory.AnvilInventory;
import dev.vulcanium.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

public class AnvilDamagedEvent extends InventoryEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private DamageState damageState;
    private boolean cancelled;

    @Internal
    public AnvilDamagedEvent(@NotNull InventoryView inventory, @Nullable BlockData blockData) {
        super(inventory);
        this.damageState = AnvilDamagedEvent.DamageState.getState(blockData);
    }

    public @NotNull AnvilInventory getInventory() {
        return (AnvilInventory)super.getInventory();
    }


    public @NotNull DamageState getDamageState() {
        return this.damageState;
    }

    public void setDamageState( @NotNull DamageState damageState) {
        this.damageState = damageState;
    }

    public boolean isBreaking() {
        return this.damageState == AnvilDamagedEvent.DamageState.BROKEN;
    }

    public void setBreaking(boolean breaking) {
        if (breaking) {
            this.damageState = AnvilDamagedEvent.DamageState.BROKEN;
        } else if (this.damageState == AnvilDamagedEvent.DamageState.BROKEN) {
            this.damageState = AnvilDamagedEvent.DamageState.DAMAGED;
        }

    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public static enum DamageState {
        FULL(Material.ANVIL),
        CHIPPED(Material.CHIPPED_ANVIL),
        DAMAGED(Material.DAMAGED_ANVIL),
        BROKEN(Material.AIR);

        private final Material material;

        private DamageState(Material material) {
            this.material = material;
        }

        public @NotNull Material getMaterial() {
            return this.material;
        }


        public static @NotNull DamageState getState(@Nullable BlockData blockData) {
            return blockData == null ? BROKEN : getState(blockData.getMaterial());
        }

        public static @NotNull DamageState getState(@Nullable Material material) {
            if (material == null) {
                return BROKEN;
            } else {
                DamageState[] var1 = values();
                int var2 = var1.length;

                for(int var3 = 0; var3 < var2; ++var3) {
                    DamageState state = var1[var3];
                    if (state.getMaterial() == material) {
                        return state;
                    }
                }

                throw new IllegalArgumentException("Material is not an anvil state");
            }
        }
    }
}

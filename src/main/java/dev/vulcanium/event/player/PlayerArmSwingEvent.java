package dev.vulcanium.event.player;

import dev.vulcanium.entity.Player;
import dev.vulcanium.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerArmSwingEvent extends PlayerAnimationEvent {
    private final EquipmentSlot equipmentSlot;

    @Internal
    public PlayerArmSwingEvent(@NotNull Player player, @NotNull EquipmentSlot equipmentSlot) {
        super(player, equipmentSlot == EquipmentSlot.HAND ? PlayerAnimationType.ARM_SWING : PlayerAnimationType.OFF_ARM_SWING);
        this.equipmentSlot = equipmentSlot;
    }

    public @NotNull EquipmentSlot getHand() {
        return this.equipmentSlot;
    }
}

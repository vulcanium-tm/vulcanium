package dev.vulcanium.event.player;

import dev.vulcanium.entity.Player;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.EquipmentSlot;
import dev.vulcanium.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerUseUnknownEntityEvent extends PlayerEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final int entityId;
    private final boolean attack;
    private final @NotNull EquipmentSlot hand;
    private final @Nullable Vector clickedPosition;

    @Internal
    public PlayerUseUnknownEntityEvent(@NotNull Player player, int entityId, boolean attack, @NotNull EquipmentSlot hand, @Nullable Vector clickedPosition) {
        super(player);
        this.entityId = entityId;
        this.attack = attack;
        this.hand = hand;
        this.clickedPosition = clickedPosition;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public boolean isAttack() {
        return this.attack;
    }

    public @NotNull EquipmentSlot getHand() {
        return this.hand;
    }

    public @Nullable Vector getClickedRelativePosition() {
        return this.clickedPosition != null ? this.clickedPosition.clone() : null;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

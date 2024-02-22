package dev.vulcanium.event.player;

import dev.vulcanium.entity.AbstractVillager;
import dev.vulcanium.entity.Player;
import dev.vulcanium.inventory.MerchantRecipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerTradeEvent extends PlayerPurchaseEvent {
    private final AbstractVillager villager;

    @Internal
    public PlayerTradeEvent(@NotNull Player player, @NotNull AbstractVillager villager, @NotNull MerchantRecipe trade, boolean rewardExp, boolean increaseTradeUses) {
        super(player, trade, rewardExp, increaseTradeUses);
        this.villager = villager;
    }

    public @NotNull AbstractVillager getVillager() {
        return this.villager;
    }
}

package dev.vulcanium.event.player;

import com.google.common.base.Preconditions;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.MerchantRecipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerPurchaseEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private boolean rewardExp;
    private boolean increaseTradeUses;
    private MerchantRecipe trade;
    private boolean cancelled;

    @Internal
    public PlayerPurchaseEvent(@NotNull Player player, @NotNull MerchantRecipe trade, boolean rewardExp, boolean increaseTradeUses) {
        super(player);
        this.setTrade(trade);
        this.rewardExp = rewardExp;
        this.increaseTradeUses = increaseTradeUses;
    }

    public @NotNull MerchantRecipe getTrade() {
        return this.trade;
    }

    public void setTrade(@NotNull MerchantRecipe trade) {
        Preconditions.checkArgument(trade != null, "Trade cannot be null!");
        this.trade = trade;
    }

    public boolean isRewardingExp() {
        return this.rewardExp;
    }

    public void setRewardExp(boolean rewardExp) {
        this.rewardExp = rewardExp;
    }

    public boolean willIncreaseTradeUses() {
        return this.increaseTradeUses;
    }

    public void setIncreaseTradeUses(boolean increaseTradeUses) {
        this.increaseTradeUses = increaseTradeUses;
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
}

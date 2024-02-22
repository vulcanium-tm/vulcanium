package dev.vulcanium.event.player;

import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.StonecutterInventory;
import dev.vulcanium.inventory.StonecuttingRecipe;
import org.jetbrains.annotations.NotNull;

public class PlayerStonecutterRecipeSelectEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final StonecutterInventory stonecutterInventory;
    private StonecuttingRecipe stonecuttingRecipe;
    private boolean cancelled;

    public PlayerStonecutterRecipeSelectEvent(@NotNull Player player, @NotNull StonecutterInventory stonecutterInventory, @NotNull StonecuttingRecipe stonecuttingRecipe) {
        super(player);
        this.stonecutterInventory = stonecutterInventory;
        this.stonecuttingRecipe = stonecuttingRecipe;
    }

    public @NotNull StonecutterInventory getStonecutterInventory() {
        return this.stonecutterInventory;
    }

    public @NotNull StonecuttingRecipe getStonecuttingRecipe() {
        return this.stonecuttingRecipe;
    }

    public void setStonecuttingRecipe(@NotNull StonecuttingRecipe stonecuttingRecipe) {
        this.stonecuttingRecipe = stonecuttingRecipe;
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

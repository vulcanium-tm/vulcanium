package dev.vulcanium.event.block;

import dev.vulcanium.block.Block;
import dev.vulcanium.inventory.CampfireRecipe;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.HandlerList;

/**
 * Called when a Campfire starts to cook.
 */
public class CampfireStartEvent extends InventoryBlockStartEvent {

    private static final HandlerList handlers = new HandlerList();
    private int cookingTime;
    private CampfireRecipe campfireRecipe;

    public CampfireStartEvent(@NotNull final Block furnace, @NotNull ItemStack source, @NotNull CampfireRecipe recipe) {
        super(furnace, source);
        this.cookingTime = recipe.getCookingTime();
        this.campfireRecipe = recipe;
    }

    /**
     * Gets the CampfireRecipe associated with this event.
     *
     * @return the CampfireRecipe being cooked
     */
    @NotNull
    public CampfireRecipe getRecipe() {
        return campfireRecipe;
    }

    /**
     * Gets the total cook time associated with this event.
     *
     * @return the total cook time
     */
    public int getTotalCookTime() {
        return cookingTime;
    }

    /**
     * Sets the total cook time for this event.
     *
     * @param cookTime the new total cook time
     */
    public void setTotalCookTime(int cookTime) {
        this.cookingTime = cookTime;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}

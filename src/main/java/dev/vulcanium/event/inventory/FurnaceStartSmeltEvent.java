package dev.vulcanium.event.inventory;

import dev.vulcanium.block.Block;
import dev.vulcanium.inventory.CookingRecipe;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.event.block.InventoryBlockStartEvent;

/**
 * Called when a Furnace starts smelting.
 */
public class FurnaceStartSmeltEvent extends InventoryBlockStartEvent {
    private static final HandlerList handlers = new HandlerList();
    private final CookingRecipe<?> recipe;
    private int totalCookTime;

    public FurnaceStartSmeltEvent(@NotNull final Block furnace, @NotNull ItemStack source, @NotNull final CookingRecipe<?> recipe) {
        super(furnace, source);
        this.recipe = recipe;
        this.totalCookTime = recipe.getCookingTime();
    }

    /**
     * Gets the FurnaceRecipe associated with this event
     *
     * @return the FurnaceRecipe being cooked
     */
    @NotNull
    public CookingRecipe<?> getRecipe() {
        return recipe;
    }

    /**
     * Gets the total cook time associated with this event
     *
     * @return the total cook time
     */
    public int getTotalCookTime() {
        return totalCookTime;
    }

    /**
     * Sets the total cook time for this event
     *
     * @param cookTime the new total cook time
     */
    public void setTotalCookTime(int cookTime) {
        this.totalCookTime = cookTime;
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

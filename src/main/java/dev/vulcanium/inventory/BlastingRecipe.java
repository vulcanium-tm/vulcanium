package dev.vulcanium.inventory;

import dev.vulcanium.Material;
import dev.vulcanium.namespaced.NamespacedKey;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a campfire recipe.
 */
public class BlastingRecipe extends CookingRecipe<BlastingRecipe> {

    public BlastingRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull Material source, float experience, int cookingTime) {
        super(key, result, source, experience, cookingTime);
    }

    public BlastingRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull RecipeChoice input, float experience, int cookingTime) {
        super(key, result, input, experience, cookingTime);
    }
}

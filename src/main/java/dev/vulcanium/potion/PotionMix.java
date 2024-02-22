package dev.vulcanium.potion;

import dev.vulcanium.namespaced.*;
import org.jetbrains.annotations.ApiStatus.NonExtendable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.inventory.ItemStack;
import dev.vulcanium.inventory.RecipeChoice;

import java.util.Objects;
import java.util.function.Predicate;

@NonExtendable
public class PotionMix implements Keyed {
    private final NamespacedKey key;
    private final ItemStack result;
    private final RecipeChoice input;
    private final RecipeChoice ingredient;

    public PotionMix(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull RecipeChoice input, @NotNull RecipeChoice ingredient) {
        this.key = key;
        this.result = result;
        this.input = input;
        this.ingredient = ingredient;
    }

    @Contract(
            value = "_ -> new",
            pure = true
    )
    public static @NotNull RecipeChoice createPredicateChoice(@NotNull Predicate<? super ItemStack> stackPredicate) {
        return new PredicateRecipeChoice(stackPredicate);
    }

    public @NotNull NamespacedKey getKey() {
        return this.key;
    }

    public @NotNull ItemStack getResult() {
        return this.result;
    }

    public @NotNull RecipeChoice getInput() {
        return this.input;
    }

    public @NotNull RecipeChoice getIngredient() {
        return this.ingredient;
    }

    public String toString() {
        return "PotionMix{result=" + this.result + ", base=" + this.input + ", addition=" + this.ingredient + "}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            PotionMix potionMix = (PotionMix)o;
            return this.key.equals(potionMix.key) && this.result.equals(potionMix.result) && this.input.equals(potionMix.input) && this.ingredient.equals(potionMix.ingredient);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.result, this.input, this.ingredient});
    }
}

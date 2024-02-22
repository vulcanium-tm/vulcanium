package dev.vulcanium.potion;

import java.util.function.Predicate;
import dev.vulcanium.inventory.ItemStack;
import dev.vulcanium.inventory.RecipeChoice;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
record PredicateRecipeChoice(Predicate<? super ItemStack> itemStackPredicate) implements RecipeChoice, Cloneable {
    PredicateRecipeChoice(Predicate<? super ItemStack> itemStackPredicate) {
        this.itemStackPredicate = itemStackPredicate;
    }

    /** @deprecated */
    @Deprecated
    public ItemStack getItemStack() {
        throw new UnsupportedOperationException("PredicateRecipeChoice does not support this");
    }

    public RecipeChoice clone() {
        try {
            return (PredicateRecipeChoice)super.clone();
        } catch (CloneNotSupportedException var2) {
            throw new AssertionError(var2);
        }
    }

    public boolean test(ItemStack itemStack) {
        return this.itemStackPredicate.test(itemStack);
    }

    public Predicate<? super ItemStack> itemStackPredicate() {
        return this.itemStackPredicate;
    }
}

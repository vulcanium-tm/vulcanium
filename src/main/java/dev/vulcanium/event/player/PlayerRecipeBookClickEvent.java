package dev.vulcanium.event.player;

import dev.vulcanium.namespaced.NamespacedKey;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerRecipeBookClickEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private @NotNull NamespacedKey recipe;
    private boolean makeAll;
    private boolean cancelled;

    @Internal
    public PlayerRecipeBookClickEvent(@NotNull Player player, @NotNull NamespacedKey recipe, boolean makeAll) {
        super(player);
        this.recipe = recipe;
        this.makeAll = makeAll;
    }

    public @NotNull NamespacedKey getRecipe() {
        return this.recipe;
    }

    public void setRecipe(@NotNull NamespacedKey recipe) {
        this.recipe = recipe;
    }

    public boolean isMakeAll() {
        return this.makeAll;
    }

    public void setMakeAll(boolean makeAll) {
        this.makeAll = makeAll;
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

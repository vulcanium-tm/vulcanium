package dev.vulcanium.event.player;

import dev.vulcanium.block.Lectern;
import dev.vulcanium.entity.Player;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerLecternPageChangeEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Lectern lectern;
    private final ItemStack book;
    private final PageChangeDirection pageChangeDirection;
    private final int oldPage;
    private int newPage;
    private boolean cancelled;

    @Internal
    public PlayerLecternPageChangeEvent(@NotNull Player player, @NotNull Lectern lectern, @NotNull ItemStack book, @NotNull PageChangeDirection pageChangeDirection, int oldPage, int newPage) {
        super(player);
        this.lectern = lectern;
        this.book = book;
        this.pageChangeDirection = pageChangeDirection;
        this.oldPage = oldPage;
        this.newPage = newPage;
    }

    public @NotNull Lectern getLectern() {
        return this.lectern;
    }

    public @NotNull ItemStack getBook() {
        return this.book;
    }

    public @NotNull PageChangeDirection getPageChangeDirection() {
        return this.pageChangeDirection;
    }

    public int getOldPage() {
        return this.oldPage;
    }

    public int getNewPage() {
        return this.newPage;
    }

    public void setNewPage(int newPage) {
        this.newPage = newPage;
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

    public static enum PageChangeDirection {
        LEFT,
        RIGHT;

        private PageChangeDirection() {
        }
    }
}

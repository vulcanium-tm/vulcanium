package dev.vulcanium.event.entity;

import dev.vulcanium.event.block.CompostItemEvent;
import dev.vulcanium.block.Block;
import dev.vulcanium.entity.Entity;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EntityCompostItemEvent extends CompostItemEvent implements Cancellable {
    private final Entity entity;
    private boolean cancelled;

    @Internal
    public EntityCompostItemEvent(@NotNull Entity entity, @NotNull Block composter, @NotNull ItemStack item, boolean willRaiseLevel) {
        super(composter, item, willRaiseLevel);
        this.entity = entity;
    }

    public @NotNull Entity getEntity() {
        return this.entity;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}

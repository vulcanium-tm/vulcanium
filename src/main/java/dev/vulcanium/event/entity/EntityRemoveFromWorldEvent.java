package dev.vulcanium.event.entity;

import dev.vulcanium.world.World;
import dev.vulcanium.entity.Entity;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EntityRemoveFromWorldEvent extends EntityEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull World world;

    @Internal
    public EntityRemoveFromWorldEvent(@NotNull Entity entity, @NotNull World world) {
        super(entity);
        this.world = world;
    }

    public @NotNull World getWorld() {
        return this.world;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

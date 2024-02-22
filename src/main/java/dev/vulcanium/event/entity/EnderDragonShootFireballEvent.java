package dev.vulcanium.event.entity;

import dev.vulcanium.entity.DragonFireball;
import dev.vulcanium.entity.EnderDragon;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EnderDragonShootFireballEvent extends EntityEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final @NotNull DragonFireball fireball;
    private boolean cancelled;

    @Internal
    public EnderDragonShootFireballEvent(@NotNull EnderDragon entity, @NotNull DragonFireball fireball) {
        super(entity);
        this.fireball = fireball;
    }

    public @NotNull EnderDragon getEntity() {
        return (EnderDragon)super.getEntity();
    }

    public @NotNull DragonFireball getFireball() {
        return this.fireball;
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

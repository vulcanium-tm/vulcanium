package dev.vulcanium.event.block;

import dev.vulcanium.block.Block;
import dev.vulcanium.block.BlockState;
import dev.vulcanium.boss.DragonBattle;
import dev.vulcanium.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class DragonEggFormEvent extends BlockFormEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final DragonBattle dragonBattle;

    @Internal
    public DragonEggFormEvent(@NotNull Block block, @NotNull BlockState newState, @NotNull DragonBattle dragonBattle) {
        super(block, newState);
        this.dragonBattle = dragonBattle;
    }

    public @NotNull DragonBattle getDragonBattle() {
        return this.dragonBattle;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}

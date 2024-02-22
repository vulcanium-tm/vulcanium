package dev.vulcanium.event.player;

import java.util.Set;
import dev.vulcanium.block.Sign;
import dev.vulcanium.block.sign.Side;
import dev.vulcanium.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerSignCommandPreprocessEvent extends PlayerCommandPreprocessEvent {
    private final Sign sign;
    private final Side side;

    @Internal
    public PlayerSignCommandPreprocessEvent(@NotNull Player player, @NotNull String message, @NotNull Set<Player> recipients, @NotNull Sign sign, @NotNull Side side) {
        super(player, message, recipients);
        this.sign = sign;
        this.side = side;
    }

    public @NotNull Sign getSign() {
        return this.sign;
    }

    public @NotNull Side getSide() {
        return this.side;
    }
}

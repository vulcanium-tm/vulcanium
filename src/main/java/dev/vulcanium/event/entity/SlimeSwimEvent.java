package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Slime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class SlimeSwimEvent extends SlimeWanderEvent {
    @Internal
    public SlimeSwimEvent(@NotNull Slime slime) {
        super(slime);
    }
}

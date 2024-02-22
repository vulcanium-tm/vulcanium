package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Slime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class SlimeWanderEvent extends SlimePathfindEvent {
    @Internal
    public SlimeWanderEvent(@NotNull Slime slime) {
        super(slime);
    }
}

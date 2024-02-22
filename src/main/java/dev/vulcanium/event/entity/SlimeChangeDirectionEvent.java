package dev.vulcanium.event.entity;

import dev.vulcanium.entity.Slime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class SlimeChangeDirectionEvent extends SlimePathfindEvent {
    private float yaw;

    @Internal
    public SlimeChangeDirectionEvent(@NotNull Slime slime, float yaw) {
        super(slime);
        this.yaw = yaw;
    }

    public float getNewYaw() {
        return this.yaw;
    }

    public void setNewYaw(float yaw) {
        this.yaw = yaw;
    }
}

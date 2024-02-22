package dev.vulcanium.entity;

public sealed interface TeleportFlag {
    public static enum EntityState implements TeleportFlag {
        RETAIN_PASSENGERS,
        RETAIN_VEHICLE,
        RETAIN_OPEN_INVENTORY;

        private EntityState() {
        }
    }

    public static enum Relative implements TeleportFlag {
        X,
        Y,
        Z,
        YAW,
        PITCH;

        private Relative() {
        }
    }
}

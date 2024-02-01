package org.vulcanium;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a vibration from a Skulk sensor.
 */
@Getter
public class Vibration {

    private final Location origin;
    private final Destination destination;
    private final int arrivalTime;

    public Vibration(@NotNull final Location origin, @NotNull final Destination destination, final int arrivalTime) {
        this.origin = origin;
        this.destination = destination;
        this.arrivalTime = arrivalTime;
    }

    public interface Destination {

        @Getter
        class EntityDestination implements Destination {

            private final Entity entity;

            public EntityDestination(@NotNull final Entity entity) {
                this.entity = entity;
            }
        }

        @Getter
        class BlockDestination implements Destination {

            private final Location location;

            public BlockDestination(@NotNull final Location location) {
                this.location = location;
            }

            public BlockDestination(@NotNull final Block block) {
                this(block.getLocation());
            }

            @NotNull
            public Block getBlock() {
                return location.getBlock();
            }
        }
    }
}

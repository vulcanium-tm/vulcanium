/*
 Copyright © 2023

 Owner: Vulcanium

 Contributor: Shadowflare
 ────────────────────────────────────────────────────────────────────
 Permission is hereby granted to use and modify the Vulcanium plugin freely:

 1. Include copyright and permission notice in all copies of the Software.
 2. Users can depend on Vulcanium, create, and distribute plugins that rely on it.
 3. Republishing Vulcanium elsewhere is prohibited.
 4. Source code distribution is not allowed.
 5. Publishing a derivative version of the plugin is prohibited.
 ────────────────────────────────────────────────────────────────────
 SOFTWARE PROVIDED "AS IT IS," NO WARRANTY. AUTHORS NOT LIABLE FOR DAMAGES.
 */
package org.vulcanium;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.vulcanium.block.Block;
import org.vulcanium.entity.Entity;

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

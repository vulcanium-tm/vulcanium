package dev.vulcanium.event.world;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import dev.vulcanium.Location;
import dev.vulcanium.namespaced.NamespacedKey;
import dev.vulcanium.world.World;
import dev.vulcanium.event.Cancellable;
import dev.vulcanium.event.HandlerList;
import dev.vulcanium.generator.structure.Structure;
import dev.vulcanium.generator.structure.StructureType;
import dev.vulcanium.math.Position;
import dev.vulcanium.util.TransformingRandomAccessList;
import dev.vulcanium.world.structure.ConfiguredStructure;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StructuresLocateEvent extends WorldEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Location origin;
    private Result result;
    private List<Structure> structures;
    private List<ConfiguredStructure> legacy$structures;
    private int radius;
    private boolean findUnexplored;
    private boolean cancelled;
    private NamespacedKey namespacedKey;
    private StructureType structureType;

    @Internal
    public StructuresLocateEvent(@NotNull World world, @NotNull Location origin, @NotNull List<Structure> structures, int radius, boolean findUnexplored) {
        super(world);
        this.origin = origin;
        this.setStructures(structures);
        this.radius = radius;
        this.findUnexplored = findUnexplored;
    }

    public @NotNull Location getOrigin() {
        return this.origin;
    }

    public @Nullable Result getResult() {
        return this.result;
    }

    public void setResult( @Nullable Result result) {
        this.result = result;
    }

    /** @deprecated */
    @Deprecated(
            forRemoval = true
    )
    public @NotNull List<ConfiguredStructure> getConfiguredStructures() {
        return this.legacy$structures;
    }

    /** @deprecated */
    @Deprecated(
            forRemoval = true
    )
    public void setConfiguredStructures(@NotNull List<ConfiguredStructure> configuredStructures) {
        this.setStructures(configuredStructures.stream().map(ConfiguredStructure::toModern).toList());
    }

    public @NotNull List<Structure> getStructures() {
        return Collections.unmodifiableList(this.structures);
    }

    public void setStructures(@NotNull List<Structure> structures) {
        this.structures = structures;
        ConfiguredStructure configuredStructure = new ConfiguredStructure(namespacedKey, structureType);
        this.legacy$structures = new TransformingRandomAccessList(
                this.structures,
                structure -> ConfiguredStructure.fromModern((Structure) structure),
                t -> {
                    return configuredStructure.toModern();
                }
        );
    }
    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean shouldFindUnexplored() {
        return this.findUnexplored;
    }

    public void setFindUnexplored(boolean findUnexplored) {
        this.findUnexplored = findUnexplored;
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

    public static record Result(@NotNull Position pos, @NotNull Structure structure) {
        /** @deprecated */
        @Deprecated(
                forRemoval = true
        )
        public Result(@NotNull Location position, @NotNull ConfiguredStructure configuredStructure) {
            this((Position)position, (Structure)configuredStructure.toModern());
        }

        public Result(@NotNull Position pos, @NotNull Structure structure) {
            this.pos = pos;
            this.structure = structure;
        }

        /** @deprecated */
        @Deprecated(
                forRemoval = true
        )
        public @NotNull ConfiguredStructure configuredStructure() {
            return (ConfiguredStructure)Objects.requireNonNull(ConfiguredStructure.fromModern(this.structure), "Please use the newer Structure API");
        }

        /** @deprecated */
        @Deprecated(
                forRemoval = true
        )
        public @NotNull Location position() {
            return this.pos.toLocation((World)null);
        }

        public @NotNull Position pos() {
            return this.pos;
        }

        public @NotNull Structure structure() {
            return this.structure;
        }
    }
}

package dev.vulcanium.generator.structure;

import dev.vulcanium.util.BoundingBox;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an individual part of a {@link GeneratedStructure}.
 *
 * @see GeneratedStructure
 */
public interface StructurePiece {

    /**
     * Gets the bounding box of this structure piece.
     *
     * @return bounding box of this structure piece
     */
    @NotNull
    public BoundingBox getBoundingBox();
}
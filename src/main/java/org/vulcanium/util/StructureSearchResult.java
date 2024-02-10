package org.vulcanium.util;

import org.vulcanium.Location;
import org.vulcanium.World;
import org.vulcanium.generator.structure.Structure;
import org.vulcanium.generator.structure.StructureType;
import org.jetbrains.annotations.NotNull;

/**
 * Holds the result of searching for a structure.
 *
 * @see World#locateNearestStructure(Location, StructureType, int, boolean)
 */
public interface StructureSearchResult {

    /**
     * Return the structure which was found.
     *
     * @return the found structure.
     */
    @NotNull
    Structure getStructure();

    /**
     * Return the location of the structure.
     *
     * @return the location the structure was found.
     */
    @NotNull
    Location getLocation();
}

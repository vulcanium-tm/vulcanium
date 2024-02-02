package org.vulcanium.compatibility.bukkit;

import org.bukkit.Art;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

public class CompatibilityLayer {

    @Nullable
    public static Art getArtById(int id) {
        org.vulcanium.Art vulcaniumArt = org.vulcanium.Art.getById(id);
        if (vulcaniumArt != null) {
            // Return the Vulcanium Art if available
            return vulcaniumArt;
        } else {
            // Fallback to the original Bukkit implementation
            return Art.getById(id);
        }
    }

    @Nullable
    public static Art getArtByName(@NotNull String name) {
        org.vulcanium.Art vulcaniumArt = org.vulcanium.Art.getByName(name);
        return (vulcaniumArt != null) ? vulcaniumArt : Art.getByName(name);
    }
}
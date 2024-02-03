package org.vulcanium.projectiles;

import org.vulcanium.block.Block;
import org.jetbrains.annotations.NotNull;

public interface BlockProjectileSource extends ProjectileSource {

    /**
     * Gets the block this projectile source belongs to.
     *
     * @return Block for the projectile source
     */
    @NotNull
    public Block getBlock();
}

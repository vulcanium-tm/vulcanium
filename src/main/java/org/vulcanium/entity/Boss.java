package org.vulcanium.entity;

import org.vulcanium.boss.BossBar;
import org.jetbrains.annotations.Nullable;

/**
 * Represents the Boss Entity.
 */
public interface Boss extends Entity {

    /**
     * Returns the {@link BossBar} of the {@link Boss}
     *
     * @return the {@link BossBar} of the entity
     */
    @Nullable
    BossBar getBossBar();
}

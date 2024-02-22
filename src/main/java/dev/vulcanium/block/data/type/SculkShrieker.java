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
package dev.vulcanium.block.data.type;

import dev.vulcanium.block.data.Waterlogged;

/**
 * 'can_summon' indicates whether the sculk shrieker can summon the warden.
 * <p>
 * 'shrieking' indicated whether the sculk shrieker is shrieking or not.
 */
public interface SculkShrieker extends Waterlogged {

    /**
     * Gets the value of the 'can_summon' property.
     *
     * @return the 'can_summon' value
     */
    boolean isCanSummon();

    /**
     * Sets the value of the 'can_summon' property.
     *
     * @param can_summon the new 'can_summon' value
     */
    void setCanSummon(boolean can_summon);

    /**
     * Gets the value of the 'shrieking' property.
     *
     * @return the 'shrieking' value
     */
    boolean isShrieking();

    /**
     * Sets the value of the 'shrieking' property.
     *
     * @param shrieking the new 'shrieking' value
     */
    void setShrieking(boolean shrieking);
}

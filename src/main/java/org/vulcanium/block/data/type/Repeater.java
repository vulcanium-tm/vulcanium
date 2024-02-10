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
package org.vulcanium.block.data.type;

import org.vulcanium.block.data.Directional;
import org.vulcanium.block.data.Powerable;

/**
 * 'delay' is the propagation delay of a repeater, i.e. how many ticks before it
 * will be activated from a current change and propagate it to the next block.
 * <br>
 * Delay may not be lower than {@link #getMinimumDelay()} or higher than
 * {@link #getMaximumDelay()}.
 * <br>
 * 'locked' denotes whether the repeater is in the locked state or not.
 * <br>
 * A locked repeater will not change its output until it is unlocked. In game, a
 * locked repeater is created by having a constant current perpendicularly
 * entering the block.
 */
public interface Repeater extends Directional, Powerable {

    /**
     * Gets the value of the 'delay' property.
     *
     * @return the 'delay' value
     */
    int getDelay();

    /**
     * Sets the value of the 'delay' property.
     *
     * @param delay the new 'delay' value
     */
    void setDelay(int delay);

    /**
     * Gets the minimum allowed value of the 'delay' property.
     *
     * @return the minimum 'delay' value
     */
    int getMinimumDelay();

    /**
     * Gets the maximum allowed value of the 'delay' property.
     *
     * @return the maximum 'delay' value
     */
    int getMaximumDelay();

    /**
     * Gets the value of the 'locked' property.
     *
     * @return the 'locked' value
     */
    boolean isLocked();

    /**
     * Sets the value of the 'locked' property.
     *
     * @param locked the new 'locked' value
     */
    void setLocked(boolean locked);
}

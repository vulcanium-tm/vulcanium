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
package org.vulcanium.block.data;

/**
 * 'age' represents the different growth stages that a crop-like block can go
 * through.
 * <br>
 * A value of 0 indicates that the crop was freshly planted, whilst a value
 * equal to {@link #getMaximumAge()} indicates that the crop is ripe and ready
 * to be harvested.
 */
public interface Ageable extends BlockData {

    /**
     * Gets the value of the 'age' property.
     *
     * @return the 'age' value
     */
    int getAge();

    /**
     * Sets the value of the 'age' property.
     *
     * @param age the new 'age' value
     */
    void setAge(int age);

    /**
     * Gets the maximum allowed value of the 'age' property.
     *
     * @return the maximum 'age' value
     */
    int getMaximumAge();
}

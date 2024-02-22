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

import dev.vulcanium.block.data.Lightable;
import dev.vulcanium.block.data.Waterlogged;

/**
 * 'candles' represents the number of candles which are present.
 */
public interface Candle extends Lightable, Waterlogged {

    /**
     * Gets the value of the 'candles' property.
     *
     * @return the 'candles' value
     */
    int getCandles();

    /**
     * Sets the value of the 'candles' property.
     *
     * @param candles the new 'candles' value
     */
    void setCandles(int candles);

    /**
     * Gets the maximum allowed value of the 'candles' property.
     *
     * @return the maximum 'candles' value
     */
    int getMaximumCandles();
}

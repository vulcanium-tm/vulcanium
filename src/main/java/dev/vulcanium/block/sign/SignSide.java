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
package dev.vulcanium.block.sign;

import dev.vulcanium.material.Colorable;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a side of a sign.
 */
public interface SignSide extends Colorable {

    /**
     * Gets all the lines of text currently on this side of the sign.
     *
     * @return Array of Strings containing each line of text
     */
    @NotNull
    public String[] getLines();

    /**
     * Gets the line of text at the specified index on this side of the sign.
     * <p>
     * For example, getLine(0) will return the first line of text.
     *
     * @param index Line number to get the text from, starting at 0
     * @return Text on the given line
     * @throws IndexOutOfBoundsException Thrown when the line does not exist
     */
    @NotNull
    public String getLine(int index) throws IndexOutOfBoundsException;

    /**
     * Sets the line of text at the specified index on this side of the sign.
     * <p>
     * For example, setLine(0, "Line One") will set the first line of text to
     * "Line One".
     *
     * @param index Line number to set the text at, starting from 0
     * @param line New text to set at the specified index
     * @throws IndexOutOfBoundsException If the index is out of the range 0..3
     */
    public void setLine(int index, @NotNull String line) throws IndexOutOfBoundsException;

    /**
     * Gets whether this side of the sign has glowing text.
     *
     * @return if this side of the sign has glowing text
     */
    public boolean isGlowingText();

    /**
     * Sets whether this side of the sign has glowing text.
     *
     * @param glowing if this side of the sign has glowing text
     */
    public void setGlowingText(boolean glowing);
}

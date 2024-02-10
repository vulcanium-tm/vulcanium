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

import org.jetbrains.annotations.NotNull;
import org.vulcanium.Instrument;
import org.vulcanium.Note;
import org.vulcanium.block.data.Powerable;

/**
 * 'instrument' is the type of sound made when this note block is activated.
 * <br>
 * 'note' is the specified tuned pitch that the instrument will be played in.
 */
public interface NoteBlock extends Powerable {

    /**
     * Gets the value of the 'instrument' property.
     *
     * @return the 'instrument' value
     */
    @NotNull
    Instrument getInstrument();

    /**
     * Sets the value of the 'instrument' property.
     *
     * @param instrument the new 'instrument' value
     */
    void setInstrument(@NotNull Instrument instrument);

    /**
     * Gets the value of the 'note' property.
     *
     * @return the 'note' value
     */
    @NotNull
    Note getNote();

    /**
     * Sets the value of the 'note' property.
     *
     * @param note the new 'note' value
     */
    void setNote(@NotNull Note note);
}

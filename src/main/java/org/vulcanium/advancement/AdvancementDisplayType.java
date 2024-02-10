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
package org.vulcanium.advancement;

import org.jetbrains.annotations.NotNull;
import org.vulcanium.ChatColor;

/**
 * Advancements are displayed in different ways depending on their display type.
 *
 * This enum contains information about these types and how they are
 * represented.
 */
public enum AdvancementDisplayType {

    /**
     * Task or normal icons have a square icon frame.
     */
    TASK(ChatColor.GREEN),
    /**
     * Challenge icons have a stylised icon frame.
     */
    CHALLENGE(ChatColor.DARK_PURPLE),
    /**
     * Goal icons have a rounded icon frame.
     */
    GOAL(ChatColor.GREEN);
    private final ChatColor color;

    private AdvancementDisplayType(ChatColor color) {
        this.color = color;
    }

    /**
     * The chat color used by Minecraft for this advancement.
     *
     * @return The chat color used by this advancement type.
     */
    @NotNull
    public ChatColor getColor() {
        return color;
    }
}

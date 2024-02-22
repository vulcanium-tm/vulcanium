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
package dev.vulcanium.advancement;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.translation.Translatable;
import net.kyori.adventure.util.Index;
import dev.vulcanium.namespaced.NamespacedKey;
import dev.vulcanium.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AdvancementDisplay {
    @NotNull Frame frame();

    @NotNull Component title();

    @NotNull Component description();

    @NotNull ItemStack icon();

    boolean doesShowToast();

    boolean doesAnnounceToChat();

    boolean isHidden();

    @Nullable NamespacedKey backgroundPath();

    @NotNull Component displayName();

    public static enum Frame implements Translatable {
        CHALLENGE("challenge", NamedTextColor.DARK_PURPLE),
        GOAL("goal", NamedTextColor.GREEN),
        TASK("task", NamedTextColor.GREEN);

        public static final Index<String, Frame> NAMES = Index.create(Frame.class, (frame) -> {
            return frame.name;
        });
        private final String name;
        private final TextColor color;

        private Frame(String name, TextColor color) {
            this.name = name;
            this.color = color;
        }

        public @NotNull TextColor color() {
            return this.color;
        }

        public @NotNull String translationKey() {
            return "advancements.toast." + this.name;
        }
    }
}

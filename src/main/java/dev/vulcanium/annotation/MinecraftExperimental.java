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
package dev.vulcanium.annotation;

import org.jetbrains.annotations.ApiStatus.Internal;

import java.lang.annotation.*;

/**
 * Indicates that the annotated element (class, method, field, etc.) is part of a
 * <a href="https://minecraft.wiki/w/Experimental_Gameplay">minecraft experimental feature</a>
 * and is subject to changes by Mojang.
 * <p>
 * <b>Note:</b> Elements marked with this annotation require the use of a datapack or otherwise
 * non-standard feature to be enabled on the server.
 *
 * @see <a href="https://www.minecraft.net/en-us/article/testing-new-minecraft-features/feature-toggles-java-edition">Features Toggles - Minecraft Article</a>
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@Internal
public @interface MinecraftExperimental {
    String value() default "";
}
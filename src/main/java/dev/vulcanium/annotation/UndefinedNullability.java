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

import org.jetbrains.annotations.ApiStatus;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for types, whose nullability is not well defined, so
 * {@link org.jetbrains.annotations.NotNull} nor
 * {@link org.jetbrains.annotations.Nullable} is applicable. For example when
 * interface defines a method, whose nullability depends on the implementation.
 *
 * This should generally not be used in any new API code as it
 * suggests a bad API design.
 */
@Retention(RetentionPolicy.CLASS)
@ApiStatus.Internal
public @interface UndefinedNullability {

    /**
     * Human readable description of the circumstances, in which the type is
     * nullable.
     *
     * @return description
     */
    String value() default "";
}

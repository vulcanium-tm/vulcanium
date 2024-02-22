package dev.vulcanium.annotation;

import org.jetbrains.annotations.ApiStatus.Internal;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Internal
public @interface GeneratedFrom {
    String value();
}

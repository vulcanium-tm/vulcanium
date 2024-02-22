package dev.vulcanium.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.METHOD})
public @interface Range {
    long from() default Long.MIN_VALUE;
    long to() default Long.MAX_VALUE;
}
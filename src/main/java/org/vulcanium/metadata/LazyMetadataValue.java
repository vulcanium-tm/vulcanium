package org.vulcanium.metadata;

import org.vulcanium.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.Callable;

public class LazyMetadataValue extends MetadataValueAdapter {
    private Callable<Object> lazyValue;
    private CacheStrategy cacheStrategy;
    private Object internalValue = null;

    /**
     * Initializes a LazyMetadataValue object with the default CACHE_AFTER_FIRST_EVAL cache strategy.
     */
    public LazyMetadataValue(@NotNull Plugin owningPlugin, @NotNull Callable<Object> lazyValue) {
        this(owningPlugin, CacheStrategy.CACHE_AFTER_FIRST_EVAL, lazyValue);
    }

    /**
     * Initializes a LazyMetadataValue object with a specific cache strategy.
     */
    public LazyMetadataValue(@NotNull Plugin owningPlugin, @NotNull CacheStrategy cacheStrategy, @NotNull Callable<Object> lazyValue) {
        super(owningPlugin);
        this.lazyValue = lazyValue;
        this.cacheStrategy = cacheStrategy;
    }

    @Override
    @Nullable
    public Object value() {
        if (internalValue == null || cacheStrategy == CacheStrategy.NEVER_CACHE) {
            try {
                internalValue = lazyValue.call();
            } catch (Exception e) {
                throw new MetadataEvaluationException(e);
            }
        }
        return internalValue;
    }

    @Override
    public void invalidate() {
        if (cacheStrategy != CacheStrategy.CACHE_ETERNALLY) {
            internalValue = null;
        }
    }
    /**
     * Describes possible caching strategies for metadata.
     */
    public enum CacheStrategy {
        /**
         * Once the metadata value has been evaluated, do not re-evaluate the
         * value until it is manually invalidated.
         */
        CACHE_AFTER_FIRST_EVAL,

        /**
         * Re-evaluate the metadata item every time it is requested
         */
        NEVER_CACHE,

        /**
         * Once the metadata value has been evaluated, do not re-evaluate the
         * value in spite of manual invalidation.
         */
        CACHE_ETERNALLY
    }
}

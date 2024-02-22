package dev.vulcanium.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.LongAdder;

public class CachedSizeConcurrentLinkedQueue<E> extends ConcurrentLinkedQueue<E> {
    private final LongAdder cachedSize = new LongAdder();

    public CachedSizeConcurrentLinkedQueue() {
    }

    public boolean add(@NotNull E e) {
        boolean result = super.add(e);
        if (result) {
            this.cachedSize.increment();
        }

        return result;
    }

    public @Nullable E poll() {
        E result = super.poll();
        if (result != null) {
            this.cachedSize.decrement();
        }

        return result;
    }

    public int size() {
        return this.cachedSize.intValue();
    }
}

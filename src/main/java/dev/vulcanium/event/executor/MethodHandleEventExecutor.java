package dev.vulcanium.event.executor;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.Listener;
import dev.vulcanium.plugin.EventExecutor;
import dev.vulcanium.util.SneakyThrow;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

public abstract class MethodHandleEventExecutor implements EventExecutor {
    private final Class<? extends Event> eventClass;
    private final MethodHandle handle;
    private final Method method;

    public MethodHandleEventExecutor(@NotNull Class<? extends Event> eventClass, @NotNull MethodHandle handle) {
        this.eventClass = eventClass;
        this.handle = handle;
        this.method = null;
    }

    public MethodHandleEventExecutor(@NotNull Class<? extends Event> eventClass, @NotNull Method m) {
        this.eventClass = eventClass;

        try {
            m.setAccessible(true);
            this.handle = MethodHandles.lookup().unreflect(m);
        } catch (IllegalAccessException var4) {
            throw new AssertionError("Unable to set accessible", var4);
        }

        this.method = m;
    }

    @SneakyThrows
    public void execute(@NotNull Listener listener, @NotNull Event event) {
        if (this.eventClass.isInstance(event)) {
            try {
                this.handle.invoke(listener, event);
            } catch (Throwable var4) {
                SneakyThrow.sneaky(var4);
            }

        }
    }

    public @NotNull String toString() {
        return "MethodHandleEventExecutor['" + this.method + "']";
    }
}

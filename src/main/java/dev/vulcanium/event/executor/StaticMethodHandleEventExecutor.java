package dev.vulcanium.event.executor;

import com.google.common.base.Preconditions;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.event.Event;
import dev.vulcanium.event.EventException;
import dev.vulcanium.event.Listener;
import dev.vulcanium.plugin.EventExecutor;
import dev.vulcanium.util.SneakyThrow;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class StaticMethodHandleEventExecutor implements EventExecutor {
    private final Class<? extends Event> eventClass;
    private final MethodHandle handle;
    private final Method method;

    public StaticMethodHandleEventExecutor(@NotNull Class<? extends Event> eventClass, @NotNull Method m) {
        Preconditions.checkArgument(Modifier.isStatic(m.getModifiers()), "Not a static method: %s", m);
        Preconditions.checkArgument(eventClass != null, "eventClass is null");
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
    public void execute(@NotNull Listener listener, @NotNull Event event) throws EventException {
        if (this.eventClass.isInstance(event)) {
            try {
                this.handle.invoke(listener, event);
            } catch (Throwable var4) {
                SneakyThrow.sneaky(var4);
            }

        }
    }

    public @NotNull String toString() {
        return "StaticMethodHandleEventExecutor['" + this.method + "']";
    }
}

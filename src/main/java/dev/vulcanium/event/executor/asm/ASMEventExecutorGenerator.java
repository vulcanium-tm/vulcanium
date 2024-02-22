package dev.vulcanium.event.executor.asm;

import dev.vulcanium.plugin.EventExecutor;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

public class ASMEventExecutorGenerator {
    private static final String EXECUTE_DESCRIPTOR = "(Lorg/vulcanium/event/Listener;Lorg/vulcanium/event/Event;)V";
    public static AtomicInteger NEXT_ID = new AtomicInteger(1);

    public ASMEventExecutorGenerator() {
    }

    public static @NotNull byte[] generateEventExecutor(@NotNull Method m, @NotNull String name) {
        ClassWriter writer = new ClassWriter(3);
        writer.visit(52, 1, name.replace('.', '/'), (String)null, Type.getInternalName(Object.class), new String[]{Type.getInternalName(EventExecutor.class)});
        GeneratorAdapter methodGenerator = new GeneratorAdapter(writer.visitMethod(1, "<init>", "()V", (String)null, (String[])null), 1, "<init>", "()V");
        methodGenerator.loadThis();
        methodGenerator.visitMethodInsn(183, Type.getInternalName(Object.class), "<init>", "()V", false);
        methodGenerator.returnValue();
        methodGenerator.endMethod();
        methodGenerator = new GeneratorAdapter(writer.visitMethod(1, "execute", "(Lorg/bukkit/event/Listener;Lorg/bukkit/event/Event;)V", (String)null, (String[])null), 1, "execute", "(Lorg/bukkit/event/Listener;Lorg/bukkit/event/Event;)V");
        methodGenerator.loadArg(0);
        methodGenerator.checkCast(Type.getType(m.getDeclaringClass()));
        methodGenerator.loadArg(1);
        methodGenerator.checkCast(Type.getType(m.getParameterTypes()[0]));
        methodGenerator.visitMethodInsn(m.getDeclaringClass().isInterface() ? 185 : 182, Type.getInternalName(m.getDeclaringClass()), m.getName(), Type.getMethodDescriptor(m), m.getDeclaringClass().isInterface());
        switch (Type.getType(m.getReturnType()).getSize()) {
            case 1:
                methodGenerator.pop();
                break;
            case 2:
                methodGenerator.pop2();
        }

        methodGenerator.returnValue();
        methodGenerator.endMethod();
        writer.visitEnd();
        return writer.toByteArray();
    }

    public static @NotNull String generateName() {
        int id = NEXT_ID.getAndIncrement();
        return "org.vulcanium.event.executor.asm.generated.GeneratedEventExecutor" + id;
    }
}


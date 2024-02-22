package dev.vulcanium.plugin.provider.util;

import dev.vulcanium.util.SneakyThrow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public class ProviderUtil {
    public ProviderUtil() {
    }

    public static <T> @NotNull T loadClass(@NotNull String clazz, @NotNull Class<T> classType, @NotNull ClassLoader loader) {
        return loadClass(clazz, classType, loader, (Runnable)null);
    }

    public static <T> @NotNull T loadClass(@NotNull String clazz, @NotNull Class<T> classType, @NotNull ClassLoader loader, @Nullable Runnable onError) {
        try {
            Object clazzInstance;
            try {
                Class<?> jarClass = Class.forName(clazz, true, loader);

                Class pluginClass;
                try {
                    pluginClass = jarClass.asSubclass(classType);
                } catch (ClassCastException var8) {
                    throw new ClassCastException("class '%s' does not extend '%s'".formatted(clazz, classType));
                }

                clazzInstance = pluginClass.getDeclaredConstructor().newInstance();
            } catch (IllegalAccessException var9) {
                throw new RuntimeException("No public constructor");
            } catch (InstantiationException var10) {
                throw new RuntimeException("Abnormal class instantiation", var10);
            }

            return (T) clazzInstance;
        } catch (Throwable var11) {
            if (onError != null) {
                onError.run();
            }

            try {
                SneakyThrow.sneaky(var11);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
            throw new AssertionError();
        }
    }
}

package dev.vulcanium.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.jar.Manifest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class JarManifests {
    private static final Map<ClassLoader, Manifest> MANIFESTS = Collections.synchronizedMap(new WeakHashMap());

    private JarManifests() {
    }

    public static @Nullable Manifest manifest(@NotNull Class<?> clazz) {
        return (Manifest)MANIFESTS.computeIfAbsent(clazz.getClassLoader(), (classLoader) -> {
            String var10000 = clazz.getName();
            String classLocation = "/" + var10000.replace(".", "/") + ".class";
            URL resource = clazz.getResource(classLocation);
            if (resource == null) {
                return null;
            } else {
                String classFilePath = resource.toString().replace("\\", "/");
                String archivePath = classFilePath.substring(0, classFilePath.length() - classLocation.length());

                try {
                    InputStream stream = (new URL(archivePath + "/META-INF/MANIFEST.MF")).openStream();

                    Manifest var7;
                    try {
                        var7 = new Manifest(stream);
                    } catch (Throwable var10) {
                        if (stream != null) {
                            try {
                                stream.close();
                            } catch (Throwable var9) {
                                var10.addSuppressed(var9);
                            }
                        }

                        throw var10;
                    }

                    if (stream != null) {
                        stream.close();
                    }

                    return var7;
                } catch (IOException var11) {
                    return null;
                }
            }
        });
    }
}

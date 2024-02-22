package dev.vulcanium.core;

import java.lang.reflect.Method;

public final class Main {
    public Main() {
    }

    public static void main(String[] args) {
        if (getJavaVersion() < 17) {
            System.err.println("Minecraft 1.20 requires running the server with Java 17 or above. Download Java 17 (or above) from https://adoptium.net/");
            System.exit(1);
        }

        try {
            Class<?> paperclipClass = Class.forName("dev.vulcanium.core.VulcaniumCore");
            Method mainMethod = paperclipClass.getMethod("main", String[].class);
            mainMethod.invoke((Object)null, args);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    private static int getJavaVersion() {
        String version = System.getProperty("java.specification.version");
        String[] parts = version.split("\\.");
        String errorMsg = "Could not determine version of the current JVM";
        if (parts.length == 0) {
            throw new IllegalStateException("Could not determine version of the current JVM");
        } else if (parts[0].equals("1")) {
            if (parts.length < 2) {
                throw new IllegalStateException("Could not determine version of the current JVM");
            } else {
                return Integer.parseInt(parts[1]);
            }
        } else {
            return Integer.parseInt(parts[0]);
        }
    }
}

package dev.vulcanium.text;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.flattener.ComponentFlattener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import dev.vulcanium.Vulcanium;
import dev.vulcanium.command.CommandSender;
import dev.vulcanium.entity.Entity;

import java.io.IOException;

public final class VulcaniumComponents {
    private VulcaniumComponents() {
        throw new RuntimeException("VulcaniumComponents is not to be instantiated!");
    }

    public static @NotNull Component resolveWithContext(@NotNull Component input, @Nullable CommandSender context, @Nullable Entity scoreboardSubject) throws IOException {
        return resolveWithContext(input, context, scoreboardSubject, true);
    }

    public static @NotNull Component resolveWithContext(@NotNull Component input, @Nullable CommandSender context, @Nullable Entity scoreboardSubject, boolean bypassPermissions) throws IOException {
        return Vulcanium.getUnsafe().resolveWithContext(input, context, scoreboardSubject, bypassPermissions);
    }

    public static @NotNull ComponentFlattener flattener() {
        return Vulcanium.getUnsafe().componentFlattener();
    }
}

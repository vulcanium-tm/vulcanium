package dev.vulcanium.scheduler;

import java.util.function.Consumer;
import dev.vulcanium.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface EntityScheduler {
    boolean execute(@NotNull Plugin var1, @NotNull Runnable var2, @Nullable Runnable var3, long var4);

    @Nullable ScheduledTask run(@NotNull Plugin var1, @NotNull Consumer<ScheduledTask> var2, @Nullable Runnable var3);

    @Nullable ScheduledTask runDelayed(@NotNull Plugin var1, @NotNull Consumer<ScheduledTask> var2, @Nullable Runnable var3, long var4);

    @Nullable ScheduledTask runAtFixedRate(@NotNull Plugin var1, @NotNull Consumer<ScheduledTask> var2, @Nullable Runnable var3, long var4, long var6);
}

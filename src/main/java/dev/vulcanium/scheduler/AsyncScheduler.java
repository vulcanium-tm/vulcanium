package dev.vulcanium.scheduler;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import dev.vulcanium.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public interface AsyncScheduler {
    @NotNull ScheduledTask runNow(@NotNull Plugin var1, @NotNull Consumer<ScheduledTask> var2);

    @NotNull ScheduledTask runDelayed(@NotNull Plugin var1, @NotNull Consumer<ScheduledTask> var2, long var3, @NotNull TimeUnit var5);

    @NotNull ScheduledTask runAtFixedRate(@NotNull Plugin var1, @NotNull Consumer<ScheduledTask> var2, long var3, long var5, @NotNull TimeUnit var7);

    void cancelTasks(@NotNull Plugin var1);
}

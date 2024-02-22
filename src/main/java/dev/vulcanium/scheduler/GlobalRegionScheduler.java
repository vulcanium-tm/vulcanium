package dev.vulcanium.scheduler;

import java.util.function.Consumer;
import dev.vulcanium.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public interface GlobalRegionScheduler {
    void execute(@NotNull Plugin var1, @NotNull Runnable var2);

    @NotNull ScheduledTask run(@NotNull Plugin var1, @NotNull Consumer<ScheduledTask> var2);

    @NotNull ScheduledTask runDelayed(@NotNull Plugin var1, @NotNull Consumer<ScheduledTask> var2, long var3);

    @NotNull ScheduledTask runAtFixedRate(@NotNull Plugin var1, @NotNull Consumer<ScheduledTask> var2, long var3, long var5);

    void cancelTasks(@NotNull Plugin var1);
}

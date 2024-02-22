package dev.vulcanium.scheduler;

import dev.vulcanium.Location;
import dev.vulcanium.world.World;
import org.jetbrains.annotations.NotNull;
import dev.vulcanium.plugin.Plugin;

import java.util.function.Consumer;

public interface RegionScheduler {
    void execute(@NotNull Plugin var1, @NotNull World var2, int var3, int var4, @NotNull Runnable var5);

    default void execute(@NotNull Plugin plugin, @NotNull Location location, @NotNull Runnable run) {
        this.execute(plugin, location.getWorld(), location.getBlockX() >> 4, location.getBlockZ() >> 4, run);
    }

    @NotNull ScheduledTask run(@NotNull Plugin var1, @NotNull World var2, int var3, int var4, @NotNull Consumer<ScheduledTask> var5);

    default @NotNull ScheduledTask run(@NotNull Plugin plugin, @NotNull Location location, @NotNull Consumer<ScheduledTask> task) {
        return this.run(plugin, location.getWorld(), location.getBlockX() >> 4, location.getBlockZ() >> 4, task);
    }

    @NotNull ScheduledTask runDelayed(@NotNull Plugin var1, @NotNull World var2, int var3, int var4, @NotNull Consumer<ScheduledTask> var5, long var6);

    default @NotNull ScheduledTask runDelayed(@NotNull Plugin plugin, @NotNull Location location, @NotNull Consumer<ScheduledTask> task, long delayTicks) {
        return this.runDelayed(plugin, location.getWorld(), location.getBlockX() >> 4, location.getBlockZ() >> 4, task, delayTicks);
    }

    @NotNull ScheduledTask runAtFixedRate(@NotNull Plugin var1, @NotNull World var2, int var3, int var4, @NotNull Consumer<ScheduledTask> var5, long var6, long var8);

    default @NotNull ScheduledTask runAtFixedRate(@NotNull Plugin plugin, @NotNull Location location, @NotNull Consumer<ScheduledTask> task, long initialDelayTicks, long periodTicks) {
        return this.runAtFixedRate(plugin, location.getWorld(), location.getBlockX() >> 4, location.getBlockZ() >> 4, task, initialDelayTicks, periodTicks);
    }
}

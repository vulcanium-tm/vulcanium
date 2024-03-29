package dev.vulcanium.scheduler;

import dev.vulcanium.Vulcanium;
import dev.vulcanium.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * This class is provided as an easy way to handle scheduling tasks.
 */
public abstract class VulcaniumRunnable implements Runnable {
    private VulcaniumTask task;

    /**
     * Returns true if this task has been cancelled.
     *
     * @return true if the task has been cancelled
     * @throws IllegalStateException if task was not scheduled yet
     */
    public synchronized boolean isCancelled() throws IllegalStateException {
        checkScheduled();
        return task.isCancelled();
    }

    /**
     * Attempts to cancel this task.
     *
     * @throws IllegalStateException if task was not scheduled yet
     */
    public synchronized void cancel() throws IllegalStateException {
        Vulcanium.getScheduler().cancelTask(getTaskId());
    }

    /**
     * Schedules this in the Vulcanium scheduler to run on next tick.
     *
     * @param plugin the reference to the plugin scheduling task
     * @return a VulcaniumTask that contains the id number
     * @throws IllegalArgumentException if plugin is null
     * @throws IllegalStateException if this was already scheduled
     * @see VulcaniumScheduler#runTask(Plugin, Runnable)
     */
    @NotNull
    public synchronized VulcaniumTask runTask(@NotNull Plugin plugin) throws IllegalArgumentException, IllegalStateException {
        checkNotYetScheduled();
        return setupTask(Vulcanium.getScheduler().runTask(plugin, (Runnable) this));
    }

    /**
     * <b>Asynchronous tasks should never access any API in Vulcanium. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Schedules this in the Vulcanium scheduler to run asynchronously.
     *
     * @param plugin the reference to the plugin scheduling task
     * @return a VulcaniumTask that contains the id number
     * @throws IllegalArgumentException if plugin is null
     * @throws IllegalStateException if this was already scheduled
     * @see VulcaniumScheduler#runTaskAsynchronously(Plugin, Runnable)
     */
    @NotNull
    public synchronized VulcaniumTask runTaskAsynchronously(@NotNull Plugin plugin) throws IllegalArgumentException, IllegalStateException {
        checkNotYetScheduled();
        return setupTask(Vulcanium.getScheduler().runTaskAsynchronously(plugin, (Runnable) this));
    }

    /**
     * Schedules this to run after the specified number of server ticks.
     *
     * @param plugin the reference to the plugin scheduling task
     * @param delay the ticks to wait before running the task
     * @return a VulcaniumTask that contains the id number
     * @throws IllegalArgumentException if plugin is null
     * @throws IllegalStateException if this was already scheduled
     * @see VulcaniumScheduler#runTaskLater(Plugin, Runnable, long)
     */
    @NotNull
    public synchronized VulcaniumTask runTaskLater(@NotNull Plugin plugin, long delay) throws IllegalArgumentException, IllegalStateException {
        checkNotYetScheduled();
        return setupTask(Vulcanium.getScheduler().runTaskLater(plugin, (Runnable) this, delay));
    }

    /**
     * <b>Asynchronous tasks should never access any API in Vulcanium. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Schedules this to run asynchronously after the specified number of
     * server ticks.
     *
     * @param plugin the reference to the plugin scheduling task
     * @param delay the ticks to wait before running the task
     * @return a VulcaniumTask that contains the id number
     * @throws IllegalArgumentException if plugin is null
     * @throws IllegalStateException if this was already scheduled
     * @see VulcaniumScheduler#runTaskLaterAsynchronously(Plugin, Runnable, long)
     */
    @NotNull
    public synchronized VulcaniumTask runTaskLaterAsynchronously(@NotNull Plugin plugin, long delay) throws IllegalArgumentException, IllegalStateException {
        checkNotYetScheduled();
        return setupTask(Vulcanium.getScheduler().runTaskLaterAsynchronously(plugin, (Runnable) this, delay));
    }

    /**
     * Schedules this to repeatedly run until cancelled, starting after the
     * specified number of server ticks.
     *
     * @param plugin the reference to the plugin scheduling task
     * @param delay the ticks to wait before running the task
     * @param period the ticks to wait between runs
     * @return a VulcaniumTask that contains the id number
     * @throws IllegalArgumentException if plugin is null
     * @throws IllegalStateException if this was already scheduled
     * @see VulcaniumScheduler#runTaskTimer(Plugin, Runnable, long, long)
     */
    @NotNull
    public synchronized VulcaniumTask runTaskTimer(@NotNull Plugin plugin, long delay, long period) throws IllegalArgumentException, IllegalStateException {
        checkNotYetScheduled();
        return setupTask(Vulcanium.getScheduler().runTaskTimer(plugin, (Runnable) this, delay, period));
    }

    /**
     * <b>Asynchronous tasks should never access any API in Vulcanium. Great care
     * should be taken to assure the thread-safety of asynchronous tasks.</b>
     * <p>
     * Schedules this to repeatedly run asynchronously until cancelled,
     * starting after the specified number of server ticks.
     *
     * @param plugin the reference to the plugin scheduling task
     * @param delay the ticks to wait before running the task for the first
     *     time
     * @param period the ticks to wait between runs
     * @return a VulcaniumTask that contains the id number
     * @throws IllegalArgumentException if plugin is null
     * @throws IllegalStateException if this was already scheduled
     * @see VulcaniumScheduler#runTaskTimerAsynchronously(Plugin, Runnable, long,
     *     long)
     */
    @NotNull
    public synchronized VulcaniumTask runTaskTimerAsynchronously(@NotNull Plugin plugin, long delay, long period) throws IllegalArgumentException, IllegalStateException {
        checkNotYetScheduled();
        return setupTask(Vulcanium.getScheduler().runTaskTimerAsynchronously(plugin, (Runnable) this, delay, period));
    }

    /**
     * Gets the task id for this runnable.
     *
     * @return the task id that this runnable was scheduled as
     * @throws IllegalStateException if task was not scheduled yet
     */
    public synchronized int getTaskId() throws IllegalStateException {
        checkScheduled();
        return task.getTaskId();
    }

    private void checkScheduled() {
        if (task == null) {
            throw new IllegalStateException("Not scheduled yet");
        }
    }

    private void checkNotYetScheduled() {
        if (task != null) {
            throw new IllegalStateException("Already scheduled as " + task.getTaskId());
        }
    }

    @NotNull
    private VulcaniumTask setupTask(@NotNull final VulcaniumTask task) {
        this.task = task;
        return task;
    }
}

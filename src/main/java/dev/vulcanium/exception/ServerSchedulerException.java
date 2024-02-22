package dev.vulcanium.exception;

import com.google.common.base.Preconditions;
import dev.vulcanium.scheduler.VulcaniumTask;

public class ServerSchedulerException extends ServerPluginException {
    private final VulcaniumTask task;

    public ServerSchedulerException(String message, Throwable cause, VulcaniumTask task) {
        super(message, cause, task.getOwner());
        this.task = (VulcaniumTask)Preconditions.checkNotNull(task, "task");
    }

    public ServerSchedulerException(Throwable cause, VulcaniumTask task) {
        super(cause, task.getOwner());
        this.task = (VulcaniumTask)Preconditions.checkNotNull(task, "task");
    }

    protected ServerSchedulerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, VulcaniumTask task) {
        super(message, cause, enableSuppression, writableStackTrace, task.getOwner());
        this.task = (VulcaniumTask)Preconditions.checkNotNull(task, "task");
    }

    public VulcaniumTask getTask() {
        return this.task;
    }
}

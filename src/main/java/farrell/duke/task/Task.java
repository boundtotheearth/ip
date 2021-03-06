package main.java.farrell.duke.task;

/**
 * Encapsulates data common to a task.
 * This is the base class that all tasks inherit from.
 */
public class Task {
    /** The type of task involved */
    protected TaskType taskType;

    /** The task's details */
    protected String description;

    /** The completion status of the task */
    protected boolean isDone;

    Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public String getDescription() {
        return description;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public boolean isDone() {
        return isDone;
    }

    /**
     * Changes the completion status of the task.
     *
     * @param done The new status of the task.
     */
    public void markAsDone(boolean done) {
        isDone = done;
    }

    /**
     * Formats the completion status of the task in a pretty way.
     *
     * @return The formatted string.
     */
    public String getStatusString() {
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Converts the object to a formatted string to act as savable data.
     * @return The formatted string to be saved.
     */
    public String convertToData() {
        return (isDone ? "true" : "false") + "|"
                + description;
    }

    @Override
    public String toString() {
        return "[" + getStatusString() + "]" + " " + description;
    }
}

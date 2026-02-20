package seedu.doraemon;
/**
 * Represents a generic task with a description and completion status.
 */
public abstract class Task {
    protected final int priority;
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a new Task with the given description and priority.
     * The task is initially marked as not done.
     *
     * @param description The description of the task
     * @param priority The priority level (1 = highest, 2 = medium, 3 = lowest)
     */
    public Task(String description, int priority) {
        this.description = description;
        this.isDone = false;
        this.priority = priority;
    }

    /**
     * Returns a string representation of this task in a format
     * suitable for saving to a file.
     *
     * @return The file storage format of the task
     */
    public abstract String toFileFormat();
    /**
     * Returns the status icon of this task for file storage.
     * A completed task is represented by "1", and an incomplete task by "0".
     *
     * @return The status icon used in file format
     */
    protected String getSatusIconForFuile() {
        return (isDone ? "1" : "0");
    }
    /**
     * Returns a user-friendly string representation of this task.
     *
     * @return A string representation for display
     */
    public String toString() {
        return this.getSatusIcon() + description;
    }
    /**
     * Returns whether this task is marked as done.
     *
     * @return True if the task is completed, false otherwise
     */
    public boolean isDone() {
        return isDone;
    }
    /**
     * Returns the status icon used for displaying this task.
     * "[X]" indicates done, and "[ ]" indicates not done.
     *
     * @return The display status icon of the task
     */
    public String getSatusIcon() {
        return (isDone ? "[X]" : "[ ]");
    }
    /**
     * Returns the description of this task.
     *
     * @return The task description
     */
    public String getDescription() {
        return description;
    }
    /**
     * Marks this task as completed.
     */
    public void markAsDone() {
        isDone = true;
    }
    /**
     * Marks this task as not completed.
     */
    public void unMark() {
        isDone = false;
    }

    public int getPriority() {
        return priority;
    }

}

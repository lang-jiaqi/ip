package seedu.doraemon;


import java.time.LocalDate;

/**
 * Represents a task that must be completed before a specific deadline.
 */
public class Deadline extends Task {
    protected String by;

    /**
     * A class that represents the deadline tasks
     * @param description
     * @param priority
     * @param by
     */
    public Deadline(String description, int priority, LocalDate by) {
        super(description, priority);
        this.by = by.toString();
    }
    @Override
    public String toFileFormat() {
        return "D | " + getSatusIconForFuile() + " | " + description + " | " + by + " | " + priority;
    }
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")" + "*" + priority + "*";
    }
    @Override
    public String getSatusIcon() {
        return (isDone ? "[X]" : "[ ]");
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public void markAsDone() {
        isDone = true;
    }
    @Override
    public void unMark() {
        isDone = false;
    }
    @Override
    public int getPriority() {
        return priority;
    }

}


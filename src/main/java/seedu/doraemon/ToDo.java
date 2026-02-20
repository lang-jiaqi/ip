
package seedu.doraemon;

/**
 * Represents a todo task without any date or time.
 */

public class ToDo extends Task {

    public ToDo(String description, int priority) {
        super(description, priority);
    }
    @Override
    public String toFileFormat() {
        return "T | " + getSatusIconForFuile() + " | " + description + " | " + priority;
    }
    @Override
    public String toString() {
        return "[T]" + super.toString() + "*" + priority + "*";
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



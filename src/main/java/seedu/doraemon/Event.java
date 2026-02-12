package seedu.doraemon;

import java.time.LocalDate;

/**
 * Represents an event task with a start time and an end time.
 */

public class Event extends Task {
    protected String from;
    protected String to;

    /**
     * A class that represents events with start and end time
     * @param description
     * @param priority
     * @param startdate
     * @param enddate
     */
    public Event(String description, int priority, LocalDate startdate, LocalDate enddate) {
        super(description, priority);
        this.from = startdate.toString();
        this.to = enddate.toString();
    }
    @Override
    public String toFileFormat() {
        return "E | " + getSatusIconForFuile() + " | " + description + " | " + from + " | " + to + " | " + priority;
    }
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + ", to: " + to + ")" + "*" + priority + "*";
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

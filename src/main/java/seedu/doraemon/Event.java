package seedu.doraemon;

import java.time.LocalDate;

/**
 * Represents an event task with a start time and an end time.
 */

public class Event extends Task {
    protected String from;
    protected String to;

    /**
     * Constructs a new Event task with the given description, start date, and end date.
     *
     * @param description The description of the event task
     * @param startdate The start date of the event
     * @param enddate The end date of the event
     */
    public Event(String description, LocalDate startdate, LocalDate enddate) {
        super(description);
        this.from = startdate.toString();
        this.to = enddate.toString();
    }
    @Override
    public String toFileFormat() {
        return "E | " + getSatusIconForFuile() + " | " + description + " | " + from + " | " + to;
    }
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + ", to: " + to + ")";
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

}


package seedu.doraemon;

import java.time.LocalDate;

/**
 * Represents an event task with a start time and an end time.
 */

public class Event extends Task {
    protected String from;
    protected String to;

    public Event(String description, LocalDate startdate, LocalDate enddate) {
        super(description);
        this.from = from;
        this.to = to;
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
    public String getSatusIcon(){
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
    public void Unmark() {
        isDone = false;
    }

}
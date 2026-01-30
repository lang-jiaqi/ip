<<<<<<< HEAD:src/main/java/doraemon/ToDo.java
package doraemon;
=======
package seedu.doraemon;
>>>>>>> branch-A-JavaDoc:src/main/java/seedu/doraemon/ToDo.java

/**
 * Represents a todo task without any date or time.
 */

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }
    @Override
    public String toFileFormat() {
        return "T | " + getSatusIconForFuile() + " | " + description;
    }
    @Override
    public String toString() {
        return "[T]" + super.toString();
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



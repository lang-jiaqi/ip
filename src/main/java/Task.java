public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public abstract String toFileFormat();

    protected String getSatusIconForFuile() {
        return (isDone ? "1" : "0");
    }

    public String toString() {
        return  this.getSatusIcon() + description;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getSatusIcon(){
        return (isDone ? "[X]" : "[ ]");
    }

    public String getDescription() {
        return description;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void Unmark() {
        isDone = false;
    }

}

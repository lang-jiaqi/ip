<<<<<<< HEAD:src/main/java/doraemon/TaskList.java
package doraemon;

import java.util.ArrayList;
=======
package seedu.doraemon;
>>>>>>> branch-A-JavaDoc:src/main/java/seedu/doraemon/TaskList.java

import java.util.ArrayList;
/**
 * Contains the task list and has operations to add/delete tasks in the list.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs a TaskList with an existing list of tasks.
     * @param tasks Initial list of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

<<<<<<< HEAD:src/main/java/doraemon/TaskList.java
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

=======
    /**
     * Adds a task to the list.
     * @param task The task to be added.
     */
>>>>>>> branch-A-JavaDoc:src/main/java/seedu/doraemon/TaskList.java
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the list based on its index.
     * @param task_number The 1-based index of the task to be deleted.
     * @return The deleted task.
     * @throws DoraemonException If the index is out of bounds.
     */
    public Task delete(int task_number) throws DoraemonException {
        return tasks.remove(task_number - 1 );
    }

    /**
     * Gets a task from the list based on its index.
     * @param task_number The 0-based index of the task.
     * @return The task at the specified index.
     */
    public Task getTask(int task_number) throws DoraemonException {
        return tasks.get(task_number);
    }

    public int size() {
        return tasks.size();
    }
}


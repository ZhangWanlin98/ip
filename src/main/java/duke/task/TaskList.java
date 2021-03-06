package duke.task;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list that contains different tasks.
 *
 * @param <T> The data type of the object in the task list.
 */
public class TaskList<T> {
    private List<T> taskList;

    /**
     * Constructs a task list.
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Adds new tasks into
     * the TaskList.
     *
     * @param event new task to be added.
     */
    public void addMemory(T event) {
        this.taskList.add(event);
    }

    /**
     * Gets all tasks in the list.
     *
     * @return the arrayList which stores all the tasks.
     */
    public List<T> getTaskList() {
        return this.taskList;
    }

    @Override
    public String toString() {
        StringBuilder results = new StringBuilder();
        int size = this.taskList.size();
        if (size != 0) {
            for (int i = 1; i < size; i++) {
                results.append(i).append(". ").append(taskList.get(i - 1)).append("\n");
            }
            results.append(size).append(". ").append(taskList.get(size - 1));
        }
        return results.toString();
    }
}

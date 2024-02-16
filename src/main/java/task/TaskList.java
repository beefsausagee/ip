package task;

import java.util.ArrayList;

/**
 * Represents a list of tasks.
 */
public class TaskList {
    private final ArrayList<Task> listOfTasks;

    public TaskList() {
        this.listOfTasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> taskList) {
        this.listOfTasks = taskList;
    }

    /**
     * Adds a task to the task list.
     * 
     * @param newTask The task to be added.
     */
    public void addTask(Task newTask) {
        listOfTasks.add(newTask);
    }

    /**
     * Retrieves the task at the specified index in the task list.
     * 
     * @param index The index of the task to retrieve.
     * @return The task at the specified index.
     */
    public Task getTask(int index) {
        return listOfTasks.get(index);
    }

    /**
     * Returns the number of tasks in the task list.
     * 
     * @return The number of tasks in the task list.
     */
    public int getSize() {
        return listOfTasks.size();
    }

    /**
     * Removes the task at the specified index from the task list.
     * 
     * @param index The index of the task to remove.
     */
    public void removeTask(int index) {
        listOfTasks.remove(index);
    }

    /**
     * Returns the list of tasks.
     * 
     * @return The list of tasks.
     */
    public ArrayList<Task> getList() {
        return listOfTasks;
    }
}

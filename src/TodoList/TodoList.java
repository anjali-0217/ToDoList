package TodoList;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class TodoList {
    private List<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    public void deleteTask(int id) {
        boolean removed = tasks.removeIf(task -> task.getId() == id);
        if (removed) System.out.println("Task deleted successfully!");
        else System.out.println("Task not found!");
    }

    public void updateTask(int id, String title, String desc, String priority, LocalDate dueDate) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(title);
                task.setDescription(desc);
                task.setPriority(priority);
                task.setDueDate(dueDate);
                System.out.println("Task updated successfully!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    public void markTaskDone(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDone(true);
                System.out.println("Task marked as done!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    public void listAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        System.out.println("\n===== All Tasks =====");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}

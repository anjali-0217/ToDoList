package TodoList;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TodoList todoList = new TodoList();
        boolean exit = false;

        System.out.println("===== Welcome to Advanced To-Do List =====");

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Update Task");
            System.out.println("4. Mark Task as Done");
            System.out.println("5. List All Tasks");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Task ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Description: ");
                        String desc = sc.nextLine();

                        System.out.print("Enter Priority (High/Medium/Low): ");
                        String priority = sc.nextLine();

                        System.out.print("Enter Due Date (YYYY-MM-DD): ");
                        String dateStr = sc.nextLine();

                        LocalDate dueDate = LocalDate.parse(dateStr);
                        Task task = new Task(id, title, desc, priority, dueDate);
                        todoList.addTask(task);

                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format! Task not added.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID! Task not added.");
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter Task ID to delete: ");
                        int delId = Integer.parseInt(sc.nextLine());
                        todoList.deleteTask(delId);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID!");
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter Task ID to update: ");
                        int updId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter new Title: ");
                        String newTitle = sc.nextLine();

                        System.out.print("Enter new Description: ");
                        String newDesc = sc.nextLine();

                        System.out.print("Enter new Priority (High/Medium/Low): ");
                        String newPriority = sc.nextLine();

                        System.out.print("Enter new Due Date (YYYY-MM-DD): ");
                        String newDateStr = sc.nextLine();

                        LocalDate newDueDate = LocalDate.parse(newDateStr);
                        todoList.updateTask(updId, newTitle, newDesc, newPriority, newDueDate);

                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format! Task not updated.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID! Task not updated.");
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Enter Task ID to mark as done: ");
                        int doneId = Integer.parseInt(sc.nextLine());
                        todoList.markTaskDone(doneId);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID!");
                    }
                    break;

                case 5:
                    todoList.listAllTasks();
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}
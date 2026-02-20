package TodoList;
import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private String description;
    private boolean isDone;
    private String priority; // High, Medium, Low
    private LocalDate dueDate;

    // Constructor
    public Task(int id, String title, String description, String priority, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isDone = false; // Default status: pending
        this.priority = priority;
        this.dueDate = dueDate;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isDone() { return isDone; }
    public String getPriority() { return priority; }
    public LocalDate getDueDate() { return dueDate; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setDone(boolean done) { this.isDone = done; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    // Display task info nicely
    @Override
    public String toString() {
        return "ID: " + id +
               ", Title: " + title +
               ", Description: " + description +
               ", Status: " + (isDone ? "Done" : "Pending") +
               ", Priority: " + priority +
               ", Due: " + dueDate;
    }
}

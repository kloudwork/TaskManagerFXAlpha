package taskmanagerSRC;

public class Task {

    // INITIALS

    private Task task;

    private String taskTitle;
    private String taskDescription;

    private boolean isTaskDone;
    public static int ID_POOL;
    private final int TASK_ID;


    public Task(String taskTitle, String taskDescription) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        isTaskDone = false;
        TASK_ID = ID_POOL;
        ID_POOL++;
    }

    // SETTERS AND GETTERS

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean isTaskDone() {
        return isTaskDone;
    }

    public void setIsTaskDone(boolean isTaskDone) {
        this.isTaskDone = isTaskDone;
    }

    // TASK

    public String printOutTaskIsDoneState() {
        String s = "PENDING";
        if (isTaskDone == true) {
            s = "DONE";
        }
        return s;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------------------------------------------------   \n");
        sb.append("Task ID: " + TASK_ID);
        sb.append(" | ");
        sb.append("Task title: " + getTaskTitle());
        sb.append(" | ");
        sb.append("\nTask description: " + getTaskDescription());
        sb.append(" | ");
        sb.append("\nTask state: ");
        sb.append(printOutTaskIsDoneState());
        sb.append("\n--------------------------------------------------------------------------- ");
        return sb.toString();
    }


}
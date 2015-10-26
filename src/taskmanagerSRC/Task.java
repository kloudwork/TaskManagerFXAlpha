package taskmanagerSRC;

public class Task {

    // INITIALS

    private Task task;
    private TaskManager taskManager;

    private String taskTitle;
    private String taskDescription;

    private boolean isTaskDone;
    public static int ID_POOL;
    private final int TASK_ID = ID_POOL;

    ///////////////////////// PLACE FOR TASK CATEGORY CODE /////////////////////////

    private String taskCategory;
    boolean categoryHOME = false;
    boolean categoryWORK = false;

    // display method for category name
    // with if statement and string return type

    // category switcher method

    // getTaskCategory
    // setTaskCategory

    ///////////////////////// PLACE FOR TASK CATEGORY CODE /////////////////////////

    // CONSTRUCTOR


    public Task(String taskTitle, String taskDescription) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        isTaskDone = false;
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
        sb.append("Task ID: " + taskManager.searchForTaskIndexInTaskStorage()); // crash with nullpointer exception
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
package taskmanagerSRC;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    // INITIALS

    ArrayList<Task> taskStorage = new ArrayList<>();
    Task choosenTask;
    Task actualTask;


    ///////////////////////// PLACE FOR TASK CATEGORY CODE /////////////////////////




    ///////////////////////// PLACE FOR TASK CATEGORY CODE /////////////////////////


    // TASK METHODS

    public String getUserInput() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        return userInput;
    }

    public int getUserInputToInteger() {
        int i = Integer.parseInt(getUserInput());
        return i;
    }

    public void createAndStoreNewTask() {
        Task t = new Task(getTaskTitleFromUserInput(), getTaskDescriptionFromUserInput());
        taskStorage.add(t);
    }


    public Task chooseTaskFromUserInput() {
        System.out.println("Choose a task to EDIT (ID): \n");
        choosenTask = getSpecificTaskFromUserInput();
        return choosenTask;
    }

    public int searchForTaskIndexInTaskStorage() {
        for(int i = 0; i < taskStorage.size(); ++i) {
            if(taskStorage.get(i) == choosenTask)
                return i;
        }
        return -1;
    }


    public String getTaskTitleFromUserInput() {

        System.out.println("\nTask title: ");
        String taskTitle = getUserInput();
        return taskTitle;
    }

    public void listTasks() {
        System.out.println("Tasks: " + taskStorage.size());
        for (int i = 0; i < taskStorage.size();i++) {
            actualTask = taskStorage.get(i);
            System.out.println(actualTask);
        }
    }

    public Task getSpecificTaskFromUserInput() {
        choosenTask = taskStorage.get(getUserInputToInteger());
        return choosenTask;
    }

    public void deleteTask(Task choosenTask) {
        this.choosenTask = choosenTask;
        System.out.println("\n\nYou deleted the following choosenTask: " + choosenTask.toString());
        taskStorage.remove(choosenTask);
    }

    // TASK TITLE METHODS

    public void renameTaskTitle(Task choosenTask) {
        this.choosenTask = choosenTask;
        String actualTitle = choosenTask.getTaskTitle();

        System.out.println("Actual title: " + actualTitle + "\n" + "Type new Title for the choosenTask: ");
        String newTitle = getUserInput();

        choosenTask.setTaskTitle(newTitle); //TODO more memory efficient solution
        System.out.println("Your new title is: " + choosenTask.getTaskTitle());
    }

    // TASK DESCRIPTION METHODS

    public String getTaskDescriptionFromUserInput() {

        System.out.println("\nTask description: ");
        String taskDescription = getUserInput();
        return taskDescription;
    }

    public void renameTaskDescription(Task choosenTask) {
        this.choosenTask = choosenTask;
        String actualDescription = choosenTask.getTaskDescription();

        System.out.println("Actual description: " + actualDescription + "\n" + "Type new description for the choosenTask: ");
        String newDescription = getUserInput();

        choosenTask.setTaskDescription(newDescription); //TODO more memory efficient solution
        System.out.println("Your new description is: " + choosenTask.getTaskDescription());
    }


    public void addToTaskDescription(Task choosenTask, String s) {
        this.choosenTask = choosenTask;
        choosenTask.setTaskDescription(choosenTask.getTaskDescription() + "" + s);
    }

    // TEST METHODS

    public void createTestTasks() {
        Task testTask1 = new Task("Pelda feladat","Le kell vinni a szemetet");
        Task testTask2 = new Task("Pelda TODO","Le kell tesztelni a kodot. Ez itt valami hosszu Lorem Ipsum...");
        Task testTask3 = new Task("Hosszunevu tennivalocska ez itten kerem.","Le kell vinni a szemetet");
        Task testTask4 = new Task("Pelda teendo","Kell majd valami easter egg");
        taskStorage.add(testTask1);
        taskStorage.add(testTask2);
        taskStorage.add(testTask3);
        taskStorage.add(testTask4);
    }

}

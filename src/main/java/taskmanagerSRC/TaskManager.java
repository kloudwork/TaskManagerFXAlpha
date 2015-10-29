package taskmanagerSRC;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    // INITIALS


    private ArrayList<Task> taskStorage = new ArrayList<>();
    Task choosenTask;

    public ArrayList<Task> getTaskStorage() {
        return taskStorage;
    }


    // TASK METHODS

    public String getUserInput() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        while (userInput.equals("")) {
            System.out.println("You entered nothing. Try again: ");
            userInput = input.nextLine();
        }
        return userInput;
    }


    public int getUserInputToInteger() {
        return Integer.parseInt(getUserInput());
    }

    public void createAndStoreNewTask() {
        Task t = new Task(getTaskTitleFromUserInput(), getTaskDescriptionFromUserInput());
        taskStorage.add(t);
        System.out.println("\nYou have successfully added a new Task!");
    }


    public Task chooseTaskFromUserInput() {
        System.out.println("Choose a task to EDIT (ID): \n");
        return getSpecificTaskFromUserInput();
    }


    public String getTaskTitleFromUserInput() {

        System.out.println("\nTask title: ");
        return getUserInput();
    }

    public void listTasks() {
        System.out.println("Tasks: " + taskStorage.size());
        for (int i = 0; i < taskStorage.size();i++) {
            taskStorage.get(i);
            System.out.println(taskStorage.get(i));
        }
    }

    public Task getSpecificTaskFromUserInput() {
        return taskStorage.get(getUserInputToInteger());
    }

    public void deleteTask(Task choosenTask) {
        System.out.println("\n\nYou deleted the following choosenTask: " + choosenTask.toString());
        taskStorage.remove(choosenTask);
    }

    // TASK TITLE METHODS

    public void renameTaskTitle(Task choosenTask) {

        System.out.println("Actual title: " + choosenTask.getTaskTitle() + "\n" + "Type new Title for the choosenTask: ");
        choosenTask.setTaskTitle(getUserInput()); //TODO more memory efficient solution
        System.out.println("Your new title is: " + choosenTask.getTaskTitle());
    }

    // TASK DESCRIPTION METHODS

    public String getTaskDescriptionFromUserInput() {

        System.out.println("\nTask description: ");
        return getUserInput();
    }

    public void renameTaskDescription(Task choosenTask) {
        System.out.println("Actual description: " + choosenTask.getTaskDescription() + "\n" + "Type new description for the choosenTask: ");
        choosenTask.setTaskDescription(getUserInput()); //TODO more memory efficient solution
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

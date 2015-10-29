package taskmanagerSRC;

public class Menu {

    // INITIALS

    private TaskManager taskManager = new TaskManager();
    private Task choosenTask;

    private boolean mainMenu = true;
    private boolean editMenu = false;
    private boolean isTaskChoosen = false;

    // MAIN MENU


    // TODO STRING FORMATTED MENU
    private static final String MAIN_MENU = "\n(-- MainMenu --) \n\n" +
            "Choose an option: \n" +
            "   1) Add new task \n" +
            "   2) Edit a task \n" +
            "   3) Print all task \n" +
            "   4) Exit \n" +
            "  99) MAKE TEST TASKS";

    // EDIT TASK MENU

    // TODO STRING FORMATTED MENU
    private static final String EDIT_MENU = "\n(-- EditMenu --) \n\n" +
            "Choose an option: \n" +
            "   1) Delete selected task \n" +
            "   2) Rewrite selected task Title \n" +
            "   3) Rewrite selected Description \n" +
            "   4) Add more to selected task Description \n" +
            "   5) DONE a Task \n" +
            "   6) Return to MainMenu";

    // SETTERS AND GETTERS


    public void setEditMenu(boolean editMenu) {
        this.editMenu = editMenu;
    }

    public void setMainMenu(boolean mainMenu) {
        this.mainMenu = mainMenu;
    }

    public boolean isTaskChoosen() {
        return isTaskChoosen;
    }

    public void setIsTaskChoosen(boolean isTaskChoosen) {
        this.isTaskChoosen = isTaskChoosen;
    }

    // BUILDING MENU METHODS


    public void startMenu() {
            if (mainMenu) {
                startMainMenu();
            } else {
                startEditingMenu();
            }
        }

    public void startMainMenu() {
        System.out.println(MAIN_MENU);
        chooseMainMenuOption(taskManager.getUserInputToInteger());
    }

    public void listingAndChoosingTask() {
        taskManager.listTasks();
        choosenTask = taskManager.chooseTaskFromUserInput();
        setIsTaskChoosen(true);
    }

    public void startEditingMenu() {

        // CHOOSE A TASK TO EDIT
        if (isTaskChoosen == false) {
            listingAndChoosingTask();
        }
        if (taskManager.getTaskStorage().size() >= 1)
            System.out.println("SELECTED TASK TO EDIT: \n" + choosenTask.toString() + "\n");
        System.out.println(EDIT_MENU);
        chooseEditMenuOption(taskManager.getUserInputToInteger());
    }

    public void taskStorageIsEmptyWarning() {
        if (taskManager.getTaskStorage().size() < 1) {
            System.out.println("There is no task! Add new task to edit something.");
            startMenu();
        }
    }

    public void clearScreen() {
        for(int clear = 0; clear < 100; clear++)
        { System.out.println("\b") ;}
    }

    // SETTING MENU STATES

    public void setMenuToMainMenu() {
        setEditMenu(false);
        setMainMenu(true);
        setIsTaskChoosen(false);
    }

    public void setMenuToEditingMenu() {
        setMainMenu(false);
        setEditMenu(true);
    }

    // MAIN MENU SWITCHER

    public void chooseMainMenuOption(int command) {

        taskStorageIsEmptyWarning();

        switch (command) {
            case 99:
                // ADD 4 NEW DIFFERENT TASK
                taskManager.createTestTasks();
                break;
            case 1:
                // ADD NEW TASK
                taskManager.createAndStoreNewTask();
                break;
            case 2:
                // EDIT A SPECIFIC TASK
                taskStorageIsEmptyWarning();
                setMenuToEditingMenu();
                startMenu();
                break;
            case 3:
                // LIST TASKS
                taskStorageIsEmptyWarning();
                taskManager.listTasks();
                break;
            case 4:
                // EXIT
                System.exit(1);
            default:
                System.out.println("\nInvalid option! Enter again: ");
        }
    }

    // EDITING A TASK MENU SWITCHER

    public void chooseEditMenuOption(int command) {

        switch (command) {

            case 1:
                // DELETE TASK
                taskManager.deleteTask(choosenTask);
                break;
            case 2:
                // RENAME TITLE
                taskManager.renameTaskTitle(choosenTask);
                break;
            case 3:
                // RENAME DESCRIPTION
                taskManager.renameTaskDescription(choosenTask);
                break;
            case 4:
                // ADD MORE TO DESCRIPTION
                System.out.println("Add more text to description");
                taskManager.addToTaskDescription(choosenTask,taskManager.getUserInput());
                break;
            case 5:
                // SET TASK TO DONE
                choosenTask.setIsTaskDone(true);
                System.out.println("You have successfully DONE with: " + choosenTask.getTaskTitle());
                break;
            case 6:
                // RETURN TO MAIN MENU
                setMenuToMainMenu();
                startMenu();
                break;
            default:
                System.out.println("Invalid option! Enter again: ");
        }
    }
}

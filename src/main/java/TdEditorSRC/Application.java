package TdEditorSRC;

import TdEditorSRC.Menu.Menu;
import TdEditorSRC.Utilities.IOutils;

public class Application {

    /* // --- KNOWN ISSUES --- //

    1) Enter string instead of int gonna crash the application
    2) There is no casting upward to original object type after added to master class arraylist

     */

    private IOutils ioUtils;

    public static void main(String[] args) throws Exception {

        boolean isFirstRun = true;
        Menu menu = new Menu();


        while (true) {

            if (isFirstRun == true) {
                menu.clearScreen();
                isFirstRun = false;
            }

            menu.startMenu();

        }
    }

    public static void closeProgram() {
        IOutils.messageToUser("Game saved! (placeholder text)");
        System.exit(1);
    }
}



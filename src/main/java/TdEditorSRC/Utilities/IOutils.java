package TdEditorSRC.Utilities;


import java.util.Scanner;

public class IOutils {


    private static Scanner input = new Scanner(System.in);


    public static String getStringUserInput() {

        String userInput = input.nextLine();
        while (userInput.isEmpty()) {
            messageToUser("You entered nothing. Try again: ");
            userInput = input.nextLine();
        }
        return userInput;
    }

    public static int getUserInputToInteger() {
        return Integer.parseInt(getStringUserInput());
        // TODO handle if not number
    }

    public static void messageToUser(String message) {
        System.out.println("\n" + message);
    }


}

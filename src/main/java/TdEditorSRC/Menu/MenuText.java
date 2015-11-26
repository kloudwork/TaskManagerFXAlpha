package TdEditorSRC.Menu;


public class MenuText {

    // MAIN MENU

    private static final String MAIN_MENU = "\n(-- MainMenu --) \n\n" +
            "Choose an option: \n" +
            "   1) Create new character \n" +
            "   2) Edit a character \n" +
            "   3) Print all characters \n" +
            "   4) List ENEMY type characters \n" +
            "   5) Exit \n" +
            "  99) MAKE TEST CHARACTERS";

    // EDIT TASK MENU

    private static final String EDIT_CHARACTER_MENU = "\n(-- EditMenu --) \n\n" +
            "Choose an option: \n" +
            "   1) Delete selected character \n" +
            "   2) Rename selected character \n" +
            "   3) Set ATTRIBUTES for selected character \n" +
            "   4) Return to MainMenu";

    // EDIT ATTRIBUTES MENU

    private static final String EDIT_ATTRIBUTES_MENU ="\n(-- EditAttributesMenu --) \n\n" +
            "Choose an option: \n" +
            "   1) Set strength \n" +
            "   2) Set agility \n" +
            "   3) Return to Editing Menu \n" +
            "   4) Return to Main Menu";
    // TODO ALL SETTINGS

    // CHOOSE CHARACTER TYPE MENU



    private static final String CHOOSE_CHAR_TYPE =
            "\nChoose a character TYPE: \n" +
            "   1) Create player \n" +
            "   2) Create enemy \n";

    // MENUTEXT GETTERS


    public static String getMainMenu() {
        return MAIN_MENU;
    }

    public static String getEditCharacterMenu() {
        return EDIT_CHARACTER_MENU;
    }

    public static String getEditAttributesMenu() {
        return EDIT_ATTRIBUTES_MENU;
    }

    public static String getChooseCharType() {
        return CHOOSE_CHAR_TYPE;
    }

}

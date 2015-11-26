package TdEditorSRC.Menu;

import TdEditorSRC.Application;
import TdEditorSRC.CharacterManager;
import TdEditorSRC.Entities.Character;
import TdEditorSRC.Utilities.CharacterUtils;
import TdEditorSRC.Utilities.IOutils;


public class Menu {

    // INITIALS

    private CharacterManager characterManager = new CharacterManager();
    private Character choosenCharacter;
    private IOutils ioUtils;
    private MenuText menuText;
    private CharacterUtils characterUtils = new CharacterUtils();

    private boolean mainMenu = true;
    private boolean editMenu = false;
    private boolean attributeMenu = false;
    private boolean isCharacterChoosen = false;

    // CONSTRUCTOR


    // SETTERS AND GETTERS

    public void setEditMenu(boolean editMenu) {
        this.editMenu = editMenu;
    }

    public void setMainMenu(boolean mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void setAttributesMenu(boolean attributeMenu) {
        this.attributeMenu = attributeMenu;
    }

    public boolean isCharacterChoosen() {
        return isCharacterChoosen;
    }

    public void setIsCharacterChoosen(boolean isCharacterChoosen) {
        this.isCharacterChoosen = isCharacterChoosen;
    }

    // BUILDING MENU METHODS

    public void startMenu() throws Exception {
            if (mainMenu) {
                startMainMenu();
            } if (editMenu) {
                startEditingMenu();
            } if (attributeMenu) {
            startAttributeEditingMenu();
        }
        }

    public void startMainMenu() throws Exception {
        IOutils.messageToUser(MenuText.getMainMenu());
        chooseMainMenuOption(IOutils.getUserInputToInteger());
    }

    public void startEditingMenu() throws Exception {

        // CHOOSE A CHARACTER TO EDIT
        editorMenusSelector();
        IOutils.messageToUser(MenuText.getEditCharacterMenu());
        chooseEditMenuOption(IOutils.getUserInputToInteger());
    }

    public void startAttributeEditingMenu() throws Exception {
        editorMenusSelector();
        IOutils.messageToUser(MenuText.getEditAttributesMenu());
        chooseAttributesEditMenuOption(IOutils.getUserInputToInteger());
    }

    public void editorMenusSelector() {
        if (isCharacterChoosen == false) {
            listingAndChoosingTask();
        }
        if (characterManager.getCharacterStorage().size() >= 1);
    }

    public void startChooseCharacterTypeMenu() throws Exception {
        IOutils.messageToUser(MenuText.getChooseCharType());
        chooseCharacterTypeMenu(IOutils.getUserInputToInteger());
    }

    // MENU ASSIST METHODS

    public void listingAndChoosingTask() {
        characterManager.listAllTypeCharacters();
        choosenCharacter = characterManager.chooseCharacterFromUserInput(
                IOutils.getUserInputToInteger());
        setIsCharacterChoosen(true);
    }

    public void characterStorageIsEmptyWarning() throws Exception {
        if (characterManager.getCharacterStorage().size() < 1) {
            IOutils.messageToUser("There is no character! Add new character to edit something.");
            startMenu();
        }
    }

    public void clearScreen() {
        for(int clear = 0; clear < 100; clear++)
        { System.out.println("\b") ;}
    }

    // SETTING MENU STATES

    public void setMenuToMainMenu() throws Exception {
        setEditMenu(false);
        setMainMenu(true);
        setAttributesMenu(false);
        setIsCharacterChoosen(false);
        startMenu();
    }

    public void setMenuToEditingMenu() throws Exception {
        setMainMenu(false);
        setEditMenu(true);
        setAttributesMenu(false);
        startMenu();
    }

    public void setAttributesMenu() throws Exception {
        setMainMenu(false);
        setEditMenu(false);
        setAttributesMenu(true);
        startMenu();
    }

    // MAIN MENU SWITCHER

    public void chooseMainMenuOption(int command) throws Exception {

        switch (command) {
            case 99:
                // ADD 4 NEW DIFFERENT CHARACTER
                characterManager.createTestCharacters();
                break;
            case 1:
                // ADD NEW CHARACTER
                startChooseCharacterTypeMenu();
                break;
            case 2:
                // EDIT A SPECIFIC CHARACTER
                characterStorageIsEmptyWarning();
                setMenuToEditingMenu();
                break;
            case 3:
                // LIST CHARACTERS
                characterStorageIsEmptyWarning();
                characterManager.listAllTypeCharacters();
                break;
            case 4:
                characterManager.listEnemyTypeCharacters();
                break;
            case 5:
                // EXIT
                Application.closeProgram();
            default:
                IOutils.messageToUser("\nInvalid option! Enter again: ");
        }
    }

    // EDITING A TASK MENU SWITCHER

    public void chooseEditMenuOption(int command) throws Exception {

        switch (command) {

            case 1:
                // DELETE CHARACTER
                characterManager.deleteCharacter(choosenCharacter);
                setIsCharacterChoosen(false);
                startMenu();
                break;
            case 2:
                // RENAME CHARACTER
                characterManager.renameCharacter(choosenCharacter);
                break;
            case 3:
                // SET ATTRIBUTES -> NEW LEVEL (deeper)
                setAttributesMenu();
            break;
            case 4:
                // RETURN TO MAIN MENU -> NEW LEVEL (upper)
                setMenuToMainMenu();
                break;
            default:
                IOutils.messageToUser("Invalid option! Enter again: ");
        }
    }

    public void chooseAttributesEditMenuOption(int command) throws Exception {

        switch (command) {
            case 1:
                // SET STRENGTH FOR CHARACTER
                IOutils.messageToUser("Set strength for character: ");
                characterUtils.setCharacterStrength(choosenCharacter);
                break;
            case 2:
                // SET AGILITY FOR CHARACTER
                IOutils.messageToUser("Set agility for character: ");
                characterUtils.setCharacterAgility(choosenCharacter);
                break;
            case 3:
                // EXIT TO EDITING MENU
                setMenuToEditingMenu();
                startMenu();
                break;
            case 4:
                // EXIT TO MAINMENU
                setMenuToMainMenu();
                startMenu();
                break;
            default:
                IOutils.messageToUser("Invalid option! Enter again: ");

        }
    }

    public void chooseCharacterTypeMenu(int command) throws Exception {

        switch (command) {
            case 1:
                characterManager.createAndStoreNewPlayer();
                break;
            case 2:
                 characterManager.createAndStoreNewEnemy();
                break;
            default:
                IOutils.messageToUser("Invalid option! Enter again: ");
        }
    }

}

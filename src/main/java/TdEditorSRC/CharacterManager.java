package TdEditorSRC;

import TdEditorSRC.Entities.Character;
import TdEditorSRC.Entities.Enemy;
import TdEditorSRC.Entities.Player;
import TdEditorSRC.Utilities.IOutils;

import java.util.ArrayList;

public class CharacterManager {

    // -- INITIALS -- //

    private ArrayList<Character> characterStorage = new ArrayList<>();
    private IOutils iOutils;

    // -- CONSTRUCTOR -- //


    public ArrayList<Character> getCharacterStorage() {
        return characterStorage;
    }

    // -- FUNCTIONS FOR CHARACTER EDITING -- //

    public void createAndStoreNewPlayer() throws Exception {
        IOutils.messageToUser("Enter a NAME: ");
        Player player = new Player(IOutils.getStringUserInput());
        characterStorage.add(player);
        IOutils.messageToUser("You have successfully added a new player!");
    }

    public void createAndStoreNewEnemy() throws Exception {
        IOutils.messageToUser("Set HEALTH for enemy (1-1000): ");
        Enemy enemy = new Enemy(IOutils.getUserInputToInteger());
        characterStorage.add(enemy);
        IOutils.messageToUser("You have successfully added a new enemy!");
    }

    public void listAllTypeCharacters() {
        IOutils.messageToUser("Number of characters: " + characterStorage.size());
        for (int i = 0; i < characterStorage.size();i++) {
            System.out.println(characterStorage.get(i));
        }
    }

    public void listEnemyTypeCharacters() {
        String list = "\n";
        int enemyCounter = 0;

        for (int i = 0; i < characterStorage.size(); i++) {
        if (characterStorage.get(i).getType().equals("Enemy")) {
           list = list + characterStorage.get(i) + "\n"; // TODO more memory efficient method
            enemyCounter++;
        }
        }
        IOutils.messageToUser("Number of ENEMY type characters: " + enemyCounter);
        IOutils.messageToUser(list);
    }

    public void deleteCharacter(Character choosenChar) {
        IOutils.messageToUser("\nYou deleted the selected character: " + choosenChar);
        characterStorage.remove(choosenChar);
    }

    public void renameCharacter(Character choosenChar) throws Exception {

        IOutils.messageToUser("Actual name: " + choosenChar.getName() + "\nType new name for the character: ");
        choosenChar.setName(IOutils.getStringUserInput()); //TODO more memory efficient solution
        IOutils.messageToUser("The new name is: " + choosenChar.getName());
    }

    // -- SUPPORT METHODS -- //


    public Character chooseCharacterFromUserInput(int choosenID) {
        IOutils.messageToUser("Choose a character to EDIT (ID): \n");
        Character choosenCharacter = null;

                for(int i = 0; i < characterStorage.size(); i++) {
                    if (characterStorage.get(i).getID() == choosenID) {
                        choosenCharacter = characterStorage.get(i);
                    }
                }
        return choosenCharacter;
    }

    // -- TEST METHODS -- //

    public void createTestCharacters() throws Exception {

        Player tester1 = new Player("Tester1");
        Player tester2 = new Player("Tester2");
        Enemy tester3 = new Enemy(50);
        Enemy tester4 = new Enemy(80);
        characterStorage.add(tester1);
        characterStorage.add(tester2);
        characterStorage.add(tester3);
        characterStorage.add(tester4);
    }

}

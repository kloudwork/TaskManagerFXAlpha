package TdEditorSRC.Utilities;

import TdEditorSRC.Entities.Character;

import java.util.Random;

public class CharacterUtils {

    private IOutils ioUtils;

    private static String[] names = {"Speedy, ", "Alex, ", "Peter, ", "Howard, "};
    private static String[] titles = {"the Butcher", "from the Deep", "the Executioner",};

    // --- SET COMMON ATTRIBUTES FOR EVERY TYPE OF CHARACTERS -- //

    public void setCharacterStrength(Character choosenChar) throws Exception {
        IOutils.messageToUser("Actual Strength: " + choosenChar.getStrength());
        IOutils.messageToUser("Set new strength: ");
        choosenChar.setStrength(IOutils.getUserInputToInteger());
        IOutils.messageToUser("You modified strength to -> " + choosenChar.getStrength());
    }

    public void setCharacterAgility(Character choosenChar) throws Exception {
        IOutils.messageToUser("Actual Agility -> " + choosenChar.getAgility());
        choosenChar.setAgility(IOutils.getUserInputToInteger());
        IOutils.messageToUser("You modified Agility to -> " + choosenChar.getAgility());
    }


    public static String getRandomNameAndTitle() {
        int indexName = new Random().nextInt(names.length);
        int indexTitle = new Random().nextInt(titles.length);
        String name = names[indexName];
        String title = titles[indexTitle];
        return name + title;
    }

}

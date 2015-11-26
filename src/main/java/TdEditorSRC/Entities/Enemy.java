package TdEditorSRC.Entities;


import TdEditorSRC.Utilities.CharacterUtils;

public class Enemy extends Character {

    private CharacterUtils characterUtils;

    public Enemy(int health) throws Exception {

        super(CharacterUtils.getRandomNameAndTitle());
        setHealth(health);
        setType("Enemy");
    }

    @Override
    public String toString() {
        String s = "ID TO CHOOSE: " + getID() +"\n" + "Name: " + getName() + "\n" + " Type: " + getType();
        return s;
        // TODO correct toString
    }
}



// TODO ENEMY ONLY HAS LEVEL DON'T HAS XP!!
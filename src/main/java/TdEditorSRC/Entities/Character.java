package TdEditorSRC.Entities;

import com.google.common.collect.Range;

public abstract class Character {

    // initials
    private static final int INITIAL_STRENGTH     = 5;
    private static final int INITIAL_AGILITY      = 5;
    private static final int INITIAL_HEALTH       = 100;
    private static final int INITIAL_WILL         = 5;
    private static final int INITIAL_XP           = 0;
    private static final int INITIAL_PERCEPTION   = 5;
    private static final int INITIAL_VITALITY     = 5;
    private static final int INITIAL_INTELLIGENCE = 5;
    private static final int INITIAL_CHARISMA     = 5;

    private static final int ATTRIB_RANGE_MIN = 0;
    private static final int ATTRIB_RANGE_MAX = 15;
    private static final int NAME_RANGE_MIN = 3;
    private static final int NAME_RANGE_MAX = 30;

    private static Range<Integer> attribRange = Range.open(ATTRIB_RANGE_MIN, ATTRIB_RANGE_MAX);
    private static Range<Integer> charNameRange = Range.open(NAME_RANGE_MIN, NAME_RANGE_MAX);

    static int ID_POOL = 0;

    private String name;
    private int strength;
    private int agility;
    private int perception;
    private int vitality;
    private int intelligence;
    private int charisma;
    private int health;
    private int will;
    private int xp;

    private String Type;

    private boolean isCharacterAlive;

    private final int ID;

    public Character(String name) throws Exception {
        this.name = name;
        setName(name);
        setCharacterInitials();

        this.ID = ID_POOL;
        ID_POOL++;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getVitality() {
        return vitality;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getPerception() {
        return perception;
    }

    public int getHealth() {
        return health;
    }

    public int getWill() {
        return will;
    }

    public int getXp() {
        return xp;
    }

    public int getID() {
        return ID;
    }

    public String getType() {
        return Type;
    }


    public void setCharacterInitials() throws Exception {
        setStrength(INITIAL_STRENGTH);
        setAgility(INITIAL_AGILITY);
        setPerception(INITIAL_PERCEPTION);
        setVitality(INITIAL_VITALITY);
        setIntelligence(INITIAL_INTELLIGENCE);
        setCharisma(INITIAL_CHARISMA);
        setWill(INITIAL_WILL);
        setXp(INITIAL_XP);
        setHealth(INITIAL_HEALTH);
    }

    public void setName(String name) throws Exception {
        if (isCharacterNameValid(name)) {
            this.name = name;
        } else {
            throw new Exception("Invalid name" + "You typed: " + getName() );
        }
    }

    public void setType(String type) {
        Type = type;
    }

    public void setStrength(int strength) throws Exception {
        if (attribRange.contains(strength)) {
            this.strength = strength;
        } else {
            throw new Exception("Invalid strenght. Value: " + getStrength());
            }
        }

    public void setAgility(int agility) throws Exception {
        if (attribRange.contains(agility)) {
            this.agility = agility;
        } else {
            throw new Exception("Invalid agility. Value: " + getAgility());
            }
        }

    public void setPerception(int perception) throws Exception {
        if (attribRange.contains(perception)) {
            this.perception = perception;
        } else {
            throw new Exception("Invalid perception. Value: " + getPerception());
        }
    }

    public void setVitality(int vitality) throws Exception {
        if (attribRange.contains(vitality)) {
            this.vitality = vitality;
        } else {
            throw new Exception("Invalid vitality. Value: " + getVitality());
        }
    }

    public void setIntelligence(int intelligence) throws Exception {
        if (attribRange.contains(intelligence)) {
            this.intelligence = intelligence;
        } else {
            throw new Exception("Invalid intelligence. Value: " + getIntelligence());
        }
    }

    public void setCharisma(int charisma) throws Exception {
        if (attribRange.contains(charisma)) {
            this.charisma = charisma;
        } else {
            throw new Exception("Invalid charisma. Value: " + getCharisma());
        }
    }


    public void setWill(int will) throws Exception {
        if (attribRange.contains(will)) {
            this.will = will;
        }  else {
            throw new Exception("Invalid will. Value: " + getWill());
            }
        }

    public void setHealth(int health) throws Exception {
        if (health < -1000) {
            throw new Exception("Invalid health. Value: " + getHealth());
        } else {
            this.health = health;
        }
    }


    public void setXp(int xp) throws Exception {
        if (xp < 0){
        throw new Exception("Invalid XP. Value: " + getXp());
        } else{
                this.xp = xp;
            }
        }


    public int getLevel() {
        return xp / 1000; //TODO correct getlevel math
    }

    public void addXp(int xpToAdd) {
        xp += xpToAdd;
    }

    public void setHealthAfterFight() throws Exception {
        setHealth(this.health - 10);
    }


    public static boolean isCharacterNameValid(String name) {
        return (charNameRange.contains(name.length()));
    }

    public String getHumanReadableCharacterInfo() {
        return "Character ID: " + (getID() + 1) + ", Name: " + getName() + ", Health: " + getHealth();
    }
}

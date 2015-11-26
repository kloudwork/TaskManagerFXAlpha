package TdEditorSRC.Entities;


public class Player extends Character {


    public Player(String name) throws Exception {
        super(name);
        setType("Player");
    }

    @Override
    public String toString() {
        String s = "ID TO CHOOSE: " + getID() + "\n" + "Name: " + getName() + "\n" + " Type: " + getType();
        return s;
        // TODO correct toString
    }

    /*
        @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------------------------------------------------   \n");
        sb.append("Task ID: " + TASK_ID);
        sb.append(" | ");
        sb.append("Task title: " + getTaskTitle());
        sb.append(" | ");
        sb.append("\nTask description: " + getTaskDescription());
        sb.append(" | ");
        sb.append("\nTask state: ");
        sb.append(printOutTaskIsDoneState());
        sb.append("\n--------------------------------------------------------------------------- ");
        return sb.toString();
    }
     */
}

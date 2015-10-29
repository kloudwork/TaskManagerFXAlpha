/* package taskManagerUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// implements EventHandler<ActionEvent>

public class Main extends Application {

    Stage window;

    Scene sceneMainMenu;

    VBox layoutMainMenu;

    Label welcomeMainMenu;

    Button confirmButton;
    Button alertButton;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;


        initialsMainMenuElements();

        window.setScene(sceneMainMenu);
        window.setTitle("Taskmanager");
        window.show();

    }

    public void initialsMainMenuElements() {

        welcomeMainMenu = new Label("Welcome in the Main Menu");

        confirmButton = new Button();
        confirmButton.setText("Open confirmation box");
        confirmButton.setOnAction(e -> {
            boolean result = ConfirmBox.display("Confirmation", "Are you sure?");
            System.out.println(result);
        });

        alertButton = new Button();
        alertButton.setText("Alert button");
        alertButton.setOnAction(e -> AlertBox.display("Warning!", "You can't do that!"));

        layoutMainMenu = new VBox();
        layoutMainMenu.getChildren().addAll(welcomeMainMenu, confirmButton,alertButton);

        sceneMainMenu = new Scene(layoutMainMenu, 500, 300);

    }



    public static void main(String[] args) {
        launch(args);
    }


}


*/








//////////////////////////////////////////////// REFEREMCE SOURCE CODES ////////////////////////////////////////////////

/////////////////////////////// HANDLE BUTTONS IN MULTIPLAFE IF STATEMENTS AND GETSOURCE ///////////////////////////////
/*

   public void handle(ActionEvent buttonsMainMenu) {
        if(buttonsMainMenu.getSource()==confirmButton){
        System.out.println("You have added a new task!");
        }
    }

*/

/////////////////////////////// RANDOM MENU METHOD ///////////////////////////////
/*

    public void showEditMenu(Stage menu) {

        StackPane layoutEditMenu = new StackPane();
        layoutEditMenu.getChildren().add(editTask);

        sceneTestScene = new Scene (layoutEditMenu,200,200);

        editTask.setText("Back to the first window");
        editTask.setOnAction(e -> menu.setScene(sceneMainMenu));


        welcomeEditMenu = new Label("Welcome to EditingMenu");


    }

*/

/////////////////////////////// RANDOM MENU METHOD ///////////////////////////////

    /*

    window = primaryStage;

    //Button 1
    Label label1 = new Label("Welcome to the first scene!");
    Button button1 = new Button("Go to scene 2");
    button1.setOnAction(e -> window.setScene(scene2));

    //Layout 1 - children laid out in vertical column
    VBox layout1 = new VBox(20);
    layout1.getChildren().addAll(label1, button1);
    scene1 = new Scene(layout1, 200, 200);


    //Button 2
    Button button2 = new Button("This sucks, go back to scene 1");
    button2.setOnAction(e -> window.setScene(scene1));

    //Layout 2
    StackPane layout2 = new StackPane();
    layout2.getChildren().add(button2);
    scene2 = new Scene(layout2, 600, 300);

    //Display scene 1 at first
    window.setScene(scene1);
    window.setTitle("Title Here");
    window.show();
}
*/


package TdEditorUI;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean confirm;

    public static boolean display(String title,String message) {

        Stage window = new Stage();

        // THIS BLOCKS FUNCTIONS IN OTHER STAGES/WINDOWS
        window.initModality(Modality.APPLICATION_MODAL);

        // SET AN ALERTBOX WINDOW
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(250);

        // SET THE MESSAGE IN A LABEL
        Label testAlerts = new Label();
        testAlerts.setText(message);

        Button buttonYes = new Button();
        buttonYes.setText("Yes");
        buttonYes.setOnAction(e -> {
            confirm = true;
            window.close();
        });

        Button buttonNo = new Button();
        buttonNo.setText("No");
        buttonNo.setOnAction(e -> {
            confirm = false;
            window.close();
        });

        // MAKE VBOX TO STORE ELEMENTS LIKE BUTTONS
        VBox layoutAlertBox = new VBox(10);
        layoutAlertBox.getChildren().addAll(testAlerts, buttonNo, buttonYes);
        layoutAlertBox.setAlignment(Pos.CENTER);

        // MAKE SCENE WHICH FILLS THE STAGE
        Scene sceneAlertBox = new Scene(layoutAlertBox, 250, 250);

        // THE ALERTBOX SHOWS UP AND WAIT
        window.setScene(sceneAlertBox);
        window.showAndWait();

        return confirm;
    }
}


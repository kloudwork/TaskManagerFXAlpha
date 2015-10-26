package taskManagerUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AlertBox {

    public static void display(String title,String description) {
        Stage window = new Stage();

        // THIS BLOCKS FUNCTIONS IN OTHER STAGES/WINDOWS
        window.initModality(Modality.APPLICATION_MODAL);

        // SET AN ALERTBOX WINDOW
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(250);

        // SET THE MESSAGE
        Label testAlerts = new Label();
        testAlerts.setText(description);

        // MAKE BUTTON TO CLOSE
        Button buttonClose = new Button();
        buttonClose.setText("Confirm");
        buttonClose.setOnAction(e -> window.close());

        // MAKE VBOX TO STORE ELEMENTS LIKE BUTTON
        VBox layoutAlertBox = new VBox(10);
        layoutAlertBox.getChildren().addAll(testAlerts, buttonClose);
        layoutAlertBox.setAlignment(Pos.CENTER);

        // MAKE SCENE WHICH FILLS THE STAGE
        Scene sceneAlertBox = new Scene(layoutAlertBox, 250, 250);

        // THE ALERTBOX SHOWS UP AND WAIT
        window.setScene(sceneAlertBox);
        window.showAndWait();

    }
}

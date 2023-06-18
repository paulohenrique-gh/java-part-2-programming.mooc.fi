package notifier;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    public void start(Stage window) {
        TextField topText = new TextField("");
        Button button = new Button("Update");
        Label copyText = new Label("");

        button.setOnAction((event) -> {
            copyText.setText(topText.getText());
        });

        VBox componentGroup = new VBox();
        componentGroup.getChildren().addAll(topText, button, copyText);

        Scene viewport = new Scene(componentGroup);

        window.setScene(viewport);
        window.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }
}

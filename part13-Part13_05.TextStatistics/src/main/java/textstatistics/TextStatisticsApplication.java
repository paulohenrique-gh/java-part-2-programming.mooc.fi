package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class TextStatisticsApplication extends Application {
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        TextArea text = new TextArea("");
        layout.setCenter(text);

        HBox bottomText = new HBox();
        bottomText.setSpacing(10);
        bottomText.getChildren().add(new Label("Letters: 0"));
        bottomText.getChildren().add(new Label("Words: 0"));
        bottomText.getChildren().add(new Label("The longest word is:"));
        layout.setBottom(bottomText);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
}

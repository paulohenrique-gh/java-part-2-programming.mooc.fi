package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.util.Arrays;

public class TextStatisticsApplication extends Application {
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        TextArea text = new TextArea("");
        layout.setCenter(text);

        HBox bottomText = new HBox();
        bottomText.setSpacing(10);

        Label letterCount = new Label("Letters: 0");
        Label wordCount = new Label("Words: 0");
        Label longestWord = new Label("The longest word is: ");

        text.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            letterCount.setText("Letters: " + characters);
            wordCount.setText("Words: " + words);
            longestWord.setText("The longest word is: " + longest);

        });

        bottomText.getChildren().add(letterCount);
        bottomText.getChildren().add(wordCount);
        bottomText.getChildren().add(longestWord);
        layout.setBottom(bottomText);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
}

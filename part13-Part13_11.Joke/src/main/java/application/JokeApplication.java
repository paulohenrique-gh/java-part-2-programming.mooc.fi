package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        Button joke = new Button("Joke");
        Button answer = new Button("Answer");
        Button explanation = new Button("Explanation");

        menu.getChildren().addAll(joke, answer, explanation);

        layout.setTop(menu);

        StackPane jokeLayout = createView("What do you call a bear with no teeth?");
        StackPane answerLayout = createView("A gummy bear.");
        StackPane explanationLayout = createView("A bear with no teeth only has gum.\nA gummy bear is also a candy");

        joke.setOnAction((event) -> layout.setCenter(jokeLayout));
        answer.setOnAction((event) -> layout.setCenter(answerLayout));
        explanation.setOnAction((event) -> layout.setCenter(explanationLayout));

        layout.setCenter(jokeLayout);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }

    public StackPane createView(String text) {
        StackPane view = new StackPane();
        view.setPrefSize(300, 180);
        view.setAlignment(Pos.CENTER);
        view.getChildren().add(new Label(text));

        return view;
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}
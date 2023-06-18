package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {
    public void start(Stage window) {
        // First view - ask for user's name
        Label instruction = new Label("Enter your name and start.");
        TextField name = new TextField("");
        Button start = new Button("Start");

        GridPane startView = new GridPane();
        startView.add(instruction, 0, 0);
        startView.add(name, 0, 1);
        startView.add(start, 0, 2);

        startView.setPrefSize(300, 180);
        startView.setAlignment(Pos.CENTER);
        startView.setVgap(10);
        startView.setHgap(10);
        startView.setPadding(new Insets(20, 20, 20, 20));

        Scene inputView = new Scene(startView);

        // Second view - welcome screen
        Label welcome = new Label("");

        StackPane welcomeScreen = new StackPane();
        welcomeScreen.setPrefSize(300, 180);
        welcomeScreen.getChildren().add(welcome);
        welcomeScreen.setAlignment(Pos.CENTER);

        Scene welcomeView = new Scene(welcomeScreen);

        // handling button click
        start.setOnAction((event) -> {
            welcome.setText("Welcome " + name.getText() + "!");
            window.setScene(welcomeView);
        });

        window.setScene(inputView);
        window.show();
    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}

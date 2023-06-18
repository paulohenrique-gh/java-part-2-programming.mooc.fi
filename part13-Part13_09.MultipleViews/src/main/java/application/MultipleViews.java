package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

public class MultipleViews extends Application {

    public void start(Stage window) {
        // first view
        Label topText = new Label("First view!");
        Button toSecondView = new Button("To the second view!");
        BorderPane firstView = new BorderPane();
        firstView.setTop(topText);
        firstView.setCenter(toSecondView);

        // second view
        Button toThirdView = new Button("To the third view!");
        Label secondText = new Label("Second view!");
        VBox secondView = new VBox();
        secondView.getChildren().addAll(toThirdView, secondText);

        // third view
        Label thirdText = new Label("Third view!");
        Button toFirstView = new Button("To the first view!");
        GridPane thirdView = new GridPane();
        thirdView.add(thirdText, 0,0);
        thirdView.add(toFirstView, 1, 1);

        Scene first = new Scene(firstView);
        Scene second = new Scene(secondView);
        Scene third = new Scene(thirdView);

        toSecondView.setOnAction((event) -> {
            window.setScene((second));
        });

        toThirdView.setOnAction((event) -> {
            window.setScene(third);
        });

        toFirstView.setOnAction((event) -> {
            window.setScene(first);
        });

        window.setScene(first);
        window.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }
}

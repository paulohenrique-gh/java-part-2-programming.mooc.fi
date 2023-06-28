package smiley;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage stage) {
        Canvas paintingCanvas = new Canvas(800, 800);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();

        painter.setFill(Color.BLACK);
        painter.fillRect(200, 100, 100, 100);
        painter.fillRect(500, 100, 100, 100);
        painter.fillRect(100, 400, 100, 100);
        painter.fillRect(600, 400, 100, 100);
        painter.fillRect(200, 500, 100, 100);
        painter.fillRect(300, 500, 100, 100);
        painter.fillRect(400, 500, 100, 100);
        painter.fillRect(500, 500, 100, 100);

        BorderPane layout = new BorderPane();
        layout.setCenter(paintingCanvas);

        Scene scene = new Scene(layout);
        scene.setFill(Color.WHITE);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(SmileyApplication.class);
    }
}
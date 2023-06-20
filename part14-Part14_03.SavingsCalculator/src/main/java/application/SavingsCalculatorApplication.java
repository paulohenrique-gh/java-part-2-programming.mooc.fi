package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    @Override
    public void start(Stage stage) {

        BorderPane mainLayout = new BorderPane();

        // center of mainLayout
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis(0, 27500, 2500);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        mainLayout.setCenter(lineChart);

        // top of mainLayout
        VBox slidersLayout = new VBox();

            // first borderpane to add to vbox
        BorderPane savings = new BorderPane();
                // contents of borderpane savings
        Label monthlySavings = new Label("Monthly savings");
        Slider savingsSlider = new Slider(25, 250, 50);
        savingsSlider.setPrefWidth(250);
        savingsSlider.setShowTickMarks(true);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setMajorTickUnit(25);
        savingsSlider.setBlockIncrement(1);
        savingsSlider.setSnapToTicks(true);
        Label sliderSelection = new Label(String.format("%.1f", savingsSlider.getValue()));

        savingsSlider.valueProperty().addListener((change, oldValue, newValue) -> {
            sliderSelection.setText(String.format("%.2f", savingsSlider.getValue()));
        });

        savings.setLeft(monthlySavings);
        savings.setCenter(savingsSlider);
        savings.setRight(sliderSelection);

        savings.setPadding(new Insets(10, 10, 10, 10));

        slidersLayout.getChildren().add(savings);

            // first borderpane to add to vbox
        BorderPane interest = new BorderPane();
                // contents of interest borderpane
        Label interestRate = new Label("Yearly interest rate");
        Slider interestSlider = new Slider(0, 10, 2.33);
        interestSlider.setPrefWidth(250);
        interestSlider.setShowTickMarks(true);
        interestSlider.setShowTickLabels(true);
        interestSlider.setMajorTickUnit(2);
        interestSlider.setBlockIncrement(1);
        interestSlider.setSnapToTicks(true);
        Label interestSelection = new Label(String.format("%.2f", interestSlider.getValue()));

        interestSlider.valueProperty().addListener((change, oldValue, newValue) -> {
            interestSelection.setText(String.format("%.2f", interestSlider.getValue()));
        });

        interest.setLeft(interestRate);
        interest.setCenter(interestSlider);
        interest.setRight(interestSelection);

        interest.setPadding(new Insets(10, 10, 10, 10));

        slidersLayout.getChildren().add(interest);


        mainLayout.setTop(slidersLayout);

        Scene scene = new Scene(mainLayout, 600, 400);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

}

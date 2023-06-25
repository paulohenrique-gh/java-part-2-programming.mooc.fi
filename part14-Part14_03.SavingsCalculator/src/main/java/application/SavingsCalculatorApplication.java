package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SavingsCalculatorApplication extends Application {

    @Override
    public void start(Stage stage) {
        ///////////////////////////////////////////// User interface

        BorderPane mainLayout = new BorderPane(); // this will be return by the class

        // center of mainLayout
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis(0, 125000, 25000);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");
        lineChart.setLegendVisible(false);

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
        Slider interestSlider = new Slider(0, 10, 10);
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

        // Displaying the savings

        int savingsValue = (int) savingsSlider.getValue();

        XYChart.Series savingsData = new XYChart.Series();

        for (int year = 0; year <= 30; year++) {
            int yearlySavings = savingsValue * year * 12;
            savingsData.getData().add(new XYChart.Data(year, yearlySavings));
        }
        lineChart.getData().add(savingsData);

        int interestValue = (int) interestSlider.getValue();

        XYChart.Series interestData = new XYChart.Series();

        double capital = savingsValue;
        double updatedCapital = 0;

        for (int year = 0; year <= 30; year++) {
            double returnPerYear = capital * 12; //ano 1 = 600
            if (year == 0) {
                returnPerYear = 0;
            }
            double yearlySavings = updatedCapital + returnPerYear * (Math.pow(1 + ((interestValue * 1.0) / 100), year));
            updatedCapital = yearlySavings;
            interestData.getData().add(new XYChart.Data(year, yearlySavings));
        }
        lineChart.getData().add(interestData);

        savingsSlider.valueProperty().addListener((change, oldValue, newValue) -> {
            savingsData.getData().clear();
            int updatedSavingsValue = (int) savingsSlider.getValue();
            for (int year = 0; year <= 30; year++) {
                int yearlySavings = updatedSavingsValue * year * 12;
                savingsData.getData().add(new XYChart.Data(year, yearlySavings));
            }

            interestData.getData().clear();
            double updatedInterestValue = interestSlider.getValue();
            double capitalNew = savingsSlider.getValue();
            double updatedCapitalNew = 0.0;

            for (int year = 0; year <= 30; year++) {
                double returnPerYear = capitalNew * 12;
                if (year == 0) returnPerYear = 0;
                double yearlySavings = updatedCapitalNew + returnPerYear * Math.pow(1 + (updatedInterestValue / 100), year);
                updatedCapitalNew = yearlySavings;
                interestData.getData().add(new XYChart.Data(year, yearlySavings));
            }

        });

        interestSlider.valueProperty().addListener((change, oldValue, newValue) -> {
            interestData.getData().clear();
            double updatedInterestValue = interestSlider.getValue();
            double capitalNew = savingsSlider.getValue();
            double updatedCapitalNew = 0.0;

            for (int year = 0; year <= 30; year++) {
                double returnPerYear = capitalNew * 12;
                if (year == 0) returnPerYear = 0;
                double yearlySavings = updatedCapitalNew + returnPerYear * Math.pow(1 + (updatedInterestValue / 100), year);
                updatedCapitalNew = yearlySavings;
                interestData.getData().add(new XYChart.Data(year, yearlySavings));
            }
        });

        mainLayout.setTop(slidersLayout);

        Scene scene = new Scene(mainLayout, 320, 300); // 320,300

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

}
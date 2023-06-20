package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {
    public void start(Stage stage) {
        // create axis
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis();

        // set title for axis
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        // create line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");

        // create data set for the chart
        XYChart.Series shanghaiData = new XYChart.Series();
        shanghaiData.setName("Helsinki");

        // add points to dataset
        shanghaiData.getData().add(new XYChart.Data(2007, 73));
        shanghaiData.getData().add(new XYChart.Data(2008, 68));
        shanghaiData.getData().add(new XYChart.Data(2009, 72));
        shanghaiData.getData().add(new XYChart.Data(2010, 72));
        shanghaiData.getData().add(new XYChart.Data(2011, 74));
        shanghaiData.getData().add(new XYChart.Data(2012, 73));
        shanghaiData.getData().add(new XYChart.Data(2013, 76));
        shanghaiData.getData().add(new XYChart.Data(2014, 73));
        shanghaiData.getData().add(new XYChart.Data(2015, 67));
        shanghaiData.getData().add(new XYChart.Data(2016, 56));
        shanghaiData.getData().add(new XYChart.Data(2017, 56));

        // add data to line chart
        lineChart.getData().add(shanghaiData);

        // display
        Scene scene = new Scene(lineChart, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }
}
package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PartiesApplication extends Application {
    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        Map<String, Map<Integer, Double>> values = read();

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        values.keySet().stream().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            values.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            lineChart.getData().add(data);
        });

        Scene scene = new Scene(lineChart, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public Map<String, Map<Integer, Double>> read() {
        String file = "C:\\Users\\ph192\\OneDrive\\Documentos\\IdeaProjects\\TMCProjects\\mooc-java-programming-ii\\demo1\\src\\main\\java\\com\\example\\demo1\\partiesdata.tsv";

        Map<String, Map<Integer, Double>> values = new HashMap<>();

        try (Scanner scanner = new Scanner(Paths.get(file))) {

            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split("\t");
                String partyName = parts[0];
                Map<Integer, Double> yearAndSupport = new HashMap();
                for (int i = 1968, j = 1; i <= 2008; i += 4, j++) {
                    int year = i;
                    if (parts[j].equals("-")) {
                        continue;
                    }
                    double partySupport = Double.valueOf(parts[j]);
                    yearAndSupport.put(year, partySupport);
                    values.put(partyName, yearAndSupport);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return values;
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

}
package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    public void start(Stage window) {
        window.setTitle("Hello World!");
        window.show();
    }

    public static void main(String[] args) {
        launch(HelloApplication.class);
    }
}
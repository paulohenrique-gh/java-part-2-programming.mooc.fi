package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class TicTacToeApplication extends Application {
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();

        Label currentTurn = new Label("Turn: X");
        Label gameOver = new Label("The end!");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        String[][] gridArray = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gridArray[i][j] = "";
            }
        }

        Button c00 = new Button();
        c00.setOnMouseClicked((event) -> {
            if (currentTurn.getText().equals("Turn: X")) {
                gridArray[0][0] = "X";
            } else if (currentTurn.getText().equals("Turn: O")) {
                gridArray[0][0] = "O";
            }

            actionsOnClick(c00, currentTurn, gameOver, gridArray, layout);
        });

        Button c01 = new Button();
        c01.setOnMouseClicked((event) -> {
            if (currentTurn.getText().equals("Turn: X")) {
                gridArray[1][0] = "X";
            } else if (currentTurn.getText().equals("Turn: O")) {
                gridArray[1][0] = "O";
            }

            actionsOnClick(c01, currentTurn, gameOver, gridArray, layout);
        });

        Button c02 = new Button();
        c02.setOnMouseClicked((event) -> {
            if (currentTurn.getText().equals("Turn: X")) {
                gridArray[2][0] = "X";
            } else if (currentTurn.getText().equals("Turn: O")) {
                gridArray[2][0] = "O";
            }

            actionsOnClick(c02, currentTurn, gameOver, gridArray, layout);
        });

        Button c10 = new Button();
        c10.setOnMouseClicked((event) -> {
            if (currentTurn.getText().equals("Turn: X")) {
                gridArray[0][1] = "X";
            } else if (currentTurn.getText().equals("Turn: O")) {
                gridArray[0][1] = "O";
            }

            actionsOnClick(c10, currentTurn, gameOver, gridArray, layout);
        });

        Button c11 = new Button();
        c11.setOnMouseClicked((event) -> {
            if (currentTurn.getText().equals("Turn: X")) {
                gridArray[1][1] = "X";
            } else if (currentTurn.getText().equals("Turn: O")) {
                gridArray[1][1] = "O";
            }

            actionsOnClick(c11, currentTurn, gameOver, gridArray, layout);
        });

        Button c12 = new Button();
        c12.setOnMouseClicked((event) -> {
            if (currentTurn.getText().equals("Turn: X")) {
                gridArray[2][1] = "X";
            } else if (currentTurn.getText().equals("Turn: O")) {
                gridArray[2][1] = "O";
            }

            actionsOnClick(c12, currentTurn, gameOver, gridArray, layout);
        });

        Button c20 = new Button();
        c20.setOnMouseClicked((event) -> {
            if (currentTurn.getText().equals("Turn: X")) {
                gridArray[0][2] = "X";
            } else if (currentTurn.getText().equals("Turn: O")) {
                gridArray[0][2] = "O";
            }

            actionsOnClick(c20, currentTurn, gameOver, gridArray, layout);
        });

        Button c21 = new Button();
        c21.setOnMouseClicked((event) -> {
            if (currentTurn.getText().equals("Turn: X")) {
                gridArray[1][2] = "X";
            } else if (currentTurn.getText().equals("Turn: O")) {
                gridArray[1][2] = "O";
            }

            actionsOnClick(c21, currentTurn, gameOver, gridArray, layout);
        });

        Button c22 = new Button();
        c22.setOnMouseClicked((event) -> {
            if (currentTurn.getText().equals("Turn: X")) {
                gridArray[2][2] = "X";
            } else if (currentTurn.getText().equals("Turn: O")) {
                gridArray[2][2] = "O";
            }

            actionsOnClick(c22, currentTurn, gameOver, gridArray, layout);
        });

        grid.add(c00, 0, 0);
        grid.add(c01, 0, 1);
        grid.add(c02, 0, 2);
        grid.add(c10, 1, 0);
        grid.add(c11, 1, 1);
        grid.add(c12, 1, 2);
        grid.add(c20, 2, 0);
        grid.add(c21, 2, 1);
        grid.add(c22, 2, 2);

        layout.setTop(currentTurn);
        layout.setCenter(grid);

        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.show();
    }

    public String isWinner(String[][] gridArray) {
        if ((gridArray[0][0] == "X" && gridArray[0][1] == "X" && gridArray[0][2] == "X") ||
            (gridArray[1][0] == "X" && gridArray[1][1] == "X" && gridArray[1][2] == "X") ||
            (gridArray[2][0] == "X" && gridArray[2][1] == "X" && gridArray[2][2] == "X") ||
            (gridArray[0][0] == "X" && gridArray[1][0] == "X" && gridArray[2][0] == "X") ||
            (gridArray[0][1] == "X" && gridArray[1][1] == "X" && gridArray[2][1] == "X") ||
            (gridArray[0][2] == "X" && gridArray[1][2] == "X" && gridArray[2][2] == "X") ||
            (gridArray[0][0] == "X" && gridArray[1][1] == "X" && gridArray[2][2] == "X") ||
            (gridArray[0][2] == "X" && gridArray[1][1] == "X" && gridArray[2][0] == "X")) {
            return "X";
        }
        if ((gridArray[0][0] == "O" && gridArray[0][1] == "O" && gridArray[0][2] == "O") ||
            (gridArray[1][0] == "O" && gridArray[1][1] == "O" && gridArray[1][2] == "O") ||
            (gridArray[2][0] == "O" && gridArray[2][1] == "O" && gridArray[2][2] == "O") ||
            (gridArray[0][0] == "O" && gridArray[1][0] == "O" && gridArray[2][0] == "O") ||
            (gridArray[0][1] == "O" && gridArray[1][1] == "O" && gridArray[2][1] == "O") ||
            (gridArray[0][2] == "O" && gridArray[1][2] == "O" && gridArray[2][2] == "O") ||
            (gridArray[0][0] == "O" && gridArray[1][1] == "O" && gridArray[2][2] == "O") ||
            (gridArray[0][2] == "O" && gridArray[1][1] == "O" && gridArray[2][0] == "O")) {
            return "O";
        }
        return "";
    }

    public void actionsOnClick(Button button, Label currentTurn, Label gameOver, String[][] gridArray, BorderPane layout) {


        if (currentTurn.getText().equals("Turn: X")) {
            button.setText("X");
            currentTurn.setText("Turn: O");
            if (!isWinner(gridArray).equals("")) {
                layout.setTop(gameOver);
            }
        } else if (currentTurn.getText().equals("Turn: O")) {
            button.setText("O");
            currentTurn.setText("Turn: X");
            if (!isWinner(gridArray).equals("")) {
                layout.setTop(gameOver);
            }
        }

        button.setDisable(true);

    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}

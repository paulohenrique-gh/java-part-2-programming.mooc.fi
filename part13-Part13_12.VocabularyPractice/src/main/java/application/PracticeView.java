package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {

    private Dictionary dictionary;
    private String word;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = this.dictionary.getRandomWord();
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label wordPrompt = new Label("Translate the word '" + word + "'");
        TextField translationField = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button checkButton = new Button("Check");
        Label feedback = new Label("");

        checkButton.setOnMouseClicked((event) -> {
            String translation = translationField.getText();
            if (this.dictionary.get(this.word).equals(translation)) {
                feedback.setText("Correct!");
            } else {
                feedback.setText("Incorrect! The translation for the word '" + this.word + "' is '" + this.dictionary.get(this.word) + "'.");
                return;
            }

            this.word = this.dictionary.getRandomWord();
            wordPrompt.setText("Translate the word '" + word + "'");
            translationField.clear();
        });

        layout.add(wordPrompt, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(checkButton, 0, 2);
        layout.add(feedback, 0, 3);

        return layout;
    }

}
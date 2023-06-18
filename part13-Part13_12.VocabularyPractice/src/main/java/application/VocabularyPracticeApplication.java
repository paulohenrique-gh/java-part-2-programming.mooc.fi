package application;


// END SOLUTION
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VocabularyPracticeApplication extends Application {

    private Dictionary dictionary;

    @Override
    public void init() throws Exception {
        this.dictionary = new Dictionary();
    }

    @Override
    public void start(Stage stage) throws Exception {
        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);

        BorderPane layout = new BorderPane();

        HBox menu = new HBox();
        menu.setSpacing(10);
        menu.setPadding(new Insets(20, 20, 20, 20));

        Button enterButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");

        menu.getChildren().addAll(enterButton, practiceButton);
        layout.setTop(menu);

        enterButton.setOnAction((event) -> {
            layout.setCenter(inputView.getView());
        });
        practiceButton.setOnAction((event) -> {
            layout.setCenter(practiceView.getView());
        });

        layout.setCenter(inputView.getView());

        Scene scene = new Scene(layout, 400, 300);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}

package title;

import javafx.application.Application;
import javafx.stage.Stage;

public class UserTitle extends Application {
    public void start(Stage window) {
        Parameters parameters = getParameters();
        String title = parameters.getNamed().get("title");

        window.setTitle("Title: " + title);
        window.show();
    }
}
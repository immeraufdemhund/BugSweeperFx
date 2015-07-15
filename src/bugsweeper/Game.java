package bugsweeper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by snyder on 2015-07-14.
 */
public class Game extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Bug Sweeper Fx");

        primaryStage.setScene(new Scene(new VBox(new Label("Search:"), new Button("Go"))));
        primaryStage.show();
    }
}

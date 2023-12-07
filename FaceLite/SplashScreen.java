import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class SplashScreen {
    private Stage stage;
    public SplashScreen(Stage stage) {
        this.stage = stage;
    }
    private void switchToMainScene() {
        // Create the main scene content
        Label mainLabel = new Label("Welcome");
        mainLabel.setStyle("-fx-font-size: 24;");
        mainRoot.getChildren().add(mainLabel);

        // Create the main scene
        Scene mainScene = new Scene(mainRoot, 400, 300);

        // Create a new stage for the main scene
        stage.setTitle("FaceLite");
        stage.setScene(mainScene);
        stage.show();
    }
}

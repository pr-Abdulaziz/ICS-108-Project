import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

// Build the screen
public class BuildScreen {
    private Stage stage;
    private Scene mainScene;
    private Content content;
    private Changing changing;
    private Adding adding;
    private Users users;
    private Updated updated;
    private BorderPane pane;

    public BuildScreen(Stage stage) {
        this.stage = stage;
        buildGUI();
    }
    
    public void buildGUI() {
        // Create the main scene content
        StackPane mainRoot = new StackPane();
        VBox vBox = new VBox(20);

        
        BackgroundFill backgroundFill = new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        mainRoot.setBackground(background);

        Label welcomeL = new Label("Welcome to FaceLite");
        welcomeL.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Ubuntu/Ubuntu-Bold.ttf"),30));
        welcomeL.setTextFill(Color.WHITE);
        
        // Create the main scene
        mainScene = new Scene(mainRoot, 700, 900);
        // Create a timeline for the splash screen duration
        Image icon = new Image(getClass().getResource("assests/Icon.png").toString());
        ImageView iconView = new ImageView(icon);
        iconView.setFitHeight(100);
        iconView.setFitWidth(100);
        
        vBox.getChildren().addAll(iconView,welcomeL);

        mainRoot.getChildren().add(vBox);
        vBox.setAlignment(Pos.CENTER);
        // Timeline to close the stage and trigger fade-out after 5 seconds
        Duration splashDuration = Duration.seconds(5);
        
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), vBox);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        KeyFrame splashKeyFrame = new KeyFrame(
                splashDuration,
                e -> {
                    fadeOut.play();
                    fadeOut.setOnFinished(event -> {
                        // After when the icon and image disapear, we need to call switchToMainScene
                        switchToMainScene();
                    });
                }
        );
        // FOR ICON:

        // Create a new stage for the main scene
        stage.setScene(mainScene);
        stage.getIcons().add(icon);
        stage.setTitle("FaceLite");
        stage.setMinHeight(600);
        stage.setMinWidth(900);
        stage.getIcons().add(icon);
        stage.setHeight(700);
        stage.setWidth(900);
        
        Timeline splashTimeline = new Timeline(splashKeyFrame);
        splashTimeline.play();

        
    }
    public void closeProgram() {
        boolean answer = ConfirmBox.display("Exit", "Sure you want to close the program?");
        if (answer) {
            stage.close();
        }
    }  

    // Method to switch to the main scene
    private void switchToMainScene() {


        pane = new BorderPane();
        VBox vBox = new VBox(10);
        updated = new Updated();
        content = new Content(updated);
        adding = new Adding(content);
        users = new Users();
        changing = new Changing(content,users);

        vBox.getChildren().addAll(content,updated);
        pane.setLeft(changing);
        pane.setTop(adding);
        pane.setCenter(vBox);
        // FOR ICON:
        Image icon = new Image(getClass().getResource("assests/Icon.png").toString());

        stage.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        mainScene = new Scene(pane,700,900);
        stage.setScene(mainScene);
        stage.getIcons().add(icon);
        stage.setTitle("FaceLite");
        stage.setMinHeight(600);
        stage.setMinWidth(900);
        stage.getIcons().add(icon);
        stage.setHeight(700);
        stage.setWidth(900);
    }
}

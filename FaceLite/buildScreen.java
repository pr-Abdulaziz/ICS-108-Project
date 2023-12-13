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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileNotFoundException;

// Build the screen
public class BuildScreen {
    // DEFINING ALL INSTANCE VARIABLES.
    private Stage stage;
    private Scene mainScene;
    private Content content;
    private Changing changing;
    private Adding adding;
    private Users users;
    private Updated updated;
    protected static BorderPane pane;
    static File usersDataBase = new File("FaceLite/assests/usersDataBase.txt");


    public BuildScreen(Stage stage) {
        // HERE IS THE MAIN STAGE IN OUR PROGRAM.
        this.stage = stage;
        buildGUI();
    }
    
    // Create the main scene content
    public void buildGUI() {
        Users.readFromFile();

        StackPane mainRoot = new StackPane();
        VBox vBox = new VBox(20);
        // SETTING A BACKGROUND
        BackgroundFill backgroundFill = new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        mainRoot.setBackground(background);

        // AFTER RUNNING A PROGRAM, YOU WILL SEE A WELCOMING SCREEN.
        Label welcomeL = new Label("Welcome to FaceLite");
        welcomeL.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Ubuntu/Ubuntu-Bold.ttf"),30));
        welcomeL.setTextFill(Color.WHITE);
        
        // Create the main scene
        mainScene = new Scene(mainRoot, 700, 900);
        Image icon = new Image(getClass().getResource("assests/Icon.png").toString());
        ImageView iconView = new ImageView(icon);
        iconView.setFitHeight(100);
        iconView.setFitWidth(100);
        // DESIGNING AND ICON.
        Rectangle borderRadius = new Rectangle(iconView.getFitWidth(), iconView.getFitHeight());
        borderRadius.setArcWidth(20);
        borderRadius.setArcHeight(20);

        iconView.setClip(borderRadius);

        
        vBox.getChildren().addAll(iconView,welcomeL);

        mainRoot.getChildren().add(vBox);
        vBox.setAlignment(Pos.CENTER);
        // Timeline to close the stage and trigger fade-out after 5 seconds
        Duration splashDuration = Duration.seconds(4);
        
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

        // Create a new stage for the main scene
        stage.setScene(mainScene);
        stage.getIcons().add(icon);
        stage.setTitle("FaceLite");
        stage.setMinHeight(600);
        stage.setMinWidth(900);
        stage.getIcons().add(icon);
        stage.setHeight(700);
        stage.setWidth(1000);
        stage.setResizable(false);
        
        Timeline splashTimeline = new Timeline(splashKeyFrame);
        splashTimeline.play();

        
    }
    // HERE FOR FOR EXITING PROGRAM.
    public void closeProgram() {
        // IMPORT THE TITLE AND MESSAGE INTO THE CONFIRM BOX CLASS.
        boolean answer = ConfirmBox.display("Exit", "Sure you want to close the program?");
        if (answer) {
            stage.close();
            // Using PrintWrite to write all information about users inside the document
            PrintWriter output;
            try {
                output = new PrintWriter(usersDataBase);
                if (Users.userData.size() == 0) {
                    throw new NullPointerException();
                } else {
                    for (Entry<String, Object[]> entry : Users.userData.entrySet()) {
                        String userName = entry.getKey();
                        Object[] data = entry.getValue();
                        ArrayList<String> info = new ArrayList<String>();
                        ArrayList<String> friends = new ArrayList<String>();

                        for (Object value : data) {
                            if (value instanceof String) {
                                info.add((String) value);
                            } else if (value instanceof ArrayList<?>) {
                                ArrayList<String> arrayList = (ArrayList<String>) value;
                                for (int i = 0; i < arrayList.size(); i++) {
                                    friends.add(arrayList.get(i));
                                }
                            }
                        }
                        // SPLITING THE MAIN INFORMATION USING '///'.
                        output.print(userName + "///");
                        for (int index = 0; index < info.size(); index++) {
                            if (index == info.size()-1) 
                                output.print(info.get(index));
                            else {
                                output.print(info.get(index)+"///");
                            }
                        }
                        // SPLITING THE A LIST OF FRIENDS USING '--->>>'.
                        if (friends.size() > 0) {
                            output.print("///");
                            for (int i = 0; i < friends.size(); i++) {
                                output.print(friends.get(i) + "--->>>");
                            }
                        }
                        output.println("");
                    }
                }
                output.close();
            } catch(FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch(NullPointerException ex) {
                System.out.println(ex.getMessage());
            } 
        }
    }  
    // THE MAIN SCENE
    private void switchToMainScene() {
        pane = new BorderPane();
        BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        pane.setBackground(background);

        VBox vBox = new VBox(10);
        updated = new Updated();
        content = new Content(updated);
        adding = new Adding(content);
        users = new Users();
        changing = new Changing(content, users);

        vBox.getChildren().addAll(content, updated);
        pane.setLeft(changing);
        pane.setTop(adding);
        pane.setCenter(vBox);

        // FOR ICON: 
        Image icon = new Image(getClass().getResource("assests/Icon.png").toString());

        stage.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        mainScene = new Scene(pane,700,1000);
        stage.setScene(mainScene);
        stage.getIcons().add(icon);
        stage.setTitle("FaceLite");
        stage.setMinHeight(600);
        stage.setMinWidth(900);
        stage.getIcons().add(icon);
        stage.setHeight(700);
        stage.setWidth(1000);
        stage.setResizable(false);
    }
}

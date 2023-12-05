import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

// Build the screen
public class buildScreen {
    private Content content;
    private Changing changing;
    private Adding adding;
    private Users users;
    private Stage stage;
    private Updated updated;
    private BorderPane pane;

    public buildScreen(Stage stage) {
        this.stage = stage;
        buildGUI();
    }
    
    public void buildGUI() {
        
        pane = new BorderPane();
        VBox vBox = new VBox(10);
        
        updated = new Updated();
        content = new Content(updated);
        adding = new Adding(content,updated);
        users = new Users();
        changing = new Changing(content,users);

        vBox.getChildren().addAll(content,updated);
        pane.setLeft(changing);
        pane.setTop(adding);
        pane.setCenter(vBox);
        // FOR ICON:
        Image icon = new Image(getClass().getResource("assests/Disktop_Icon.jpg").toString());

        stage.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        Scene scene = new Scene(pane,700,900);
        stage.setScene(scene);
        stage.getIcons().add(icon);
        stage.setTitle("FaceLite");
        stage.setMinHeight(600);
        stage.setMinWidth(900);
        stage.getIcons().add(icon);
        stage.setHeight(700);
        stage.setWidth(900);
        
    }
    public void closeProgram() {
        boolean answer = ConfirmBox.display("Exit", "Sure you want to close the program?");
        if (answer) {
            stage.close();
        }
    }  
}

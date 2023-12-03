import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

// Build the screen
public class buildScreen {
    private Content content;
    private Changing changing;
    private Adding adding;
    private Users users;
    private Stage stage;
    private BorderPane pane;

    public buildScreen(Stage stage) {
        this.stage = stage;
        buildGUI();
    }

    public void buildGUI() {

        pane = new BorderPane();
        
        content = new Content();
        adding = new Adding(content);
        users = new Users();
        changing = new Changing(content,users);
        pane.setLeft(changing);
        pane.setTop(adding);
        pane.setCenter(content);

        Scene scene = new Scene(pane,600,900);
        stage.setScene(scene);
        stage.setMinHeight(600);
        stage.setMinWidth(900);
        stage.setHeight(600);
        stage.setWidth(900);
    }    
}

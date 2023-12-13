import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // STARTING THE PROGRAM.
        try {
            window = stage; 
            new BuildScreen(window);
            
            // Show the stage
            window.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
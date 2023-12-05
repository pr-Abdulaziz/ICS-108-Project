import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Updated extends HBox{
    private String message;
    private Label messageL;

    public Updated() {
        BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        setBackground(background);
        setPadding(new Insets(10, 10, 10, 10));
        

        messageL = new Label();
        messageL.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),15));

        getChildren().add(messageL);
        setAlignment(Pos.BOTTOM_CENTER);
    }
    public void setMessage(String newMessage) {
        this.message = newMessage;
        if (message != null) {
            messageL.setText(newMessage);
        } 
    }
}

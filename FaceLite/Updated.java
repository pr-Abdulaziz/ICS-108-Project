import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class Updated extends HBox{
    private String message;
    private Label messageL;

    public Updated() {
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

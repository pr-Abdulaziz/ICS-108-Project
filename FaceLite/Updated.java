import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class Updated extends HBox{
    private String message;
    private Label messageL;

    // GETTING ANY MEESAGE AND IMPORT IT INTO THE CONTENT.
    public Updated() {
        // GETTING FROM MESSAGE
        messageL = new Label();
        messageL.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),15));

        getChildren().add(messageL);
        setAlignment(Pos.BOTTOM_CENTER);
    }
    public void setMessage(String newMessage) {
        // HERE WE CAN CHANGE ANY MESSAGE.
        this.message = newMessage;
        // CHECKING FIRST IF THE MESSAGE IS 'null' OR NOT, BECAUSE IF YOU START THE PROGRAM, THE MESSAGE WILL FIRST BE 'null'.
        if (message != null) {
            messageL.setText(newMessage);
        } 
    }
}

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

public class ConfirmBox {
    public static boolean answer;

    public static boolean display(String title, String message) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        Label lable = new Label();
        lable.setText(message);
        
        Button yes = new Button("yes");
        Button no = new Button("no");

         
        VBox vbox = new VBox(20);
        HBox buttons = new HBox(20);
        buttons.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20,20,20,20));
        vbox.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(yes,no);
        vbox.getChildren().addAll(lable,buttons);
        
        yes.setOnAction(e -> {
            answer = true; 
            window.close();
        });
        no.setOnAction(e -> {
            answer = false;
            window.close();
        });
        
        Scene scene = new Scene(vbox);

        window.setMaxHeight(200);
        window.setMaxWidth(250);
        window.setMinHeight(150);
        window.setMinWidth(250);
        window.setHeight(150);
        window.setWidth(250);
        window.setScene(scene);
        window.showAndWait();
        
        return answer;
    }
}

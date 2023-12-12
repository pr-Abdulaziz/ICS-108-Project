import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ConfirmBox {
    public static boolean answer;

    public static boolean display(String title, String message) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        Label label = new Label();
        label.setText(message);

        HBox hbox = new HBox(15);

        
        Image image = new Image(ConfirmBox.class.getResource("assests/warning_Image.jpg").toString());
        ImageView imageWarning = new ImageView(image);
        imageWarning.setFitHeight(30);
        imageWarning.setFitWidth(30);

        hbox.getChildren().addAll(imageWarning,label);

        Button yes = new Button("Yes");
        Button no = new Button("No");

        VBox vbox = new VBox(20);
        HBox buttons = new HBox(20);
        buttons.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(yes, no);
        vbox.getChildren().addAll(hbox, buttons);

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
        window.setMaxWidth(300);
        window.setMinHeight(150);
        window.setMinWidth(300);
        window.setHeight(150);
        window.setWidth(300);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}


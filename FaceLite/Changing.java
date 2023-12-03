import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class Changing extends VBox {
    private Users users;
    private Content content;
    public Changing(Content content, Users users) {
        this.content = content;
        this.users = users;
        initializeGUI();        
    } 
    public void initializeGUI() {
        // Variables
        GridPane gridPane = new GridPane();
        Button changeStatus = new Button("Change Status");
        Button changePicture = new Button("Change Picture");
        Button addFriend = new Button("Add Friend");
        TextField changeStatusField = new TextField();
        TextField changePictureField = new TextField();
        TextField addFriendField = new TextField();
        changeStatusField.setPromptText("Change Status");            
        changePictureField.setPromptText("Change Picture");            
        addFriendField.setPromptText("Friend name");

        // Setting Fonts for Buttons 
        changeStatus.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),12));
        changePicture.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),12));
        addFriend.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),12));

        changeStatusField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String name = content.getProfile().getName();
                String status = changeStatusField.getText();
                Users.updateStatus(name,status);
                String[] data = Users.userData.get(name);
                String pathImage = data[0];
                String updatedStatus = data[1];
                Profile profile = new Profile(name,pathImage,updatedStatus);
                content.updateContent(profile);               
            }
        });

        changePictureField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String name = content.getProfile().getName();
                String imagePath = changePictureField.getText();
                Users.updatePathImage(name,imagePath);
                String[] data = Users.userData.get(name);
                String pathImageUpdated = data[0];
                String status = data[1];
                Profile profile = new Profile(name,pathImageUpdated,status);
                content.updateContent(profile);             
            }
        });

        addFriendField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {

            }
        });

        changeStatus.setOnAction(e -> {
            String name = content.getProfile().getName();
            String status = changeStatusField.getText();
            Users.updateStatus(name,status);
            String[] data = Users.userData.get(name);
            String pathImage = data[0];
            String updatedStatus = data[1];
            Profile profile = new Profile(name,pathImage,updatedStatus);
            content.updateContent(profile);
        });
        changePicture.setOnAction(e -> {
            String name = content.getProfile().getName();
            String imagePath = changePictureField.getText();
            Users.updatePathImage(name,imagePath);
            String[] data = Users.userData.get(name);
            String pathImageUpdated = data[0];
            String status = data[1];
            Profile profile = new Profile(name,pathImageUpdated,status);
            content.updateContent(profile);
        });
        addFriend.setOnAction(e -> {
            //new Profile(changeStatusField.getText());
        });
        VBox vbox1 = new VBox(10);
        VBox vbox2 = new VBox(10);
        VBox vbox3 = new VBox(10);
        
        // Edit vbox
        changeStatus.setMaxWidth(Double.MAX_VALUE);
        changePicture.setMaxWidth(Double.MAX_VALUE);
        addFriend.setMaxWidth(Double.MAX_VALUE);
        vbox1.getChildren().addAll(changeStatusField,changeStatus);
        vbox2.getChildren().addAll(changePictureField,changePicture);
        vbox3.getChildren().addAll(addFriendField,addFriend);
        
        // Edit gridPane
        gridPane.add(vbox1,0,0);
        gridPane.add(vbox2,0,1);
        gridPane.add(vbox3,0,2);
        
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setPadding(new Insets(50,15,50,15));
        
        gridPane.setVgap(50);
        
        setAlignment(Pos.CENTER);
        getChildren().add(gridPane);
        setPadding(new Insets(75,15,15,15));
        VBox.setVgrow(gridPane, Priority.ALWAYS);

        // Setting Background 
        BackgroundFill backgroundFill = new BackgroundFill(Color.gray(0.75), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
        Background background = new Background(backgroundFill);
        setBackground(background);
    }

}
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
import java.util.ArrayList;


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
        changeStatusField.setPrefWidth(200);            
        changePictureField.setPrefWidth(200);            
        addFriendField.setPrefWidth(200);
        // Setting Fonts for Buttons 
        changeStatus.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),12));
        changePicture.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),12));
        addFriend.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),12));

        changeStatusField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String name = content.getProfile().getName();
                String status = changeStatusField.getText();
                Users.updateStatus(name,status);
                Object[] data = Users.userData.get(name);
                String pathImage = (String) data[0];
                String updatedStatus = (String) data[1];
                ArrayList<String> friends = (ArrayList<String>) data[2];
                Profile profile = new Profile(name,pathImage,updatedStatus,friends);
                content.updateContent(profile);               
            }
        });

        changePictureField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {

                if (event.getCode() == KeyCode.ENTER) {
                    String name = content.getProfile().getName();
                    String imagePath = changePictureField.getText();
                    Users.updatePathImage(name,imagePath);
                    Object[] data = Users.userData.get(name);
                    String pathImageUpdated = (String) data[0];
                    String status = (String) data[1];
                    ArrayList<String> friends = (ArrayList<String>) data[2];
                    Profile profile = new Profile(name,pathImageUpdated,status,friends);
                    content.updateContent(profile);             
                }
            }
        });

        addFriendField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {

                String name = content.getProfile().getName();
                String friendName = addFriendField.getText();
                if (!(name.equals(friendName))) {
                    ArrayList<String> friendNames = (ArrayList<String>) Users.userData.get(name)[2];
                    if ((Users.checkUser(friendName)) && !(friendNames.contains(friendName))) { 
                        Users.addingFriends(name,friendName);
                        Object[] data = Users.userData.get(name);
                        String pathImage = (String) data[0];
                        String status = (String) data[1];
                        ArrayList<String> friends = (ArrayList<String>) data[2];
                        Profile profile = new Profile(name,pathImage,status,friends);
                        content.updateContent(profile);

                        System.out.println("Friends of "+ name);
                        Object[] objectArray = Users.userData.get(name);
                        
                        String firstString = (String) objectArray[0];
                        String secondString = (String) objectArray[1];
                        ArrayList<String> stringList = (ArrayList<String>) objectArray[2];
                        
                        System.out.println("Images: " + firstString);
                        System.out.println("Status: " + secondString);
                        System.out.println("Friends: " + stringList);

                        System.out.println("=========================");
                        System.out.println("=========================");

                        System.out.println("Friends of "+ friendName);

                        Object[] objectArray2 = Users.userData.get(friendName);
                        
                        String firstString2 = (String) objectArray2[0];
                        String secondString2 = (String) objectArray2[1];
                        ArrayList<String> stringList2 = (ArrayList<String>) objectArray2[2];
                        
                        System.out.println("Images: " + firstString2);
                        System.out.println("Status: " + secondString2);
                        System.out.println("Friends: " + stringList2);
                    
                    }
                }
            }
        });

        changeStatus.setOnAction(e -> {
            String name = content.getProfile().getName();
            String status = changeStatusField.getText();
            Users.updateStatus(name,status);
            Object[] data = Users.userData.get(name);
            String pathImage = (String) data[0];
            String updatedStatus = (String) data[1];
            ArrayList<String> friends = (ArrayList<String>) data[2];
            Profile profile = new Profile(name,pathImage,updatedStatus,friends);
            content.updateContent(profile);
        });
        changePicture.setOnAction(e -> {
            String name = content.getProfile().getName();
            String imagePath = changePictureField.getText();
            Users.updatePathImage(name,imagePath);
            Object[] data = Users.userData.get(name);
            String pathImageUpdated = (String) data[0];
            String status = (String) data[1];
            ArrayList<String> friends = (ArrayList<String>) data[2];
            Profile profile = new Profile(name,pathImageUpdated,status,friends);
            content.updateContent(profile);
        });
        // ADDING 
        addFriend.setOnAction(e -> {
            String name = content.getProfile().getName();
            String friendName = addFriendField.getText();
            if (!(name.equals(friendName))) {
                ArrayList<String> friendNames = (ArrayList<String>) Users.userData.get(name)[2];
                if ((Users.checkUser(friendName)) && !(friendNames.contains(friendName))) { 
                    Users.addingFriends(name,friendName);
                    Object[] data = Users.userData.get(name);
                    String pathImage = (String) data[0];
                    String status = (String) data[1];
                    ArrayList<String> friends = (ArrayList<String>) data[2];
                    Profile profile = new Profile(name,pathImage,status,friends);
                    content.updateContent(profile);

                    System.out.println("Friends of "+ name);
                    Object[] objectArray = Users.userData.get(name);
                    
                    String firstString = (String) objectArray[0];
                    String secondString = (String) objectArray[1];
                    ArrayList<String> stringList = (ArrayList<String>) objectArray[2];
                    
                    System.out.println("Images: " + firstString);
                    System.out.println("Status: " + secondString);
                    System.out.println("Friends: " + stringList);

                    System.out.println("=========================");
                    System.out.println("=========================");

                    System.out.println("Friends of "+ friendName);

                    Object[] objectArray2 = Users.userData.get(friendName);
                    
                    String firstString2 = (String) objectArray2[0];
                    String secondString2 = (String) objectArray2[1];
                    ArrayList<String> stringList2 = (ArrayList<String>) objectArray2[2];
                    
                    System.out.println("Images: " + firstString2);
                    System.out.println("Status: " + secondString2);
                    System.out.println("Friends: " + stringList2);
                
                }
            }
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
        gridPane.setPadding(new Insets(50,5,50,5));
        
        gridPane.setVgap(50);
        
        setAlignment(Pos.CENTER);
        getChildren().add(gridPane);
        setPadding(new Insets(75,5,15,5));
        VBox.setVgrow(gridPane, Priority.ALWAYS);

        // Setting Background 
        BackgroundFill backgroundFill = new BackgroundFill(Color.gray(0.75), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
        Background background = new Background(backgroundFill);
        setBackground(background);
    }

}
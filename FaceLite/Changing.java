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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import java.io.File;
import java.util.ArrayList;


public class Changing extends VBox {
    private Users users;
    private Content content;
    
    public Users getUsers() {
        return users;
    }
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
        Button deleteFriend = new Button("Delete Friend");
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
        deleteFriend.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),12));
        
        changeStatus.setOnAction(e -> {
            if (content.getProfile() == null) {
                content.updatedMessage("Please select a profile to change the status");
            } else {
                String name = content.getProfile().getName();
                String status = name + " is " + changeStatusField.getText().trim();
                String pattern = "^[a-zA-Z_\\-0-9 ]*$";
                if ((status.matches(pattern))) {
                    if (!(status.isEmpty())) {
                        content.updatedMessage("Status updated to: "+status);
                        Users.updateStatus(name,status);
                        Object[] data = Users.userData.get(name);
                        String pathImage = (String) data[0];
                        String updatedStatus = status;
                        ArrayList<String> friends = (ArrayList<String>) data[2];
                        Profile profile = new Profile(name,pathImage,updatedStatus,friends);
                        content.updateContent(profile);               
                    } else {
                        content.updatedMessage("Status is empty, please write again");
                    }
                } else {
                    content.updatedMessage("Please write again, your status should only contains [a to z, _ , -]");
                }
            }
        });
        changeStatusField.setOnKeyPressed(event -> {         
            if (event.getCode() == KeyCode.ENTER) {
                if (content.getProfile() == null) {
                    content.updatedMessage("Please select a profile to change the status");
                } else {
                    String name = content.getProfile().getName();
                    String status = name + " is " + changeStatusField.getText().trim();
                    String pattern = "^[a-zA-Z_\\-0-9 ]*$";
                    if ((status.matches(pattern))) {
                        if (!(status.isEmpty())) {
                            content.updatedMessage("Status updated to: "+status);
                            Users.updateStatus(name,status);
                            Object[] data = Users.userData.get(name);
                            String pathImage = (String) data[0];
                            String updatedStatus = status;
                            ArrayList<String> friends = (ArrayList<String>) data[2];
                            Profile profile = new Profile(name,pathImage,updatedStatus,friends);
                            content.updateContent(profile);               
                        } else {
                            content.updatedMessage("Status is empty, please write again");
                        }
                    } else {
                        content.updatedMessage("Please write again, your status should only contains [a to z, _ , -]");
                    }
                }
            }

        });

        changePicture.setOnAction(e -> {
            if (content.getProfile() == null) {
                content.updatedMessage("Please select a profile to change the picture");
            } 
            else {
                String name = content.getProfile().getName();
                String imagePath = changePictureField.getText().trim();
                if (!(imagePath.isEmpty())) {
                    try { 
                        File image = new File("FaceLite/assests/images/"+imagePath);
                        // ClassLoader classLoader = Main.class.getClassLoader();
                        if (!image.exists()) {
                            throw new NullPointerException("Resource not found.");
                        }
                        
                        Users.updatePathImage(name,imagePath);
                        Object[] data = Users.userData.get(name);
                        String pathImageUpdated = (String) data[0];
                        String status = (String) data[1];
                        ArrayList<String> friends = (ArrayList<String>) data[2];
                        Profile profile = new Profile(name,pathImageUpdated,status,friends);
                        content.updatedMessage("Picture Updated");
                        content.updateContent(profile);
                    } catch (NullPointerException ex) {
                        // Handle the case where the resource is not found
                        content.updatedMessage("Photo not found in resources");
                    }
                } else {
                    content.updatedMessage("Photo not found in resources");
                }
            }
        });
        
        changePictureField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                if (content.getProfile() == null) {
                    content.updatedMessage("Please select a profile to change the picture");
                } 
                else {
                    String name = content.getProfile().getName();
                    String imagePath = changePictureField.getText().trim();
                    if (!(imagePath.isEmpty())) {
                        try { 
                            File image = new File("FaceLite/assests/images/"+imagePath);
                            // ClassLoader classLoader = Main.class.getClassLoader();
                            if (!image.exists()) {
                                throw new NullPointerException("Resource not found.");
                            }
                            
                            Users.updatePathImage(name,imagePath);
                            Object[] data = Users.userData.get(name);
                            String pathImageUpdated = (String) data[0];
                            String status = (String) data[1];
                            ArrayList<String> friends = (ArrayList<String>) data[2];
                            Profile profile = new Profile(name,pathImageUpdated,status,friends);
                            content.updatedMessage("Picture Updated");
                            content.updateContent(profile);
                        } catch (NullPointerException ex) {
                            // Handle the case where the resource is not found
                            content.updatedMessage("Photo not found in resources");
                        }
                    } else {
                        content.updatedMessage("Photo not found in resources");
                    }
                }
            }
        });
        // ADDING 
        addFriend.setOnAction(e -> {
            if (content.getProfile() == null) {
                content.updatedMessage("Please select a profile to change the friends");
            } else {
                String name = content.getProfile().getName();
                String friendName = addFriendField.getText();
                ArrayList<String> friendNames = (ArrayList<String>) Users.userData.get(name)[2];
                if (!(name.equals(friendName)) && (Users.checkUser(friendName)) && !(friendNames.contains(friendName))) {
                    content.updatedMessage(friendName+" added as friend");
                    Users.addingFriends(name,friendName);
                    Object[] data = Users.userData.get(name);
                    String pathImage = (String) data[0];
                    String status = (String) data[1];
                    ArrayList<String> friends = (ArrayList<String>) data[2];
                    Profile profile = new Profile(name,pathImage,status,friends);
                    content.updateContent(profile);                
                }
                else{
                    content.updatedMessage("friend with the name "+friendName+" can not be added"); 
                }
            }
        });

        deleteFriend.setOnAction(e -> {
            if (content.getProfile() == null) {
                content.updatedMessage("Please select a profile to change the friends");
            } else {
                String name = content.getProfile().getName();
                String friendName = addFriendField.getText();
                ArrayList<String> friendNames = (ArrayList<String>) Users.userData.get(name)[2];
                if (!(name.equals(friendName)) && (Users.checkUser(friendName)) && (friendNames.contains(friendName))) {
                    content.updatedMessage(friendName+" is deleted from your frirnds list.");
                    Users.deletingFriends(name, friendName);
                    Object[] data = Users.userData.get(name);
                    String pathImage = (String) data[0];
                    String status = (String) data[1];
                    ArrayList<String> friends = (ArrayList<String>) data[2];
                    Profile profile = new Profile(name,pathImage,status,friends);
                    content.updateContent(profile);                
                }
                else{
                    content.updatedMessage("friend with the name "+friendName+" can not be deleted"); 
                }
            }
        });


        VBox vbox1 = new VBox(10);
        VBox vbox2 = new VBox(10);
        VBox vbox3 = new VBox(10);

        HBox hBox = new HBox(5);
        
        // Edit vbox
        changeStatus.setMaxWidth(Double.MAX_VALUE);
        changePicture.setMaxWidth(Double.MAX_VALUE);
        addFriend.setPrefWidth(100);
        deleteFriend.setPrefWidth(100);

        vbox1.getChildren().addAll(changeStatusField,changeStatus);
        vbox2.getChildren().addAll(changePictureField,changePicture);

        hBox.getChildren().addAll(addFriend,deleteFriend);
        vbox3.getChildren().addAll(addFriendField,hBox);
        
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
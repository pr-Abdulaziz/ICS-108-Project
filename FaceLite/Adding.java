import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Adding extends HBox {
    private Content content;
    
    public Content getContent() {
        return content;
    }

    private Settings settings;
    
    // ALL INFORMATION ABOUT USERS INTO THIS PANE.
    public Adding(Content content) {
        this.content = content;
        Button add = new Button("Add");
        Button delete = new Button("Delete");
        Button lookUp = new Button("Lookup");
        Label name = new Label("Name");
        TextField addNameField = new TextField("");   

        HBox hBox = new HBox(20);
        settings = new Settings();

        // SETTING FONTS FOR BUTTONS
        add.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),12));
        delete.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),12));
        lookUp.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),12));
        name.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),12));

        // IF WE WANT TO ADD A NEW PROFILE
        add.setOnAction(e -> {
            // GET THE TEXT FROM THE TEXT FIELD.
            String nameUser = addNameField.getText().trim();

            // CHECK THE USER HAVE ALREADY EXISTED OR NOT.
            String pattern = "^[a-zA-Z_-]*$";
            if ((nameUser.matches(pattern)) && !(nameUser.isEmpty())) {
                if (!(Users.checkUser(nameUser))) {
                    content.updatedMessage("New profile created");
                    // IF THE METHOD RETURNS TRUE, WE CAN ADD THE USER INTO THE OUR HASHMAP AND DOING NEW PROFILE.
                    ArrayList<String> friends = new ArrayList<String>();
                    Object[] data = {"NoImage.png","No current status",friends};
                    Users.addUser(nameUser, data);
                    // WE WANT TO COSTUMIZE THE PAGE USING NEW PROFILE. 
                    Profile profile = new Profile(nameUser);
                    // HERE, WE WANT TO UPDATE THE CONTENT.
                    content.updateContent(profile);
                } else {
                    content.updatedMessage(nameUser+ " is already exist");
                }
            
            } else {
                content.updatedMessage("Please write again, adding user should only contains [a to z, _ , -]");
            }

            // System.out.println("\n\n");
            // Users.userData.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        });
        delete.setOnAction(e -> {
            // DELETE THE USER FROM THE HASHMAP
            if (Users.userData.containsKey(addNameField.getText())) {
                for (Map.Entry<String, Object[]> users : Users.userData.entrySet()) {
                    String userName = users.getKey();
                    Object[] values = users.getValue();
                    String deletedUser = addNameField.getText();
                    Object[] data = Users.userData.get(userName);
                    ArrayList<String> friends = (ArrayList<String>) data[2];
                    
                    if (friends.contains(deletedUser)) {
                        friends.remove(addNameField.getText());
                    }
                }
                Users.userData.remove(addNameField.getText());
                content.updateContent(null);
                content.updatedMessage("Profile of "+ addNameField.getText() +" deleted");
            // WANT TO CLEAR THE PAGE.
            } else {
                content.updatedMessage("Profile of "+ addNameField.getText() +" does not exist.");
            }
            
        });
        lookUp.setOnAction(e -> {
            String nameUser = addNameField.getText();
            if ((Users.userData.containsKey(nameUser))) {
                content.updatedMessage("Displaying " + nameUser);
                Object[] userData = Users.getUser(nameUser);
            
                if (userData != null) {
                    String pathImage = (String) userData[0];
                    String status = (String) userData[1];

                    ArrayList<String> friends = (ArrayList<String>) userData[2];                   
                    
                    Profile profile = new Profile(nameUser, pathImage, status,friends);
                    content.updateContent(profile); // Assuming Content class has this method
                } else {
                    // Handle case where user is not found
                }
            } else {
                content.updatedMessage("A Profile with the name of " + nameUser + " does not exist");
            }
        });
        hBox.getChildren().addAll(name,addNameField,add,delete,lookUp);
        hBox.setAlignment(Pos.CENTER);

        getChildren().addAll(settings,hBox);
        setSpacing(250);
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(10,10,10,10));

        // Setting Background 
        BackgroundFill backgroundFill = new BackgroundFill(Color.gray(0.75), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
        Background background = new Background(backgroundFill);
        setBackground(background);
    }
}

class Settings extends VBox {
    public Settings() {
        
        ChoiceBox<String> options = new ChoiceBox<>();
        String[] modes = {"Night Mode", "White Mode", "Sky Mode"};
        options.getItems().addAll(modes);
        Button settingsButton = new Button();
        options.setOnAction(e -> {
            String mode = options.getValue();
            if ("Night Mode".equals(mode)) {
                setBackground(Color.DARKGRAY);
            } else if ("White Mode".equals(mode)) {
                setBackground(Color.WHITE);
            } else if ("Sky Mode".equals(mode)) {
                setBackground(Color.SKYBLUE);
            }
        });
    
        settingsButton.setGraphic(options);
        settingsButton.setMinWidth(100);
        getChildren().addAll(settingsButton);

    }
    public void setBackground(Color color) {
        BackgroundFill backgroundFill = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        BuildScreen.pane.setBackground(background);
        System.out.println("Setting background color to " + color);
    }
}





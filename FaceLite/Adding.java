import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class Adding extends HBox {
    private Content content;
    private Updated updated;
    // ALL INFORMATION ABOUT USERS INTO THIS PANE.
    public Adding(Content content,Updated updated) {
        this.content = content;
        this.updated = updated;
        Button add = new Button("Add");
        Button delete = new Button("Delete");
        Button lookUp = new Button("Lookup");
        Label name = new Label("Name");
        TextField addNameField = new TextField("");   
        
        // SETTING FONTS FOR BUTTONS
        add.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),12));
        delete.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),12));
        lookUp.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),12));
        name.setFont(Font.loadFont(getClass().getResourceAsStream("assests/fonts/Quicksand/static/Quicksand-Bold.ttf"),12));

        // IF WE WANT TO PUT NEW PROFILE
        add.setOnAction(e -> {
            // GET THE TEXT FROM THE TEXT FIELD.
            String nameUser = addNameField.getText();

            // CHECK THE USER HAVE ALREADY EXISTED OR NOT.
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

            
            }

            // System.out.println("\n\n");
            // Users.userData.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        });
        delete.setOnAction(e -> {
            // DELETE THE USER FROM THE HASHMAP
            Users.userData.remove(addNameField.getText());
            content.updateContent(null);
            content.updatedMessage("Profile delete");
            // WANT TO CLEAR THE PAGE.
            
        });
        lookUp.setOnAction(e -> {
            String nameUser = addNameField.getText();
            if ((Users.userData.containsKey(nameUser))) {
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
            }
        });
        setSpacing(20);
        setAlignment(Pos.CENTER);
        getChildren().addAll(name,addNameField,add,delete,lookUp);
        setPadding(new Insets(10,10,10,10));

        // Setting Background 
        BackgroundFill backgroundFill = new BackgroundFill(Color.gray(0.75), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
        Background background = new Background(backgroundFill);
        setBackground(background);
    }
}
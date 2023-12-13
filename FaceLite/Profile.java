import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import java.util.ArrayList;
public class Profile extends VBox {
    private String name;
    private String status;
    private String profileImage;
    private ArrayList<String> friends;
    
    // RETURN USER'S PROFILE IF NECESSARY.
    public String getName() {
        return name;
    }
    public String getStatus() {
        return status;
    }
    public String getProfileImage() {
        return profileImage;
    }
    // ADDING A NEW PROFILE -- DEFAULT PROFILE -- 
    public Profile(String name) {
        // ALL DEFAULT VARIABLES.
        this.name = name;
        this.status = "No current Status";
        this.profileImage = "NoImage.png";
        this.friends = new ArrayList<>();
        Label nameL = new Label(name);
        Label statusL = new Label(status);
        Label friendListL = new Label("Friends");

        // SETTING FOR FONTS.
        nameL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf",30));
        nameL.setTextFill(Color.BLUE);
        statusL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf", 15));
        friendListL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf", 25));

        // DISPLAY AN IMAGE USING 'Image' CLASS AND 'ImageView' class.
        Image image = new Image(getClass().getResource("assests/images/"+profileImage).toString());
        ImageView imageView = new ImageView(image);

        // SETTING FOR THE MAXIMUM WIDTH AND HEIGHT OF THE IMAGE.
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        VBox vBoxForListOfFriends = new VBox(10);
        vBoxForListOfFriends.getChildren().add(friendListL);
        ArrayList<String> listOfFriends = (ArrayList<String>) Users.userData.get(name)[2];
        for (int i = 0; i < listOfFriends.size(); i++) {
            Label label = new Label(listOfFriends.get(i));
            vBoxForListOfFriends.getChildren().add(label);
        }
        // SETTING AS A HORIZONTAL BETWEEN AN IMAGE AND LIST OF FRIENDS. SO, YOU CAN YOUR FULL NAME INTO THE SCREEN.
        HBox forImageAndFriends = new HBox(150);
        forImageAndFriends.getChildren().addAll(imageView,vBoxForListOfFriends);
        forImageAndFriends.setAlignment(Pos.TOP_LEFT);
        // ==================================================
        getChildren().addAll(nameL,forImageAndFriends,statusL);
        setAlignment(Pos.TOP_LEFT);
        setSpacing(20);
        setPadding(new Insets(20, 20, 50, 20));
    }
    // ADDING OR CHANGING USER'S PROFILE
    public Profile(String name, String profileImage, String status, ArrayList<String> friends) {
        this.name = name;
        this.status = status;
        this.profileImage = profileImage;
        this.friends = friends;
        Label nameL = new Label(name);
        Label statusL = new Label(status);
        Label friendListL = new Label("Friends");

        // SETTING FOR FONTS.
        nameL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf",30));
        nameL.setTextFill(Color.BLUE);
        statusL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf", 15));
        friendListL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf", 25));
        
        // DISPLAY AN IMAGE USING 'Image' CLASS AND 'ImageView' class.
        Image image = new Image(getClass().getResource("assests/images/"+profileImage).toString());
        ImageView imageView = new ImageView(image);
        // SETTING FOR THE MAXIMUM WIDTH AND HEIGHT OF THE IMAGE.
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        VBox vBoxForListOfFriends = new VBox(10);
        vBoxForListOfFriends.getChildren().add(friendListL);
        ArrayList<String> listOfFriends = (ArrayList<String>) Users.userData.get(name)[2];
        for (int i = 0; i < listOfFriends.size(); i++) {
            Label label = new Label(listOfFriends.get(i));
            vBoxForListOfFriends.getChildren().add(label);
        }
        
        HBox forImageAndFriends = new HBox(150);
        forImageAndFriends.getChildren().addAll(imageView,vBoxForListOfFriends);
        forImageAndFriends.setAlignment(Pos.TOP_LEFT);
        // ==================================================
        getChildren().addAll(nameL,forImageAndFriends,statusL);
        setAlignment(Pos.TOP_LEFT);
        setSpacing(20);
        setPadding(new Insets(20, 20, 50, 20));
    }
}

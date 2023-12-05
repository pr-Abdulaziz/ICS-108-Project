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
public class Profile extends HBox {
    private String name;
    private String status;
    private String profileImage;
    private ArrayList<String> friends;
    
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
        VBox vBox = new VBox(10);
        this.name = name;
        this.status = "No current Status";
        this.profileImage = "NoImage.png";
        this.friends = new ArrayList<>();
        Label nameL = new Label(name);
        Label statusL = new Label(status);
        Label friendListL = new Label("Friends");

        nameL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf",30));
        nameL.setTextFill(Color.BLUE);
        statusL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf", 25));
        friendListL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf", 25));

        Image image = new Image(getClass().getResource("assests/images/"+profileImage).toString());
        ImageView imageView = new ImageView(image);

        VBox vBoxForListOfFriends = new VBox(10);
        vBoxForListOfFriends.getChildren().add(friendListL);
        ArrayList<String> listOfFriends = (ArrayList<String>) Users.userData.get(name)[2];
        for (int i = 0; i < listOfFriends.size(); i++) {
            Label label = new Label(listOfFriends.get(i));
            vBoxForListOfFriends.getChildren().add(label);
        }
        
        
        // ==================================================
        vBox.getChildren().addAll(nameL,imageView,statusL);
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.setSpacing(20);
        vBoxForListOfFriends.setPadding(new Insets(50, 0, 0, 0));
        getChildren().addAll(vBox,vBoxForListOfFriends);
        setAlignment(Pos.TOP_LEFT);
        setSpacing(100);
        setPadding(new Insets(20, 20, 50, 20));
    }
    // ADDING OR CHANGING USER'S PROFILE
    public Profile(String name, String profileImage, String status, ArrayList<String> friends) {
        VBox vBox = new VBox(10);
        this.name = name;
        this.status = status;
        this.profileImage = profileImage;
        this.friends = friends;
        Label nameL = new Label(name);
        Label statusL = new Label(status);
        Label friendListL = new Label("Friends");

        nameL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf",30));
        nameL.setTextFill(Color.BLUE);
        statusL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf", 25));
        friendListL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf", 25));


        Image image = new Image(getClass().getResource("assests/images/"+profileImage).toString());
        ImageView imageView = new ImageView(image);

        // To set list of friends:
        VBox vBoxForListOfFriends = new VBox(10);
        vBoxForListOfFriends.getChildren().add(friendListL);
        ArrayList<String> listOfFriends = (ArrayList<String>) Users.userData.get(name)[2];
        for (int i = 0; i < listOfFriends.size(); i++) {
            Label label = new Label(listOfFriends.get(i));
            vBoxForListOfFriends.getChildren().add(label);
        }
        
        // 1- Checking for the maximum size for the image

        // 2- Checking for the ---------

        // 3- Checking for the ---------
        // ==================================================
        vBox.getChildren().addAll(nameL,imageView,statusL);
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.setSpacing(20);
        vBoxForListOfFriends.setPadding(new Insets(50, 0, 0, 0));
        getChildren().addAll(vBox,vBoxForListOfFriends);
        setAlignment(Pos.TOP_LEFT);
        setSpacing(100);
        setPadding(new Insets(20, 20, 50, 20));

    }
}

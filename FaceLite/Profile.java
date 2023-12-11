import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.io.FileInputStream;


import java.util.ArrayList;
public class Profile extends VBox {
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
        HBox hBox = new HBox();
        this.name = name;
        this.status = "No current Status";
        this.profileImage = "NoImage.png";
        this.friends = new ArrayList<>();
        Label nameL = new Label(name);
        Label statusL = new Label(status);
        Label friendListL = new Label("Friends");

        
        nameL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf",30));
        nameL.setTextFill(Color.BLUE);
        statusL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf", 15));
        friendListL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf", 25));
        
        Image image = new Image(getClass().getResource("assests/images/"+profileImage).toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        VBox vBoxForListOfFriends = new VBox(10);
        vBoxForListOfFriends.getChildren().add(friendListL);
        ArrayList<String> listOfFriends = (ArrayList<String>) Users.userData.get(name)[2];
        for (int i = 0; i < listOfFriends.size(); i++) {
            Label label = new Label(listOfFriends.get(i));
            vBoxForListOfFriends.getChildren().add(label);
        }
        
        VBox forImageAndName = new VBox(10);
        forImageAndName.getChildren().addAll(nameL,imageView);

        // ==================================================
        hBox.getChildren().addAll(forImageAndName,vBoxForListOfFriends);
        hBox.setAlignment(Pos.TOP_LEFT);
        hBox.setSpacing(150);
        vBoxForListOfFriends.setPadding(new Insets(50, 0, 0, 0));
        getChildren().addAll(hBox,statusL);
        setAlignment(Pos.TOP_LEFT);
        setSpacing(20);
        setPadding(new Insets(20, 20, 50, 20));
    }
    // ADDING OR CHANGING USER'S PROFILE
    public Profile(String name, String profileImage, String status, ArrayList<String> friends) {
        HBox hBox = new HBox();
        this.name = name;
        this.status = status;
        this.profileImage = profileImage;
        this.friends = friends;
        Label nameL = new Label(name);
        Label statusL = new Label(status);
        Label friendListL = new Label("Friends");

        
        nameL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf",30));
        nameL.setTextFill(Color.BLUE);
        statusL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf", 15));
        friendListL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf", 25));
        ImageView imageView1 = new ImageView();

        
        Image image = new Image(getClass().getResource("assests/images/"+profileImage).toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        VBox vBoxForListOfFriends = new VBox(10);
        vBoxForListOfFriends.getChildren().add(friendListL);
        ArrayList<String> listOfFriends = (ArrayList<String>) Users.userData.get(name)[2];
        for (int i = 0; i < listOfFriends.size(); i++) {
            Label label = new Label(listOfFriends.get(i));
            vBoxForListOfFriends.getChildren().add(label);
        }
        
        VBox forImageAndName = new VBox(10);
        forImageAndName.getChildren().addAll(nameL,imageView);

        // ==================================================
        hBox.getChildren().addAll(forImageAndName,vBoxForListOfFriends);
        hBox.setAlignment(Pos.TOP_LEFT);
        hBox.setSpacing(150);
        vBoxForListOfFriends.setPadding(new Insets(50, 0, 0, 0));
        getChildren().addAll(hBox,statusL);
        setAlignment(Pos.TOP_LEFT);
        setSpacing(20);
        setPadding(new Insets(20, 20, 50, 20));

    }

}

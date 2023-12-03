import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class Profile extends VBox {
    private String name;
    private String status;
    private String profileImage;
    
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
        this.name = name;
        this.status = "No current Status";
        this.profileImage = "NoImage.png";
        Label nameL = new Label(name);
        Label statusL = new Label(status);
        nameL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf",30));
        nameL.setTextFill(Color.BLUE);
        statusL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf", 25));

        Image image = new Image(getClass().getResource("assests/images/"+profileImage).toString());
        ImageView imageView = new ImageView(image);

        getChildren().addAll(nameL,imageView,statusL);
        setAlignment(Pos.TOP_LEFT);
        setSpacing(20);
        setPadding(new Insets(50, 20, 50, 20));
    }
    // ADDING OR CHANGING USER'S PROFILE
    public Profile(String name, String profileImage, String status) {
        this.name = name;
        this.status = status;
        this.profileImage = profileImage;
        Label nameL = new Label(name);
        Label statusL = new Label(status);
        nameL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf",30));
        nameL.setTextFill(Color.BLUE);
        statusL.setFont(Font.font("assests/fonts/Quicksand/static/Quicksand-Bold.ttf", 25));
        
        Image image = new Image(getClass().getResource("assests/images/"+profileImage).toString());
        ImageView imageView = new ImageView(image);

        getChildren().addAll(nameL,imageView,statusL);
        setAlignment(Pos.TOP_LEFT);
        setSpacing(20);
        setPadding(new Insets(50, 20, 50, 20));
    }
}

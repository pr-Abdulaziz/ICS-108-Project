import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;

public class Content extends HBox {  
    private Profile profile;

    
    public Profile getProfile() {
        return profile;
    }

    public Content() {
        BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        setBackground(background);
        setPadding(new Insets(10, 10, 10, 10));
    }

    public void updateContent(Profile profile) {
        this.profile = profile;
        
        // Clear existing profile before adding the new profile
        getChildren().clear();

        // Add the new profile if it is not null
        if (profile != null) {
            getChildren().add(profile);
        }

        // Update layout as necessary
    }
}

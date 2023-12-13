import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Content extends Pane {  
    private Profile profile;
    private Updated updated;
    private VBox vBox;

    // GETTING ALL INFORMATION ABOUT THE CURRENT PROFILE.
    public Profile getProfile() {
        return profile;
    }

    public Content(Updated updated){
        // UPDATING CURRENT MESSAGE.
        this.updated = updated;
        vBox = new VBox();
        setPadding(new Insets(10, 10, 10, 10));
        vBox.setScaleY(500);
        getChildren().add(vBox);
        setMinHeight(500);
    }

    public void updateContent(Profile profile) {
        // UPDATING CURRENT PROFILE.
        this.profile = profile;
        
        // Clear existing profile before adding the new profile
        getChildren().clear();

        // Add the new profile if it is not null
        if (profile != null) {
            getChildren().add(profile);
        } else {
            getChildren().clear();
            //getChildren().add();
        } 

        // Update layout as necessary
    }
    public void updatedMessage(String messageText) {
        // CHECKING FIRST FROM THE UPDATE CLASS.
        if (updated == null) {
            updated = new Updated();
            updated.setMessage(messageText);
            vBox.getChildren().add(updated);
        } else {
            updated.setMessage(null);
            updated.setMessage(messageText);
        } 
    }
    
}

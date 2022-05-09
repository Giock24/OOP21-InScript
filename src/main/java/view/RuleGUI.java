package view;

import static view.ViewState.HEIGHT;
import static view.ViewState.WIDTH;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class RuleGUI implements Showable {

    private Scene scene;
    
    public RuleGUI() {
        this.loadFXML();
    }
    
    /**
     * This method loads the file FXML with all graphics
     */
    private void loadFXML() {
        try {
            final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("rule.fxml"));
            this.scene = new Scene(root, WIDTH.getValue(), HEIGHT.getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Scene getScene() {
        return this.scene;
    }


}

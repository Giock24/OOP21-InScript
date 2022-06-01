package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import static view.ViewState.WIDTH;
import static view.ViewState.HEIGHT;

public class SelectionGUI implements Showable {
    
    private Scene scene;
    
    public SelectionGUI() {
        this.loadFXML();
        Music.SELECTION_THEME.loopMusic();
    }

    /**
     * This method loads the file FXML with all graphics
     */
    private void loadFXML() {
        try {
            final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/SelectionScene.fxml"));
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

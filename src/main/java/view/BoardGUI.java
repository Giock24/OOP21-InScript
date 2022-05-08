package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import static view.ViewState.WIDTH;
import static view.ViewState.HEIGHT;

public class BoardGUI implements Showable{
    
    private Scene scene;
    
    public BoardGUI() {
        this.loadFXML();
    }
    
    /**
     * This method loads the file FXML with all graphics
     */
    private void loadFXML() {
        try {
            final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("GameScene.fxml"));
            this.scene = new Scene(root, WIDTH.getValue(), HEIGHT.getValue());
            Music.BOARD_THEME.startMusic();
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

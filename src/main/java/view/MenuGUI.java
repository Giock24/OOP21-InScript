package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static view.ViewState.WIDTH;

import java.io.IOException;

import static view.ViewState.HEIGHT;

public class MenuGUI implements Showable {
    
    private final Stage stage;
    private Scene scene;
    
    public MenuGUI(final Stage stage) {
        this.stage = stage;  
        this.loadFXML();
        this.startMusic();    
    }
    
    /**
     * This method loads the file FXML with all graphics
     */
    private void loadFXML() {
        
        this.stage.setMinWidth(WIDTH.getMinValue());
        this.stage.setMinHeight(HEIGHT.getMinValue());
        
        try {
            final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/MenuScene.fxml"));
            this.scene = new Scene(root, WIDTH.getValue(), HEIGHT.getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     *  every time is called start the music of the Menu
     */
    private void startMusic() {
        Music.init();
        Music.MENU_THEME.loopMusic();
    }
    
    /**
     * {@inheritDoc}
     */
    public Scene getScene() {
        return this.scene;
    }

}

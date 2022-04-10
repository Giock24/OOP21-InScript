package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static view.ScreenDimension.WIDTH;
import static view.ScreenDimension.HEIGHT;

public class BoardGUI implements Showable{
    
    private final Stage stage;
    private Scene scene;
    
    public BoardGUI(final Stage stage) {
        this.stage = stage;
        this.loadFXML();
    }
    
    /**
     * This method loads the file FXML with all graphics
     */
    private void loadFXML() {
        try {
            final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("GameScene.fxml"));
            this.scene = new Scene(root);
            
            //this.stage.setScene(this.scene);
            //this.stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public Scene getScene() {
        return this.scene;
    }

}

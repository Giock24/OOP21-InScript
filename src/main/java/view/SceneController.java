package view;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    
    final private Stage primaryStage;
    //private Scene scene; quando useremo altri file FXML
    //private Parent root; questi due campi serviranno
    
    final private Scene menuScene;
    
    public SceneController(final Stage primaryStage, final Scene menuScene) {
        this.primaryStage = primaryStage;
        this.menuScene = menuScene;
    }
    
    /**
     * @param event active when is clicked a button
     *          when this method is called you can return to menu
     */
    public void switchToMenuScene(final ActionEvent event) {
        this.primaryStage.setScene(this.menuScene);
        this.primaryStage.show();
    }

}

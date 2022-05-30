package view;

import static view.ViewState.HEIGHT;
import static view.ViewState.WIDTH;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public abstract class AbstractController {
    
    @FXML private BorderPane root;
    
    /**
     *     initializes all classes that this controller needs to use
     */
    public abstract void initialize();
    
    /**
     *     decide which scene to go to
     *     
     * @param scene is new scene to switch
     */
    public void switchToAnotherScene(final Showable scene) {
        final Stage primaryStage = (Stage)root.getScene().getWindow();
        WIDTH.setCurrentValue(primaryStage.getScene().getWidth());
        HEIGHT.setCurrentValue(primaryStage.getScene().getHeight());
        
        primaryStage.setScene(scene.getScene());
        primaryStage.show();
    }
    
    /**
     *     when this method is called you can return to menu
     *     
     * @param event active when is clicked a button
     * 
     */
    public void switchToMenuScene(final MouseEvent event) {
        final Stage primaryStage = (Stage)root.getScene().getWindow();
        this.switchToAnotherScene(new MenuGUI(primaryStage));
    }
    
}

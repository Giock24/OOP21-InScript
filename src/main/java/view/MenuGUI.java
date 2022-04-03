package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import static view.ScreenDimension.WIDTH;
import static view.ScreenDimension.HEIGHT;

public class MenuGUI implements Showable {
    
    private final Stage stage;
    private Scene scene;
    
    public MenuGUI(final Stage stage) {
        this.stage = stage;
        this.createGUI();
    }
    
    /**
     * This method start to create the MenuGUI
     */
    private void createGUI() {
        final BorderPane layout = new BorderPane();
        this.scene = new Scene(layout, WIDTH.getValue(), HEIGHT.getValue());
        
        final Button centerButton = new Button("CENTER BUTTON");
        centerButton.setMinWidth(150);
        
        layout.setTop(null);
        layout.setCenter(centerButton);
        layout.setLeft(null);
        layout.setRight(null);
    }
    
    /**
     * {@inheritDoc}
     */
    public Scene getScene() {
        return this.scene;
    }

}

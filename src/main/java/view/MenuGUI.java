package view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static view.ScreenDimension.WIDTH;
import static view.ScreenDimension.HEIGHT;

public class MenuGUI implements Showable {
    
    private static final String STYLE_MENU_BUTTON = "buttonMenu";
    
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
        
        layout.setTop(null);
        layout.setCenter(this.centerNode());
        layout.setLeft(null);
        layout.setRight(null);
        
        this.scene.getStylesheets().add("application.css");
    }
    
    private Node centerNode() {
        final VBox centralPanel = new VBox();
        centralPanel.setAlignment(Pos.CENTER);
        centralPanel.setSpacing(40);
        
        final Button startB = new Button("START GAME");
        final Button quitB = new Button("QUIT");
        
        startB.getStyleClass().add(MenuGUI.STYLE_MENU_BUTTON);
        quitB.getStyleClass().add(MenuGUI.STYLE_MENU_BUTTON);
        
        centralPanel.getChildren().addAll(startB, quitB);
        
        return centralPanel;
    }
    
    /**
     * {@inheritDoc}
     */
    public Scene getScene() {
        return this.scene;
    }

}

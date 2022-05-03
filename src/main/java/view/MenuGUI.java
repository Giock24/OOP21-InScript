package view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static view.ViewState.WIDTH;
import static view.ViewState.HEIGHT;

public class MenuGUI implements Showable {
    
    private static final String STYLE_MENU_BUTTON = "buttonMenu";
    private static final int SPACING = 40;
    
    private final Stage stage;
    private Scene scene;
    
    public MenuGUI(final Stage stage) {
        this.stage = stage;
        this.createGUI();
        this.startMusic();
        
    }
    
    /**
     * This method begins to create the MenuGUI
     */
    private void createGUI() {
        final BorderPane layout = new BorderPane();
        this.scene = new Scene(layout, WIDTH.getValue(), HEIGHT.getValue());
        
        this.stage.setMinWidth(WIDTH.getMinValue());
        this.stage.setMinHeight(HEIGHT.getMinValue());
        
        layout.setCenter(this.centerNode());
        layout.setBottom(this.bottomNode());
        
        this.scene.getStylesheets().add("application.css");
    }
    
    /**
     * @return
     *          the central Node of the Menu
     */
    private Node centerNode() {
        final VBox centralPanel = new VBox();
        centralPanel.setAlignment(Pos.CENTER);
        centralPanel.setSpacing(MenuGUI.SPACING);
        
        final Button startB = new Button("START GAME");
        final Button optionB = new Button("OPTIONS");
        final Button quitB = new Button("QUIT");
        
        startB.getStyleClass().add(MenuGUI.STYLE_MENU_BUTTON);
        optionB.getStyleClass().add(MenuGUI.STYLE_MENU_BUTTON);
        quitB.getStyleClass().add(MenuGUI.STYLE_MENU_BUTTON);
        
        startB.setOnAction(e -> {
            Music.MENU_THEME.stopMusic();
            
            WIDTH.setCurrentValue(this.scene.getWidth());
            HEIGHT.setCurrentValue(this.scene.getHeight());
            
            final Showable select = new SelectionGUI();
            this.stage.setScene(select.getScene());
            this.stage.show();
        });
        
        quitB.setOnAction(e -> {
            Platform.exit();
        });
        
        centralPanel.getChildren().addAll(startB, optionB, quitB);
        
        return centralPanel;
    }
    
    /**
     * @return
     *          the bottom Node of the Menu
     */
    private Node bottomNode() {
        final VBox rightPanel = new VBox();
        rightPanel.setAlignment(Pos.BOTTOM_RIGHT);
        rightPanel.setPadding(new Insets(10, 10, 10, 10));
        
        final Button volumeB = new Button("VOLUME ON");
        
        volumeB.setOnAction(e -> {
            Music.MENU_THEME.pauseAndResumeMusic();
            if (Music.MENU_THEME.musicIsActive()) {
                volumeB.setText("VOLUME ON");
            } else {
                volumeB.setText("VOLUME OFF");
            }
        });
        
        volumeB.getStyleClass().add(MenuGUI.STYLE_MENU_BUTTON);
        rightPanel.getChildren().add(volumeB);
        
        return rightPanel;
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

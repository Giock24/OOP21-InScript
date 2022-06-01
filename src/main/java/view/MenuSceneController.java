package view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuSceneController extends AbstractController{
    
    Stage primaryStage;
    Showable gui;
    
    @FXML
    private BorderPane root;
    
    @FXML
    private Button volumeB;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize() { 
        volumeB.setOnAction(e -> {
            Music.MENU_THEME.pauseAndResumeMusic();
            if (Music.MENU_THEME.musicIsActive()) {
                volumeB.setText("VOLUME ON");
            } else {
                volumeB.setText("VOLUME OFF");
            }
        });
    }
    
    /**
     * {@inheritDoc}
     */
    @FXML
    public void onStartGamePressed(final MouseEvent event) {
        Music.MENU_THEME.stopMusic();
        Music.SELECTION_THEME.startMusic();
        
        this.primaryStage = (Stage)root.getScene().getWindow();
        super.setDimension(this.primaryStage.getScene().getWidth(), this.primaryStage.getScene().getHeight());
        super.switchToAnotherScene(new SelectionGUI(), primaryStage);
    }
    
    
    /**
     * 
     *     when is called you can check the rules
     * 
     * @param event active when is clicked a button
     */
    @FXML
    public void onRulesPressed(final MouseEvent event) {
        this.primaryStage = (Stage)root.getScene().getWindow();
        super.setDimension(this.primaryStage.getScene().getWidth(), this.primaryStage.getScene().getHeight());
        super.switchToAnotherScene(new RuleGUI(), primaryStage);
    }
    
    /**
     * 
     *     when is called the application shutdown
     * 
     * @param event active when is clicked a button
     */
    @FXML
    public void onQuitPressed(final MouseEvent event) {
        Platform.exit();
    }

}

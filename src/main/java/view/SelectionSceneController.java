package view;

import static view.ViewState.HEIGHT;
import static view.ViewState.WIDTH;

import java.util.Set;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import shared.AppState;
import shared.AppStateSingleton;

public class SelectionSceneController {
    
    final AppState appState =  AppStateSingleton.getInstance();
    
    @FXML
    private BorderPane root;
    
    @FXML
    private ChoiceBox<String> selectedPlayerDeck;
    
    @FXML
    private ChoiceBox<String> selectedAIDeck;
    
    
    public void initialize(){
        
        final Set<String> setDeckNames = appState.getDecksList().keySet().stream().sorted().collect(Collectors.toSet());
        
        selectedPlayerDeck.getItems().addAll(setDeckNames);
        selectedAIDeck.getItems().addAll(setDeckNames);
        
        selectedPlayerDeck.setValue("deck-standard");
        selectedAIDeck.setValue("deck-standard-IA");
    }
    
    /**
     * 
     *     when this method is called you can return to menu
     * 
     * @param event active when is clicked a button
     */
    @FXML
    public void switchToMenuScene(final MouseEvent event) {
        Music.SELECTION_THEME.stopMusic();
        final Stage primaryStage = (Stage)root.getScene().getWindow();
        final Showable menuGUI = new MenuGUI(primaryStage);
        
        WIDTH.setCurrentValue(primaryStage.getScene().getWidth());
        HEIGHT.setCurrentValue(primaryStage.getScene().getHeight());
        
        primaryStage.setScene(menuGUI.getScene());
        primaryStage.show();
    }
    
    /**
     * 
     *     when this method is called start the match
     * 
     * @param event
     */
    @FXML
    public void onPlayPressed (final MouseEvent event) {
        Music.SELECTION_THEME.stopMusic();
        appState.selectHumanPlayerDeck(selectedPlayerDeck.getValue());
        appState.selectAIPlayer(selectedAIDeck.getValue());
        
        final Stage primaryStage = (Stage)root.getScene().getWindow();
        WIDTH.setCurrentValue(primaryStage.getScene().getWidth());
        HEIGHT.setCurrentValue(primaryStage.getScene().getHeight());
        
        final BoardGUI board = new BoardGUI();
        primaryStage.setScene(board.getScene());
        primaryStage.show();
    }
    

}

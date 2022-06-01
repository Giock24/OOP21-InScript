package view;

import java.util.Set;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import shared.AppState;
import shared.AppStateController;

public class SelectionSceneController extends AbstractController{
    
    Stage primaryStage;
    Showable gui;
    final AppState appState = new AppStateController();
    
    @FXML
    private BorderPane root;
    
    @FXML
    private ChoiceBox<String> selectedPlayerDeck;
    
    @FXML
    private ChoiceBox<String> selectedAIDeck;
    
    @Override
    public void initialize(){
        
        final Set<String> setDeckNames = appState.getDecksList().keySet().stream().sorted().collect(Collectors.toSet());
        
        selectedPlayerDeck.getItems().addAll(setDeckNames);
        selectedAIDeck.getItems().addAll(setDeckNames);
        
        selectedPlayerDeck.setValue("deck-standard");
        selectedAIDeck.setValue("deck-standard-IA");
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
        super.setDimension(primaryStage.getScene().getWidth(), primaryStage.getScene().getHeight());
        super.switchToAnotherScene(new BoardGUI(), primaryStage);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void switchToMenuScene(final MouseEvent event) {
        Music.SELECTION_THEME.stopMusic();
        super.switchToMenuScene(event);
    }

}

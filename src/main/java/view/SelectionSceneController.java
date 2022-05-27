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

public class SelectionSceneController extends AbstractController{
    
    Stage primaryStage;
    Showable gui;
    final AppState appState =  AppStateSingleton.getInstance();
    
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
        
        super.switchToAnotherScene(new BoardGUI());
    }

}

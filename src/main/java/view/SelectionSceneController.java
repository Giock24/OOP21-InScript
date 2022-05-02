package view;

import static view.ViewState.HEIGHT;
import static view.ViewState.WIDTH;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
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
        selectedPlayerDeck.getItems().addAll(appState.getDecksList().keySet());
        selectedAIDeck.getItems().addAll(appState.getDecksList().keySet());
    }
    
    
    @FXML
    private void OnPlayPressed () {
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

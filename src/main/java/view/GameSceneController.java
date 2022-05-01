package view;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import cards.Card;
import gamemaster.GameMasterControllerImpl;
import gamemaster.OnGameEnd;
import gamemaster.SlowUpdate;
import gamemaster.UpdateView;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static view.ViewState.WIDTH;
import static view.ViewState.HEIGHT;

public class GameSceneController {
    
    GameMasterControllerImpl gameMasterController;
    CardGrafic cardGrafic;
    private int colomn; // TODO campo che può essere omesso se il metodo updateBoardIA usasse un IntStream
    
    @FXML private BorderPane root;

    ////player info/////
    @FXML private Label lifePointsPlayer;
    @FXML private Label currentManaPlayer;
    @FXML private Label manaPlayer;
    
    ////player IA info////
    @FXML private Label lifePointsIA;
    @FXML private Label currentManaIA;
    @FXML private Label manaIA;
    
    ////cards//////
    @FXML private GridPane boardIA;
    @FXML private GridPane boardPlayer;
    @FXML private HBox handPlayer; //TODO this must be inside a ScrollPane in the view
    
    ////cardView////
    @FXML private VBox cardView;
    
    ////battle phase button////
    @FXML private Button battlePhaseButton;
    
   
    public void initialize(){
        this.gameMasterController= new GameMasterControllerImpl(updateBoardView,slowUpdate,onGameEnd);
        this.cardGrafic = new CardGraficImpl();
        inizializeEndTurnButton();
        updateBoardView.update();
    }
    
    private UpdateView updateBoardView = () -> {

        ////player info/////
        lifePointsPlayer.setText(Integer.toString(gameMasterController.getHumanPlayer().getLifePoints()));
        currentManaPlayer.setText(Integer.toString(gameMasterController.getHumanPlayer().getCurrentMana()));
        manaPlayer.setText(Integer.toString(gameMasterController.getHumanPlayer().getMana()));
        
        ////player IA info////
        lifePointsIA.setText(Integer.toString(gameMasterController.getIAPlayer().getLifePoints()));
        currentManaIA.setText(Integer.toString(gameMasterController.getIAPlayer().getCurrentMana()));
        manaIA.setText(Integer.toString(gameMasterController.getIAPlayer().getMana()));
        
        ////cards////
        updateBoardIA();
        updateBoardPlayer();
        updatePlayerHand();
        
        ////cardView////
        updateCardViewElement();
    
};

    private SlowUpdate slowUpdate = () -> {
        /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */   

    };
 
    private OnGameEnd onGameEnd = () -> {
        showGameOverDialog();
    };
    
    /**
     * function update the end-turn button
     * 
     * @param event
     */
    private void inizializeEndTurnButton() {
        battlePhaseButton.setMinSize(ViewState.CARD_WIDTH.getValue(), ViewState.CARD_WIDTH.getValue());
        battlePhaseButton.setOnMousePressed(event -> gameMasterController.onEndTurn());
    }

    /**
     * this function attach the cards element to the HBox named boardIA
     */
    private void updateBoardIA() {    
        boardIA.getChildren().clear();
        this.colomn = 0;
        
        gameMasterController.getIAPlayer().getCurrentBoard().forEach(card -> {
            VBox cardCell= null;
            
            
            if( card.isPresent()) {
                
                cardCell = this.cardGrafic.generateCardElement(card.get(),gameMasterController.getCardToPlace());
                cardCell.setOnMouseEntered(event -> gameMasterController.onSelectCardToShow(card.get()));
                
            } else {
                
                cardCell = this.cardGrafic.generateEmptyCardCell(true);
                
            }
            
            cardCell.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            boardIA.addColumn(this.colomn, cardCell);
            this.colomn++;
        });
        
        
    }
    
    /**
     * this function attach the cards element to the HBox named boardIA
     */
    private void updateBoardPlayer() {    
        boardPlayer.getChildren().clear();
        
        final List<Optional<Card>> userBoard = gameMasterController.getHumanPlayer().getCurrentBoard();    
 
        IntStream.range(0, userBoard.size()).forEach(index -> {
            VBox cardCell = null;
            
            
            final Optional<Card> card= userBoard.get(index);
            if( card.isPresent()) {
                cardCell = this.cardGrafic.generateCardElement(card.get(),gameMasterController.getCardToPlace());
                cardCell.setOnMouseEntered(event -> gameMasterController.onSelectCardToShow(card.get()));
            } else {
                cardCell =this.cardGrafic.generateEmptyCardCell(false); 
                cardCell.setOnMousePressed(event -> gameMasterController.onCardPlacing(index));
            }
            
            if(cardCell != null) {
                cardCell.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                boardPlayer.addColumn(index, cardCell);
            }
            
        });
        
        
    }
    
    /**
     * this function attach the cards element to the HBOX named handPlayer
     */
    private void updatePlayerHand() {
        handPlayer.getChildren().clear();
        
        gameMasterController.getHumanPlayer().getHand().forEach((card) -> {
          
                final VBox cardCell= this.cardGrafic.generateCardElement(card,gameMasterController.getCardToPlace());
                cardCell.setOnMouseEntered(event -> gameMasterController.onSelectCardToShow(card));
                cardCell.setOnMousePressed(event -> gameMasterController.onSelectCardToPlace(card));
                
                handPlayer.getChildren().add(cardCell);
           
        });
    }
       
    /**
     * this function generate the element for the VBox cardView 
     * 
     * @param card this is the selected card to show (it can be Optional.empty)
     * @return
     */
    private void updateCardViewElement() {
        
        final VBox cardViewElement = this.cardGrafic.generateCardViewElement(gameMasterController.getCardToShow());
        
        cardView.getChildren().clear();
        cardView.getChildren().add(cardViewElement);
        
    }
    
    private void returnToMenu() {
        final Stage primaryStage = (Stage)root.getScene().getWindow();
        final Showable menuGUI = new MenuGUI(primaryStage);
        
        WIDTH.setCurrentValue(primaryStage.getScene().getWidth());
        HEIGHT.setCurrentValue(primaryStage.getScene().getHeight());
        
        primaryStage.setScene(menuGUI.getScene());
        primaryStage.show();
    }
    
    /**
     * @param event active when is clicked a button
     *          when this method is called you can return to menu
     */
    @FXML
    public final void switchToMenuScene(final MouseEvent event) {
        returnToMenu();
    }
    

    /**
     * dialog to show when the game is over
     * 
     * @return game over dialog
     */
    private void showGameOverDialog() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Game Over");
        Optional<ButtonType> result =  alert.showAndWait();
        
        if(result.get() == ButtonType.OK || result.get() == ButtonType.CLOSE) {
            returnToMenu();
        }

    }
}

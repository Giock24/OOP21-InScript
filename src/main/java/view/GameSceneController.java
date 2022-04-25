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
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static view.ViewState.WIDTH;
import static view.ViewState.HEIGHT;

public class GameSceneController {
    
    GameMasterControllerImpl gameMasterController;
    private int colomn; // campo che può essere omesso se il metodo updateBoardIA usasse un IntStream

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
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }   

};
 
    private OnGameEnd onGameEnd = () -> {
        showGameOverDialog();
    };

    /**
     * this function generate the grafic for the empty cell
     * 
     * @param inTheAIBoard indicate if the empty card cell is in the player board or in the AI board
     * @return
     * @throws FileNotFoundException 
     */
    private VBox generateEmptyCardCell(boolean inTheAIBoard) {
        final VBox emptyCardCell = new VBox();
        
        String image = inTheAIBoard? "emptyCardCellAI.png" : "emptyCardCell.png";
        
        emptyCardCell.setStyle(""
                + "-fx-background-image:url('"+ image +"'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;");
        
        emptyCardCell.setMinSize(ViewState.CARD_WIDTH.getValue(), ViewState.CARD_HEIGHT.getValue());
        
        return emptyCardCell;
    }
    
    /**
     * this function generate the element for display the cards
     * 
     * @param card
     * @return
     */
    private VBox generateCardElement(Card card) {
        
        
        final VBox cardElement = new VBox();
        cardElement.setMinSize(ViewState.CARD_WIDTH.getValue(), ViewState.CARD_HEIGHT.getValue());
        
        final Optional<Card> cardToPlace = gameMasterController.getCardToPlace();
        final boolean isCardToPlace = cardToPlace.isPresent() && cardToPlace.get() == card;
        
        cardElement.setStyle(""
                + "-fx-background-image:url('sampleCardImage.png'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;"
                + (isCardToPlace == true ? ( 
                        "-fx-border-color: #a7ab7d;\n" 
                        + "-fx-border-width: 6;\n" 
                        ) : "")
               );
        
        final Label cardName = new Label();
        cardName.setText(card.getName());
        
        cardElement.getChildren().add(cardName);
        
        return cardElement;
    }
    
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
                
                cardCell = generateCardElement(card.get());
                cardCell.setOnMouseEntered(event -> gameMasterController.onSelectCardToShow(card.get()));
                
            } else {
                
                cardCell = generateEmptyCardCell(true);
                
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
        
        List<Optional<Card>> userBoard = gameMasterController.getHumanPlayer().getCurrentBoard();    
 
        IntStream.range(0, userBoard.size()).forEach(index -> {
            VBox cardCell = null;
            
            Optional<Card> card= userBoard.get(index);
            if( card.isPresent()) {
                
                cardCell = generateCardElement(card.get());
                cardCell.setOnMouseEntered(event -> gameMasterController.onSelectCardToShow(card.get()));
                
            } else {
                cardCell = generateEmptyCardCell(false);
                cardCell.setOnMouseClicked(event -> gameMasterController.onCardPlacing(index));
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
          
                final VBox cardCell= generateCardElement(card);
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
        
        final Optional<Card> selectedCardToShow = gameMasterController.getCardToShow();
        
        VBox cardViewElement = new VBox();
        
        if(selectedCardToShow.isPresent()) {
            
            final Card card = selectedCardToShow.get();
            
            cardViewElement.setStyle(""
                    + "-fx-background-image:url('sampleCardImage.png'); "
                    + "-fx-background-repeat: no-repeat;\n"
                    + "-fx-background-size: contain;\n"
                    + "-fx-background-size: 100% 100%;");
            
            cardViewElement.setMinSize(ViewState.CARD_WIDTH.getValue(), ViewState.CARD_HEIGHT.getValue());
            
            final Label cardName = new Label();
            cardName.setText(card.getName());
            
            cardViewElement.getChildren().add(cardName);
        } 
        
        cardView.getChildren().clear();
        cardView.getChildren().add(cardViewElement);
        
    }
    
    /**
     * @param event active when is clicked a button
     *          when this method is called you can return to menu
     */
    @FXML
    public final void switchToMenuScene(final MouseEvent event) {
        final Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        final Showable menuGUI = new MenuGUI(primaryStage);
        
        WIDTH.setCurrentValue(primaryStage.getScene().getWidth());
        HEIGHT.setCurrentValue(primaryStage.getScene().getHeight());
        
        primaryStage.setScene(menuGUI.getScene());
        primaryStage.show();
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
        alert.showAndWait();

    }
}

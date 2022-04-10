package view;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import cards.Card;
import gamemaster.GameMasterControllerImpl;
import gamemaster.SlowUpdate;
import gamemaster.UpdateView;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameSceneController {
    
    GameMasterControllerImpl gameMasterController;
    
    ////player info/////
    @FXML private Label lifePointsPlayer;
    @FXML private Label currentManaPlayer;
    @FXML private Label manaPlayer;
    
    ////player IA info////
    @FXML private Label lifePointsIA;
    @FXML private Label currentManaIA;
    @FXML private Label manaIA;
    
    
    ////cards//////
    @FXML private HBox boardIA;
    @FXML private HBox boardPlayer;
    @FXML private HBox handPlayer; //TODO this must be inside a ScrollPane in the view
    
    ////cardView////
    @FXML private VBox cardView;
    
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
    
    
    public void initialize(){
        gameMasterController= new GameMasterControllerImpl(updateBoardView,slowUpdate);
    }
    
    /**
     * this function generate the grafic for the empty cell
     * 
     * @param inTheAIBoard indicate if the empty card cell is in the player board or in the AI board
     * @return
     */
    private VBox generateEmptyCardCell(boolean inTheAIBoard) {
        final VBox emptyCardCell = new VBox();
        
        //TODO add the rest Of the grafic of the empty cell
        //TODO if the card is in the AI board the image must be upside down
        
        return emptyCardCell;
    }
    
    /**
     * this function generate the element for display the cards
     * 
     * @param card
     * @return
     */
    private VBox generateCardElement(Card card) {
        
        //TODO probably can be necessary change the style of the card if it is gameMasterController.getCardToPlace();
        //in the hand
   
        
        final VBox cardElement = new VBox();
        cardElement.setAlignment(Pos.CENTER);
        //centralPanel.setSpacing(40);
        
        final Label cardName = new Label();
        cardName.setText(card.getName());
        
        //TODO add all the card element
        
        return cardElement;
    }
    
    /**
     * function connect to the end-turn button
     * 
     * @param event
     */
    @FXML
    private void onEndTrunButtonPress(Event event) {
        gameMasterController.onEndTurn();
    }

    /**
     * this function attach the cards element to the HBox named boardIA
     */
    private void updateBoardIA() {    
        boardIA.getChildren().removeAll();
        
        gameMasterController.getIAPlayer().getCurrentBoard().forEach(card -> {
            final Button cardCell= new Button();
            if( card.isPresent()) {
                
                cardCell.setOnMouseEntered(event -> gameMasterController.onSelectCardToShow(card.get()));
                cardCell.setGraphic(generateCardElement(card.get()));
                
            } else {
                
                cardCell.setGraphic(generateEmptyCardCell(true));
                
            }
            boardIA.getChildren().add(cardCell);
        });
        
        
    }
    
    /**
     * this function attach the cards element to the HBox named boardIA
     */
    private void updateBoardPlayer() {    
        boardPlayer.getChildren().removeAll();
        
        List<Optional<Card>> userBoard = gameMasterController.getHumanPlayer().getCurrentBoard();    
 
        IntStream.range(0, userBoard.size()-1).forEach(index -> {
            final Button cardCell= new Button();
            Optional<Card> card= userBoard.get(index);
            if( card.isPresent()) {
                
                cardCell.setOnMouseEntered(event -> gameMasterController.onSelectCardToShow(card.get()));
                cardCell.setGraphic(generateCardElement(card.get()));
                
            } else {
                
                cardCell.setOnMouseClicked(event -> gameMasterController.onCardPlacing(index));
                cardCell.setGraphic(generateEmptyCardCell(false));
                
            }
            
            boardPlayer.getChildren().add(cardCell);
        });
        
    }
    
    /**
     * this function attach the cards element to the HBOX named handPlayer
     */
    private void updatePlayerHand() {
        handPlayer.getChildren().removeAll();
        
        gameMasterController.getHumanPlayer().getHand().forEach((card) -> {
          
                final Button cardCell= new Button();
                cardCell.setOnMouseEntered(event -> gameMasterController.onSelectCardToShow(card));
                cardCell.setOnMouseClicked(event -> gameMasterController.onSelectCardToPlace(card));
                cardCell.setGraphic(generateCardElement(card));
                
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
        
        final VBox cardViewElement = new VBox();
        
        if(selectedCardToShow.isPresent()) {
            //TODO add all the grafic for show the card detail
        } else {
            //TODO add all the grafic for show the card detail
        }
        
        cardView=cardViewElement;
        
    }
    


}

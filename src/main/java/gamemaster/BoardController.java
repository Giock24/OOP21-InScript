package gamemaster;

import java.util.ArrayList;
import java.util.Optional;

import cards.Card;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;

public class BoardController {
    
    GameMaster gameMaster;
    Optional<Card> selectedCardToPlace;
    Optional<Card> selectedCardToShow;
    
    
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
    
    
    public void initialize(){
        //TODO: add the deck here
        gameMaster= new GameMasterImpl(new ArrayList<Card>(), new ArrayList<Card>());
       
        updateView();
        
    }
    
    /**
     * this function generate the grafic for the empty cell
     * 
     * @return
     */
    private VBox generateEmptyCardCell() {
        final VBox emptyCardCell = new VBox();
        
        //TODO add the rest Of the grafic of the empty cell
        
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
        cardElement.setAlignment(Pos.CENTER);
        //centralPanel.setSpacing(40);
        
        final Label cardName = new Label();
        cardName.setText(card.getName());
        
        //TODO add all the card element
        
        return cardElement;
    }
    
    /**
     * function set on every card on the player hand for select the card to place
     * 
     * @param cardPosInThePlayerHand index of the player field hand
     */
    private void onCardSelectedFromHand(Card selectedCard) {
        selectedCardToPlace=Optional.of(selectedCard);
    }
    
    /**
     * function set on every card and set in the onMouseEnteredProperty of each card element
     * 
     * @param cardPosInThePlayerHand index of the player field hand
     */
    private void  onCardSelectedToShow(Card card) {
        selectedCardToShow=Optional.of(card);
    }
    
    
    /**
     * this function is set on every EmptyCardCell
     * 
     * @param indexOfTheCellInTheBoard index of the cell where the card will be place
     */
    private void onCardPositioning(int indexOfTheCellInTheBoard) {
        if(selectedCardToPlace.isPresent()) {
            //TODO call the method of the mainPhase manager for placing the cards
            selectedCardToPlace=Optional.empty();
            updateView();
        }
    }
    
    /**
     * this function attach the cards element to the HBox named boardIA
     */
    private void updateBoardIA() {    
        boardIA.getChildren().removeAll();
        
        gameMaster.getIAPlayer().getCurrentBoard().forEach(card -> {
            final Button cardCell= new Button();
            if( card.isPresent()) {
                
                cardCell.setOnMouseEntered(event -> onCardSelectedToShow(card.get()));
                cardCell.setGraphic(generateCardElement(card.get()));
                
            } else {
                
                //TODO finish to implement this event
                //cardCell.setOnMouseClicked(event -> onCardPositioning(card));
                cardCell.setGraphic(generateEmptyCardCell());
                
            }
            boardIA.getChildren().add(cardCell);
        });
    }
    
    /**
     * this function attach the cards element to the HBox named boardIA
     */
    private void updateBoardPlayer() {    
        boardPlayer.getChildren().removeAll();
        
        gameMaster.getHumanPlayer().getCurrentBoard().forEach(card -> {
            final Button cardCell= new Button();
            if( card.isPresent()) {
                
                cardCell.setOnMouseEntered(event -> onCardSelectedToShow(card.get()));
                cardCell.setGraphic(generateCardElement(card.get()));
                
            } else {
                
                //TODO finish to implement this event
                //cardCell.setOnMouseClicked(event -> onCardPositioning(card));
                cardCell.setGraphic(generateEmptyCardCell());
                
            }
            
            boardPlayer.getChildren().add(cardCell);
        });
    }
    
    /**
     * this function attach the cards element to the scrollPane named handPlayer
     */
    private void updatePlayerHand() {
        handPlayer.getChildren().removeAll();
        
        gameMaster.getHumanPlayer().getHand().forEach((card) -> {
          
                final Button cardCell= new Button();
                cardCell.setOnMouseEntered(event -> onCardSelectedToShow(card));
                cardCell.setOnMouseClicked(event -> onCardSelectedFromHand(card));
                cardCell.setGraphic(generateCardElement(card));
                
                handPlayer.getChildren().add(cardCell);
           
        });
    }
    
    
    /**
     * this method update the board and the hand
     */
    private void updateView() {
        updateBoardIA();
        updateBoardPlayer();
        updatePlayerHand();
    }
    
    /**
     * function connect to the end-turn button
     * 
     * @param event
     */
    @FXML
    private void onEndTrunButtonPress(Event event) {
        gameMaster.getBattlePhaseManager().startBattle(false);
        updateView();
        //TODO add here a timer or an animation to give to the player the time to understand what happened
        gameMaster.getDrawPhaseManager().draw(true);
        //TODO gameMaster.getMainPhaseManagerIA()
        updateView();
        //TODO add here a timer or an animation to give to the player the time to understand what happened
        gameMaster.getBattlePhaseManager().startBattle(true);
        updateView();
        //TODO add here a timer or an animation to give to the player the time to understand what happened
        gameMaster.getDrawPhaseManager().draw(false);
        
        
    }


}

package gamemaster;

import java.util.ArrayList;
import java.util.Optional;

import cards.Card;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;

public class BoardControllerImpl {
    
    GameMaster gameMaster;
    Optional<Integer> selectedCardToPlace;
    
    
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
    @FXML private ScrollPane handPlayer;
    
    
    public void initialize(){
        //TODO: add the deck here
        gameMaster= new GameMasterImpl(new ArrayList<Card>(), new ArrayList<Card>());
       
        //TODO: generate the elements for visualize the cards cards in the board for the IA
        
        //TODO: generate the elements for visualize the cards in the board for the player
        //TODO: generate the elements for visualize the cards in the hand of the player (scrollPane)
        
    }
    
    private VBox generateEmptyCardCell() {
        final VBox emptyCardCell = new VBox();
        
        return emptyCardCell;
    }
    
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
    private void onCardSelected(int cardPosInThePlayerHand) {
        selectedCardToPlace=Optional.of(cardPosInThePlayerHand);
    }
    
    /**
     * this function generate and then
     */
    private void updateView() {
        //TODO: update the elements for visualize the cards in the board for the player
        //TODO: update the elements for visualize the cards cards in the board for the IA
        //TODO: update the elements for visualize the cards in the hand of the player (scrollPane)
    }
    
    
    /**
     * function connect to the end-turn button
     * 
     * @param event
     */
    @FXML
    private void onEndTrunButtonPress(Event event) {
        // TODO Auto-generated method stub
    }


}

package in_script;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cards.Card;
import gamemaster.GameMasterControllerImpl;
import gamemaster.OnGameEnd;
import gamemaster.UpdateView;

public class GameMasterControllerTest {
    
    GameMasterControllerImpl gameMasterController;
    
    @BeforeEach
    void initialize() {
        final UpdateView updateBoardView = () -> {};
        final OnGameEnd onGameEnd = (String endMessage) -> {};
     
        this.gameMasterController = new GameMasterControllerImpl(updateBoardView,onGameEnd);
    }
    
    @Test
    void TestCardPlacing() {        
        
        final List<Optional<Card>> playerBoard = this.gameMasterController.getHumanPlayer().getCurrentBoard();
        final List<Card> playerHand =  this.gameMasterController.getHumanPlayer().getHand();
        
        while(playerHand.stream().filter(card -> card.getMana() <=  this.gameMasterController.getHumanPlayer().getCurrentMana()).count()<=0) {
            this.gameMasterController.onEndTurn();
        }
        
        assertEquals(Optional.empty(), this.gameMasterController.getCardToPlace());
        assertEquals(0,playerBoard.stream().filter(cardCell->cardCell.isPresent()).count());
  
        
        for(final Card card:playerHand) {
            if(card.getMana() <=  this.gameMasterController.getHumanPlayer().getMana()) {
                this.gameMasterController.onSelectCardToPlace(card);
                assertEquals(card.getIdCard(),this.gameMasterController.getCardToPlace().get().getIdCard());
                this.gameMasterController.onCardPlacing(0);
                assertEquals(card.getIdCard(),this.gameMasterController.getHumanPlayer().getCurrentBoard().get(0).get().getIdCard());
                assertEquals(Optional.empty(), this.gameMasterController.getCardToPlace());
                break;
            }
        }
    }
    
    @Test
    void TestCardToShow() {
        
        assertEquals(Optional.empty(),this.gameMasterController.getCardToShow());
        final Card cardToShow = this.gameMasterController.getHumanPlayer().getHand().get(0);
        this.gameMasterController.onSelectCardToShow(cardToShow);
        assertEquals(cardToShow.getIdCard(),this.gameMasterController.getCardToShow().get().getIdCard());
    
    }  
    
    @Test
    void TestOnEndTurn() {
        // this test is impossibile to write becouse the conditions are subject to change depending on AI choices,
        // card drawed stats and effect 
        
        /*
        while(this.gameMasterController.getIAPlayer().getHand().stream().filter(card -> card.getMana()<=
                this.gameMasterController.getIAPlayer().getCurrentMana()).count()<=0) {
            this.gameMasterController.onEndTurn();
        }
        
        final int currentHumanLife = this.gameMasterController.getHumanPlayer().getLifePoints();
        */
        
    } 
    
    
}

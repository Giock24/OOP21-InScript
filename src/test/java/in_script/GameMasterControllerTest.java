package in_script;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cards.Card;
import drawphasemanager.DrawPhaseManager;
import gamemaster.GameMasterControllerImpl;
import gamemaster.OnGameEnd;
import gamemaster.OnPhaseChange;
import gamemaster.UpdateView;
import shared.AppState;
import shared.AppStateSingleton;
import shared.Player;

public class GameMasterControllerTest {
    
    final AppState appState = AppStateSingleton.getInstance();
    DrawPhaseManager drawPhase;
    GameMasterControllerImpl gameMasterController;
    
    @BeforeEach
    void initialize() {
        final UpdateView updateBoardView = () -> {};
        final OnPhaseChange onPhaseChange = (String phase) -> {};
        final OnGameEnd onGameEnd = (String endMessage) -> {};
     
        this.gameMasterController = new GameMasterControllerImpl(updateBoardView,onPhaseChange,onGameEnd);
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
    void TestCardToShow() {}  
    
    @Test
    void TestOnEndTurn() {} 
    
    
}

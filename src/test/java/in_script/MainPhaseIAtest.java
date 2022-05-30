package in_script;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gamemaster.GameMaster;
import gamemaster.GameMasterImpl;
import shared.AppState;
import shared.AppStateSingleton;

public class MainPhaseIAtest {
    
    final AppState appState = AppStateSingleton.getInstance();
    final GameMaster gameMaster =  new GameMasterImpl(appState.getHumanPlayerDeck(), appState.getAIPlayerDeck());
  
   
    @Test
    void sigletonTest() {
            
    
        while(gameMaster.getIAPlayer().getHand().stream().filter(card -> card.getMana()<this.gameMaster.getIAPlayer().getCurrentMana()).count()<=0) {
            gameMaster.getDrawPhaseManager().draw(true);
        }
        
        assertEquals(0,this.gameMaster.getIAPlayer().getCurrentBoard().stream().filter(cell-> cell.isPresent()).count());
        
        final int prevCardInHand = this.gameMaster.getIAPlayer().getHand().size();
        
        this.gameMaster.getMainPhaseManagerAI().startAIMainPhase();
        
        final int cardPlaced = (int) this.gameMaster.getIAPlayer().getCurrentBoard().stream().filter(cell-> cell.isPresent()).count();
        
        assertTrue(cardPlaced> 0);
        
        final int expectedHandDimension = prevCardInHand-cardPlaced;
       
        assertEquals(expectedHandDimension,this.gameMaster.getIAPlayer().getHand().size());
    } 
    
}

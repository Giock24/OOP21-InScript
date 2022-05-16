package in_script;

import org.junit.jupiter.api.Test;

import drawphasemanager.DrawPhaseManager;
import gamemaster.GameMaster;
import gamemaster.GameMasterImpl;
import shared.AppState;
import shared.AppStateSingleton;
import shared.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

class DrawPhaseManagerTests {
    
    final static boolean PLAYER_TURN = false;
    final static boolean AI_TURN = true;
    
    final AppState appState = AppStateSingleton.getInstance();
    GameMaster gameMaster;
    DrawPhaseManager drawPhase;
    Player humanPlayer;
    Player aiPlayer;
    
    @BeforeEach
    void initialize() {
        this.gameMaster = new GameMasterImpl(appState.getHumanPlayerDeck(), appState.getAIPlayerDeck());
        this.drawPhase = this.gameMaster.getDrawPhaseManager();
        this.humanPlayer = this.gameMaster.getHumanPlayer();
        this.aiPlayer = this.gameMaster.getIAPlayer();
    }
    
    @Test
    void firstDraw() {
        assertEquals(26, this.humanPlayer.getDeck().size());
        assertEquals(26, this.aiPlayer.getDeck().size());
        
        this.drawPhase.firstDraw();
        
        assertEquals(23, this.humanPlayer.getDeck().size());
        assertEquals(23, this.aiPlayer.getDeck().size());
    }
    
    @Test
    void normalDraw() {
        assertEquals(26, this.humanPlayer.getDeck().size());
        assertEquals(26, this.aiPlayer.getDeck().size());
        
        this.drawPhase.draw(DrawPhaseManagerTests.AI_TURN);
        assertEquals(25, this.aiPlayer.getDeck().size());
        
        this.drawPhase.draw(DrawPhaseManagerTests.PLAYER_TURN);
        assertEquals(25, this.humanPlayer.getDeck().size());
    }
    
    @Test
    void manaRestored() {
        this.drawPhase.firstDraw();
        
        assertEquals(0, this.humanPlayer.getMana());
        assertEquals(0, this.aiPlayer.getMana());
        
        this.drawPhase.draw(DrawPhaseManagerTests.AI_TURN);
        assertEquals(1, this.aiPlayer.getMana());
        
        this.drawPhase.draw(DrawPhaseManagerTests.PLAYER_TURN);
        assertEquals(1, this.humanPlayer.getMana());
        
        this.drawPhase.draw(DrawPhaseManagerTests.AI_TURN);
        assertEquals(2, this.aiPlayer.getMana());
        
        this.drawPhase.draw(DrawPhaseManagerTests.PLAYER_TURN);
        assertEquals(2, this.humanPlayer.getMana());
    }
    
    @Test
    void drawWithoutMana() {
        this.drawPhase.drawWithoutMana(this.aiPlayer);
        assertEquals(0, this.aiPlayer.getMana());
        
        this.drawPhase.drawWithoutMana(this.humanPlayer);
        assertEquals(0, this.humanPlayer.getMana());
    }

}

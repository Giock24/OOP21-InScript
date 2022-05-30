package in_script;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cards.Card;
import gamemaster.GameMaster;
import gamemaster.GameMasterImpl;
import mainphasemanager.MainPhaseManager;
import shared.AppState;
import shared.AppStateSingleton;
import shared.Player;

class MainPhaseManagerTests {
    
    final static boolean PLAYER_TURN = false;
    final static boolean AI_TURN = true;

    final AppState appState = AppStateSingleton.getInstance();
    GameMaster gameMaster;
    MainPhaseManager mainPhase;
    Player humanPlayer;
    Player aiPlayer;
    
    @BeforeEach
    void initialize() {
        this.gameMaster = new GameMasterImpl(appState.getHumanPlayerDeck(), appState.getAIPlayerDeck());
        this.mainPhase = this.gameMaster.getMainPhaseManager();
        this.humanPlayer = this.gameMaster.getHumanPlayer();
        this.aiPlayer = this.gameMaster.getIAPlayer();
    }
    
    @Test
    void normalPositioning() {
        this.gameMaster.getDrawPhaseManager().firstDraw();
        this.humanPlayer.setCurrentMana(GameMaster.MAXIMUM_MANA);
        this.humanPlayer.setMana(GameMaster.MAXIMUM_MANA);
        
        assertEquals(3, this.humanPlayer.getHand().size());
        
        this.mainPhase.positioning(this.humanPlayer.getHand().get(0), 1, MainPhaseManagerTests.PLAYER_TURN);
        
        assertEquals(2,  this.gameMaster.getHumanPlayer().getHand().size());
    }
    
    @Test
    void cellFullDontPlace() {
        this.gameMaster.getDrawPhaseManager().firstDraw();
        this.humanPlayer.setCurrentMana(GameMaster.MAXIMUM_MANA);
        this.humanPlayer.setMana(GameMaster.MAXIMUM_MANA);
        
        this.mainPhase.positioning(this.humanPlayer.getHand().get(0), 1, MainPhaseManagerTests.PLAYER_TURN);
         
        assertEquals(2, this.humanPlayer.getHand().size());
        assertEquals(true, this.mainPhase.checkCellEmpty());
        
        this.mainPhase.positioning(this.humanPlayer.getHand().get(0), 1, MainPhaseManagerTests.PLAYER_TURN);
        
        assertEquals(2, this.humanPlayer.getHand().size());
        assertEquals(false, this.mainPhase.checkCellEmpty());
    }
    
    @Test
    void notEnoughtManaToPlaceCard() {
        this.gameMaster.getDrawPhaseManager().firstDraw();
        this.gameMaster.getDrawPhaseManager().draw(MainPhaseManagerTests.PLAYER_TURN);
        
        boolean stop = false;
        Card cardToPlace = null;
        while (!stop) {
            
            for (final var card : this.humanPlayer.getHand()) {
                if (card.getMana() > this.humanPlayer.getCurrentMana()) {
                    cardToPlace = card;
                    stop = true;
                    break;
                }   
            }
            
            this.gameMaster.getDrawPhaseManager().drawWithoutMana(this.aiPlayer);
        }
        final int actualHandSize = this.humanPlayer.getHand().size();
        
        assertEquals(actualHandSize, this.humanPlayer.getHand().size());
        
        this.mainPhase.positioning(cardToPlace, 1, MainPhaseManagerTests.PLAYER_TURN);
        
        assertEquals(actualHandSize, this.humanPlayer.getHand().size());
        assertEquals(false, this.mainPhase.checkCanPlace());

    }
    
}

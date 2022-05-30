package in_script;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import cards.Card;
import gamemaster.GameMaster;
import gamemaster.GameMasterImpl;
import shared.AppState;
import shared.AppStateSingleton;
import shared.Player;

public class GameMasterTest {

    final AppState appState = AppStateSingleton.getInstance();
    GameMaster gameMaster;
    Player humanPlayer;
    Player aiPlayer;
    
    @Test
    void PlayersInizialization() {
        
        final List<Card> humanPlayerDeck = appState.getHumanPlayerDeck();
        final List<Card> aiPlayerDeck = appState.getAIPlayerDeck();
        
        this.gameMaster = new GameMasterImpl(humanPlayerDeck, aiPlayerDeck);
        this.humanPlayer = this.gameMaster.getHumanPlayer();
        this.aiPlayer = this.gameMaster.getIAPlayer();

        assertEquals(GameMasterImpl.DEFAULT_PLAYER_LIFE, this.humanPlayer.getLifePoints());
        assertEquals(GameMasterImpl.DEFAULT_PLAYER_LIFE, this.aiPlayer.getLifePoints());
        
        assertEquals(GameMasterImpl.INITIAL_MANA, this.humanPlayer.getCurrentMana());
        assertEquals(GameMasterImpl.INITIAL_MANA, this.aiPlayer.getCurrentMana());
        
        assertEquals(GameMasterImpl.INITIAL_MANA, this.humanPlayer.getMana());
        assertEquals(GameMasterImpl.INITIAL_MANA, this.aiPlayer.getMana());
        
        assertEquals(false, this.humanPlayer.isAiPlayer());
        assertEquals(true, this.aiPlayer.isAiPlayer());
        
        if(Player.NUM_CARD_BOARD == 5) {
            final List<Optional<Card>> emptyBoard = new ArrayList<Optional<Card>>();
            emptyBoard.add(Optional.empty());
            emptyBoard.add(Optional.empty());
            emptyBoard.add(Optional.empty());
            emptyBoard.add(Optional.empty());
            emptyBoard.add(Optional.empty());
            
            assertEquals(new ArrayList<Optional<Card>>(emptyBoard), this.humanPlayer.getCurrentBoard());
            assertEquals(new ArrayList<Optional<Card>>(emptyBoard), this.aiPlayer.getCurrentBoard());
        }
        
        assertEquals(new ArrayList<Card>(), this.humanPlayer.getHand());
        assertEquals(new ArrayList<Card>(), this.aiPlayer.getHand());

        assertTrue(humanPlayerDeck.size() == this.humanPlayer.getDeck().size() && humanPlayerDeck.containsAll(this.humanPlayer.getDeck()));
        assertTrue(aiPlayerDeck.size() == this.aiPlayer.getDeck().size() && aiPlayerDeck.containsAll(this.aiPlayer.getDeck()));
        
        //decks must be a copy of the originals
        assertNotEquals(appState.getHumanPlayerDeck(),this.humanPlayer.getDeck());
        assertNotEquals(appState.getAIPlayerDeck(),this.aiPlayer.getDeck());
    }
    
    @Test
    void PhaseManagersInizialization() {
        
        this.gameMaster = new GameMasterImpl(appState.getHumanPlayerDeck(),appState.getAIPlayerDeck());
        assertNotNull( this.gameMaster.getDrawPhaseManager());
        assertNotNull( this.gameMaster.getMainPhaseManager());
        assertNotNull( this.gameMaster.getMainPhaseManagerAI());
        assertNotNull( this.gameMaster.getBattlePhaseManager());
    }
    
    @Test
    void StartGame() {
        this.gameMaster = new GameMasterImpl(appState.getHumanPlayerDeck(),appState.getAIPlayerDeck());
        this.humanPlayer = this.gameMaster.getHumanPlayer();
        this.aiPlayer = this.gameMaster.getIAPlayer();
        this.gameMaster.startGame();
        assertEquals(GameMaster.INTIAL_NUM_CARDS_IN_HAND+1,this.humanPlayer.getHand().size()+this.humanPlayer.getCurrentBoard().stream().filter(element -> element.isPresent()).count());
        assertEquals(GameMaster.INTIAL_NUM_CARDS_IN_HAND+1,this.aiPlayer.getHand().size()+this.aiPlayer.getCurrentBoard().stream().filter(element -> element.isPresent()).count());
    }
    
}

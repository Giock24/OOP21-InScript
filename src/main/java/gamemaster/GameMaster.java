package gamemaster;

import battlephasemanager.BattlePhaseManager;
import drawphasemanager.DrawPhaseManager;
import mainphasemanager.MainPhaseManager;
import mainphasemanager.MainPhaseManagerIA;
import shared.Player;

public interface GameMaster {
    
    int DEFAULT_PLAYER_LIFE = 0;
    int MIN_PLAYER_LIFE = -10;
    int INITIAL_MANA = 0;
    
    /**
     * this is the number of card that each player have in the hand before the drawingPhase
     */
    int INTIAL_NUM_CARDS_IN_HAND = 3;
    
    boolean startGame();
    
    Player getHumanPlayer();
    
    Player getIAPlayer();
    
    DrawPhaseManager getDrawPhaseManager();
    
    MainPhaseManager getMainPhaseManager();
    
    BattlePhaseManager getBattlePhaseManager();
    
    MainPhaseManagerIA getMainPhaseManagerAI();
}

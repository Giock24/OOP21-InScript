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
    int MAXIMUM_MANA = 10;
    int MANA_PLUS_ONE = 1;
    
    /**
     * this is the number of card that each player have in the hand before the drawingPhase
     */
    int INTIAL_NUM_CARDS_IN_HAND = 3;
    
    /**
     * this method is meat to be call for doing some setup operation when the game start 
     */
    void startGame();
    
    /**
     * this method is meat to be call for receive the user player
     * 
     * @return is the user player 
     */
    Player getHumanPlayer();
    
    /**
     * this method is meat to be call for receive the AI player
     * 
     * @return is the AI player 
     */
    Player getIAPlayer();
    
    /**
     * this method is meat to be call for receive the the manager for the Draw Phase player
     *
     * @return an instance of the DrawPhaseManager
     */
    DrawPhaseManager getDrawPhaseManager();
    
    /**
     * this method is meat to be call for receive the the manager for the Main Phase player
     *
     * @return an instance of the MainPhaseManager
     */
    MainPhaseManager getMainPhaseManager();
    
    /**
     * this method is meat to be call for receive the the manager for the Battle Phase player
     *
     * @return an instance of the BattlePhaseManager
     */
    BattlePhaseManager getBattlePhaseManager();
    
    /**
     * this method is meat to be call for receive the the manager for the Main Phase AI player
     *
     * @return an instance of the MainPhaseManagerAI
     */
    MainPhaseManagerIA getMainPhaseManagerAI();
}

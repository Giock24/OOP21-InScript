package gamemaster;

import shared.Player;

public interface GameMaster {
    
    int DEFAULT_PLAYER_LIFE = 0;
    int INITIAL_MANA = 0;
    
    boolean startGame();
    
    Player getHumanPlayer();
    
    Player getIAPlayer();
}

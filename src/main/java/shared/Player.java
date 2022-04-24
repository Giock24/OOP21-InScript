package shared;

import java.util.List;
import java.util.Optional;

import cards.Card;

public interface Player {
    
    int NUM_CARD_BOARD=5;
    
    /**
     * @return true if the player is the AI player
     */
    boolean isAiPlayer();

    /**
     * @return the current Deck
     */
    List<Card> getDeck();
    
    /**
     * @return the current life point
     */
    int getLifePoints();
	
    int getMana();
	
    /**
     * @return the current mana
     */
    int getCurrentMana();
	
    /**
     * @return the current board
     */
    List<Optional<Card>> getCurrentBoard();
	
    /**
     * @return return the current Hand
     */
    List<Card> getHand();

    /* probabilmente ci saranno anche i metodi per modificare i valori*/
	
    /**
     * @param mana the value that decreases current mana
     */
    void setMana(int mana);
    
    /**
     * @param board the new board state after battle and or positioning
     */
    void setCurrentBoard(List<Optional<Card>> board);
    
    /**
     * @param life the new life of current player
     */
    void setLifePoints(int life);

}

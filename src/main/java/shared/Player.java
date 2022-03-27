package shared;

import java.util.List;

import cards.Card;

public interface Player {

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
    List<Card> getCurrentBoard();
	
    /**
     * @return return the current Hand
     */
    List<Card> getHand();

    /* probabilmente ci saranno anche i metodi per modificare i valori*/
	
    /**
     * @param mana the value that decreases current mana
     */
    void setMana(int mana);
}

package shared;

import java.util.ArrayList;

import cards.Card;

public interface Player {

    /**
    * @return the current Deck
    */
    ArrayList<Card> getDeck();
    
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
    ArrayList<Card> getCurrentBoard();
    	
    /**
     * @return return the current Hand
     */
    ArrayList<Card> getHand();
    
    /* probabilmente ci saranno anche i metodi per modificare i valori*/
    	
    /**
     * @param mana the value that decreases current mana
     */
    void setMana(int mana);
    	
    void setLifePoints(int newValueOfLife); //newValueOfLife is the new value of player life
}

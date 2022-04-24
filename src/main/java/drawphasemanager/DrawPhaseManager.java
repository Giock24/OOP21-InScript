package drawphasemanager;

import java.util.List;

import cards.Card;
import shared.PhaseManager;

public interface DrawPhaseManager extends PhaseManager {
    
    int INITAL_CARD_IN_THE_HAND = 4;
		
    /**
     *     adds a card on the player's hand and increases the mana
     * 
     * @param isTheAIturn is true if is IA turn
     * 
     * @return return true if the game END
     */
    boolean draw(boolean isTheAIturn);
    
    /**
     *     adds 4 card on the player's hand and increases the mana
     * 
     * @param isTheAIturn
     */
    void firstDraw(boolean isTheAIturn);
    
    /**
     * 
     *    adds a card on the player's hand without increment of mana
     * 
     * @param isTheAITurn
     */
    void drawWithoutMana(boolean isTheAITurn);
    
    /* questi metodi sono solo usati per il testing col tempo verranno rimossi */
    List<Card> getCurrentDeck();
    
    List<Card> getCurrentHand();
}

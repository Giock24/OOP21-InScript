package drawphasemanager;

import shared.PhaseManager;
import shared.Player;

public interface DrawPhaseManager extends PhaseManager {
    
    int INITAL_CARD_IN_THE_HAND = 3;
    int NO_MORE_CARDS = 0;
		
    /**
     *     adds a card on the player's hand and increases the mana
     * 
     * @param isTheAIturn is true if is IA turn
     * 
     */
    void draw(boolean isTheAIturn);
    
    /**
     *     adds 3 cards on each player's hand
     * 
     * @param isTheAIturn
     */
    void firstDraw();
    
    /**
     * 
     *    adds a card on the player's hand without increment of mana
     * 
     * @param isTheAITurn
     */
    void drawWithoutMana(Player player);
    
}

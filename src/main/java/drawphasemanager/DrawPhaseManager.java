package drawphasemanager;

import shared.PhaseManager;
import shared.Player;

public interface DrawPhaseManager extends PhaseManager {
    
    int INITAL_CARD_IN_THE_HAND = 4;
    int NO_MORE_CARDS = 0;
		
    /**
     *     adds a card on the player's hand and increases the mana
     * 
     * @param isTheAIturn is true if is IA turn
     * 
     */
    void draw(boolean isTheAIturn);
    
    /**
     *     adds 4 card on the player's hand and increases the mana
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

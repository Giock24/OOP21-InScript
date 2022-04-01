package drawphasemanager;

import java.util.List;

import cards.Card;
import shared.PhaseManager;

public interface DrawPhaseManager extends PhaseManager {
	
    /**
     *     when called set mana and update the GUI.
     * 
     * @param isTheAIturn is true if is IA turn
     */
    void draw(boolean isTheAIturn);
    
    /* questi metodi sono solo usati per il testing col tempo verranno rimossi */
    List<Card> getCurrentDeck();
    
    List<Card> getCurrentHand();
}

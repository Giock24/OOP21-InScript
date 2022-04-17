package drawphasemanager;

import java.util.List;

import cards.Card;
import shared.PhaseManager;
import shared.Player;

public interface DrawPhaseManager extends PhaseManager {
	
    /**
     *     In futuro aggiungeremo il parametro per passare la BoardGUI.
     *     when called you can manage hands of
     *     each Player using the boardGUI.
     * 
     * @param player is the player that interact with GUI
     * @param playerIA is an IA that makes auto moves
     */
    void drawPhaseManager(Player player, Player playerIA);
	
    /**
     *     when called set mana and update the GUI.
     * 
     * @param isTheAIturn is true if is IA turn
     * 
     * @return return true if the game END
     */
    boolean draw(boolean isTheAIturn);
    
    /* questi metodi sono solo usati per il testing col tempo verranno rimossi */
    List<Card> getCurrentDeck();
    
    List<Card> getCurrentHand();
}

package drawphasemanager;

import shared.PhaseManager;
import shared.Player;

public interface ControllerDrawPhase extends PhaseManager {
	
	/**
	 * 		In futuro aggiungeremo il parametro per passare la BoardGUI.
	 * 		when called you can manage hands of
	 * 		each Player using the boardGUI.
	 * 
	 * @param player is the player that interact with GUI
	 * @param playerIA is an IA that makes auto moves
	 */
	void drawPhaseManager(Player player, Player playerIA);
	
	/**
	 *		when called set mana and update the GUI.
	 * 
	 * @param isTheAIturn is true if is IA turn
	 */
    void draw(boolean isTheAIturn);
}

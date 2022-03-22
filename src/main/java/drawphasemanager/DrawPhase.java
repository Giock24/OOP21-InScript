package drawphasemanager;

import shared.Player;

public interface DrawPhase {
	
	/**
	 * 		when called increment +1 Player's mana.
	 * 
	 */
	void incrementMana();
	
	/**
	 * 		when called you can decide to swap:
	 * 		from Player turn to IA turn or vice versa
	 * 
	 * @param newPlayer is the player set (Player or IA)
	 */
	void setStatus(Player newPlayer);

}

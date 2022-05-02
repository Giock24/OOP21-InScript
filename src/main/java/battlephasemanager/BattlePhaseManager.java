package battlephasemanager;

import shared.PhaseManager;

public interface BattlePhaseManager extends PhaseManager {
    
    /**
     * the card of the owner of the turn attack the cards of the other player
     * inside this function are also handle the effect that will be activated in that phase
     * 
     * @param isTheAIturn
     */
    void startBattle(boolean isTheAIturn);
}

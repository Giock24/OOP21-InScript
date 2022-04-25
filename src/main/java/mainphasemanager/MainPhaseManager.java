package mainphasemanager;

import cards.Card;
import shared.PhaseManager;

public interface MainPhaseManager extends PhaseManager {
    
    int NO_ENOUGH_MANA = 0;
    
    /**
     * this method will be call for move a card from the hand of a player to his board
     * it also internally handle the effect that will be trigger in this phase
     * 
     * @param cardToBePositioned
     * @param boardCellIndex
     */
    void positioning( Card cardToBePositioned, int boardCellIndex, boolean isTheAITurn);
    
    /**
     * @return true if can place that card otherwise false
     */
    boolean checkCanPlace();
    
    /**
     * @return true if is empty otherwise false
     */
    boolean checkCellEmpty();
}

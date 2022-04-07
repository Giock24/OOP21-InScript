package mainphasemanager;

import cards.Card;
import shared.PhaseManager;

public interface MainPhaseManager extends PhaseManager {
    
    /**
     * this method will be call for move a card from the hand of a player to his board
     * it also internally handle the effect that will be trigger in this phase
     * 
     * @param isTheAIturnn define if the card is taken from the player or from the IA player
     * @param cardToBePositioned
     * @param boardCellIndex
     */
    void positioning(boolean isTheAIturn, Card cardToBePositioned, int boardCellIndex);
}

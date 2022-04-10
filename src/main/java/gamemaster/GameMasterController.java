package gamemaster;

import java.util.Optional;
import cards.Card;
import shared.Player;

/**
 * the function pass with this interface will be call for update the view after a change
 *
 */
@FunctionalInterface
interface UpdateView {
    void update();
}

/**
 * the function pass with this interface will be call for slow down the update during the IA turn
 * and let the user understand the change 
 *
 */
@FunctionalInterface
interface SlowUpdate {
    void slow();
}

public interface GameMasterController {
    
    //TODO this methods must be called in a updateView Method inside the view//;
    
    Optional<Card> getCardToShow();
    Optional<Card> getCardToPlace();
    
    Player getHumanPlayer();
    Player getIAPlayer();
    
    //////////////////////////////////////

    
    void onSelectCardToShow(UpdateView updateView);
    
    void onSelectCardToPlace(UpdateView updateView);
    
    
    void onPlaceCard(UpdateView updateView);
    
    void onEndTurn(UpdateView updateView,SlowUpdate slowUpdate);
}

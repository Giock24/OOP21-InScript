package gamemaster;

import java.util.Optional;
import cards.Card;
import shared.Player;

public interface GameMasterController {
    
    //TODO this methods must be called in a updateView Method inside the view//;
    
    Optional<Card> getCardToShow();
    Optional<Card> getCardToPlace();
    
    Player getHumanPlayer();
    Player getIAPlayer();
    
    //////////////////////////////////////

    
    void onSelectCardToShow(Card card);
    
    void onSelectCardToPlace(Card card);
    
    void onCardPlacing(int indexOfTheCellInTheBoard);
    
    void onEndTurn();
}
package gamemaster;

import java.util.Optional;
import cards.Card;
import shared.Player;

public interface GameMasterController {
    
    String GameOverWinMessage="You Win";
    String GameOverLoseMessage="You Lose";
    String GameOverTieMessage="Tie - there are no more cards to draw";
    
    /**
     * this method is meat to be call for receive the card in evidence.
     *
     * @return the card in evidence. it can be null
     */
    Optional<Card> getCardToShow();
    
    /**
     * this method is meat to be call for receive the card that as been selected as "card to place"
     * which is the card that will be placed next time we touch the board
     *
     * @return the card to place. it can be null
     */
    Optional<Card> getCardToPlace();
    
    /**
     * this method is meat to be call for receive the user player
     * 
     * @return is the user player 
     */
    Player getHumanPlayer();
    
    /**
     * this method is meat to be call for receive the AI player
     * 
     * @return is the AI player 
     */
    Player getIAPlayer();
    
    /**
     * this method is meat to be call for set the "card in evidence"
     * 
     * @param card
     */
    void onSelectCardToShow(Card card);
    
    /**
     * this method is meat to be call for set the "card to place"
     * which is the card that will be placed next time we touch the board 
     * 
     * @param card
     */
    void onSelectCardToPlace(Card card);
    
    /**
     * this method is meat to be call when the user try to place a card on the board
     * 
     * the indexOfTheCellInTheBoard must be the index of the board of the user where we are
     * Trying to place the card
     * 
     * @param indexOfTheCellInTheBoard
     */
    void onCardPlacing(int indexOfTheCellInTheBoard);
    
    /**
     * this method is meat to be call when the user pass the turn
     * it will execute the turn of the AI and the Battle Phase and the
     * Draw Phase of the Player
     * 
     */
    void onEndTurn();
}

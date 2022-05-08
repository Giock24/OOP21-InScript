package gamemaster;

import java.util.Optional;
import cards.Card;
import shared.Player;

public interface GameMasterController {
    
    String GameOverWinMessage="You Win";
    String GameOverLoseMessage="You Lose";
    String GameOverTieMessage="Tie - there are no more cards to draw";
    
    String DrawPhaseAIMessage = "Fase di pescata del nemico";
    String DrawPhaseMessage = "Fase di pescata del giocatore";
    String MainPhaseAIMessage = "Fase di posizionamento del nemico";
    String MainPhaseMessage = "Fase di posizionamento del giocatore";
    String BattlePhaseAIMessage = "Fase di battaglia del nemico";
    String BattlePhaseMessage ="Fase di battaglia del giocatore";
    
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

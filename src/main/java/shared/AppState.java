package shared;

import java.util.List;
import java.util.Map;

import cards.Card;

public interface AppState {
    
    Map<String, List<Card>> getDecksList();
    
    List<Card> getHumanPlayerDeck();
    
    List<Card> getAIPlayerDeck();
    
    void selectHumanPlayerDeck(String deckName);
    
    void selectAIPlayer(String deckName);
    
    void demoveDeck(String deckName);
    
    void addDeck(String deckName,List<Card> newDeck);
    
}

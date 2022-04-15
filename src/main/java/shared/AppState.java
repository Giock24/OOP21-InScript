package shared;

import java.util.List;

import cards.Card;

public interface AppState {
   
    List<List<Card>> getDecksList();
    
    List<Card> getHumanPlayerDeck();
    
    List<Card> getAIPlayerDeck();
    
    void selectHumanPlayerDeck(int indexOfTheDeckList);
    
    void selectAIPlayer(int indexOfTheDeckList);
    
    void demoveDeck(int indexOfTheDeckList);
    
    void addDeck(List<Card> newDeck);
    
}

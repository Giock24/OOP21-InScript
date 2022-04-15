package shared;

import java.util.List;

import cards.Card;

public interface AppState {
   
    List<List<Card>> getDecksList();
    
    List<Card> getHumanPlayerDeck();
    
    List<Card> getAIPlayerDeck();
    
    boolean selectHumanPlayerDeck(int indexOfTheDeckList);
    
    boolean selectAIPlayer(int indexOfTheDeckList);
    
    boolean demoveDeck(int indexOfTheDeckList);
    
    boolean addDeck(List<Card> newDeck);
    
}
